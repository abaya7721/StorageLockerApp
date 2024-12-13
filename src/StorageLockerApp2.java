import java.util.Scanner;

public class StorageLockerAppWorking {

    // Create integer variable total 10 lockers
    public static int totalAvailableLockers = 10;

    // Define global variables, data types
    public static String[] lockerID = {"A1", "A2", "A3"};
    public static String[] lockerPIN = {"0001", "0002,", "0003"};
    public static boolean[] lockerAvailable = {true, true, true};

    public static boolean appRunning = true;



    public static void main(String[] args) {
        /*
    1. Display main menu.
     Main menu has 4 options
         1 Rent a locker
         2 Access a locker
         3 Release a locker
         4 Exit */


     /*
     2. User rents a locker
        - find first available locker
            - While looking through lockers if locker is full continue to next locker
              until available locker is found and exit
            - Collect locker ID, locker PIN, update locker to unavailable
        - Provide PIN (make random once everything else works)
        - Thank you, print lock number and pin and instructions
        - Display main menu

     3. User accesses a locker
        - Enter locker number
        Check
        - locker is rented
            Enter locker number again
        - locker not rented
            Enter pin.
               Verify Pin correct - print success lock it up - display main menu

     4. User releases a locker
         - * access a locker
         - Is user sure
         - Yes. Locker has not been released. Display start menu
         - No. Success locker available. Set PIN to null.

     5. User Exit
        - exit application

     */

        while (appRunning) {
            displayMainMenu();
            int menuChoice = getChoice();
            switch(menuChoice) {
                case 1:
                    rentLocker();
                    break;
                case 2:
                    accessLocker(false);
                    break;
                case 3:
                    System.out.println("This will start the locker release.");
                    accessLocker(true);
                    break;
                default:
                    System.out.println("Exiting Application");
                    break;
            }


        }

    }

    /// Methods
    public static void displayMainMenu() {
        System.out.println("What would you like to do next?");
        if (getAnAvailableLocker() != -1) {
            System.out.print("1. Rent a Locker");
        }
        System.out.println("\n2. Access a Locker \n3. Release a Locker \n" +
                "--- \nAny other key to exit.");
    }

    public static int getAnAvailableLocker() {
        int firstAvailableLocker = -1;
        for (int i = 0; i < lockerAvailable.length; i++) {
            if (lockerAvailable[i]) {
                return i;
            }
        }
        return firstAvailableLocker;

    }

    // displayChoices()
    public static void displayChoices(String[] displayOptions, boolean[] available) {
        int lockersBeingUsed = 0;
        for (int i = 0; i < displayOptions.length; i++) {
            if (!available[i]){
                lockersBeingUsed ++;
                System.out.println(displayOptions[i]);
            }
        }
        System.out.println("There are " + lockersBeingUsed + " lockers in use, including yours." );
    }

    // countOpenLockers
    public static int countLockersOpen(String[] displayOptions, boolean[] available) {
        int lockersOpen = 0;
        for (int i = 0; i < displayOptions.length; i++) {
            if (available[i]){
                lockersOpen ++;
            }
        }
        return lockersOpen;
    }

    // getChoice()
    public static int getChoice() {
        Scanner console = new Scanner(System.in);
        int choice=0;
        try{
            choice = Integer.parseInt(console.nextLine());
        }
        catch (Exception e ){
            appRunning = false;
        }
        return choice;
    }

    // rentLocker()
    public static void rentLocker() {
        int firstAvailableLocker = getAnAvailableLocker();
        System.out.println("Locker " + lockerID[firstAvailableLocker]);
        System.out.println("PIN " + lockerPIN[firstAvailableLocker] + " Thanks for renting.");
        lockerAvailable[firstAvailableLocker] = false;
    }

    // accessLocker()
    public static void accessLocker(boolean release){
        int lockers = countLockersOpen(lockerID,lockerAvailable);
        System.out.println(lockers);
        if (lockers < lockerID.length) {

            displayChoices(lockerID, lockerAvailable);
            String enteredLocker = getLockerNumber();
            int lockerIndex = getLockerIndex(enteredLocker, lockerID);
            boolean checkLocker = isLockerNumberValid(lockerID, enteredLocker);

            if (checkLocker && release) {
                releaseLocker(lockerIndex);
            } else if (checkLocker && !release) {
                openLocker(lockerIndex);
            } else if (!checkLocker) {
                System.out.println("Enter a valid locker number.");
            }
            //lockers = countLockersOpen(lockerID, lockerAvailable);
        }
        else {
            System.out.println("You need to rent a locker first.");
        }
    }

    // releaseLocker()
    public static void releaseLocker(int index){
        System.out.println("You are about to release a locker.");
        lockerReleaseConfirm(index);
    }

    // generatePin()

    // printReceipt()

    // getLockerNumber
    public static String getLockerNumber(){
        Scanner console = new Scanner(System.in);
        System.out.println("Enter your locker number to access.");
        String enteredLocker = console.nextLine();
        return enteredLocker;
    }

    // lockerIndex
    public static int getLockerIndex(String lockerNumber, String[] lockers) {
        int index = -1;
        // Iterate through the array to check if the target exists
        for (String element : lockers) {
            index ++;
            if (element.equals(lockerNumber)) {
                break;
            }
        }
        return index;
    }

    // isLockerNumberValid()
    public static boolean isLockerNumberValid(String[] lockerID, String getLocker){
        boolean found = false;

        for (String element : lockerID) {
            if (element.equals(getLocker)) {
                found = true;
                break;
            }
        }
        return found;
    }

    // lockerReleaseConfirm
    public static void lockerReleaseConfirm(int lockerPinIndex) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter PIN");
        String PIN = console.nextLine();

        if (Integer.parseInt(PIN) == Integer.parseInt(lockerPIN[lockerPinIndex])) {
            System.out.println("Locker will be released. Are you sure? (y)");

            if("y".equals(console.nextLine())){
                System.out.println("Locker released.");
                lockerAvailable[lockerPinIndex] = true;
                lockerPIN[lockerPinIndex] = null;
            }
            else {
                System.out.println("Invalid entry. Not released");;
            }
        }
          else {  System.out.println("Invalid PIN. Not released \n Exiting.");
    }
    }

    // openLocker()
    public static void openLocker(int lockerPinIndex) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter PIN");
        String PIN = console.nextLine();
        if (Integer.parseInt(PIN) == Integer.parseInt(lockerPIN[lockerPinIndex])) {
            System.out.println("Locker Opened");
            closeLocker(lockerPinIndex);
        }
        else {
            System.out.println("Wrong pin");
        }

    }

    // closeLocker()
    public static void closeLocker(int lockerPinIndex) {
        Scanner console = new Scanner(System.in);
        System.out.println("Re-Enter PIN to close");
        String PIN = console.nextLine();
        if (Integer.parseInt(PIN) == Integer.parseInt(lockerPIN[lockerPinIndex])) {
            System.out.println("Locker Closed");
        }
        else {
            System.out.println("Wrong pin");
        }

    }

}