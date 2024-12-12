// import java.util.  Scanner, Random
//

public class StorageLockerApp2 {

    // Define global variables, data types
    public static String userLockerID;
    public static String userLockerPin;

    // Create integer variable total 10 lockers
    public static int totalAvailableLockers = 10;

    // boolean lockerAvailable[]
    public static String[] lockerID = new String[totalAvailableLockers];
    public static String[] lockerPIN = new String[totalAvailableLockers];
    public static boolean[] lockerAvailable = new boolean[totalAvailableLockers];


    // Set up new scanner instance


    public static void main(String[] args) {

        lockerID[0] = "A1";
        lockerPIN[0] = "000000";
        lockerAvailable[0] = false;
        lockerID[1] = "A2";
        lockerPIN[1] = "00000";
        lockerAvailable[1] = true;
        lockerID[2] = "A3";
        lockerPIN[2] = "00000";
        lockerAvailable[2] = false;
        lockerID[3] = "A4";
        lockerPIN[3] = "00000";
        lockerAvailable[3] = true;
        lockerID[4] = "A5";
        lockerPIN[4] = "000000";
        lockerAvailable[4] = false;
        lockerID[5] = "A6";
        lockerPIN[5] = "000000";
        lockerAvailable[5] = true;
        lockerID[6] = "A7";
        lockerPIN[6] = "000000";
        lockerAvailable[6] = false;
        lockerID[7] = "A8";
        lockerPIN[7] = "0000000";
        lockerAvailable[7] = true;

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

        displayMainMenu();


    }


    /// Methods

    // displayMainMenu()
    /*
       What would you like to do next?
       If there is locker available. Print 1. Rent a locker.
       2. Access a locker
       3. Release a locker
       --- Any other key to exit
     */
    public static void displayMainMenu(){
        System.out.println("What would you like to do next?");
        if (totalAvailableLockers > 0) {
            System.out.print("1. Rent a Locker");
        }
        System.out.println("\n2. Access a Locker \n3. Release a Locker \n" +
                    "--- \nAny other key to exit.");
        }

    // displayChoices() return String

    // getChoice()

    // rentLocker()

    // accessLocker()

    // releaseLocker()

    // getAvailableLocker()

    public static void getAvailableLocker(){
        boolean isLockerAvailable = false;
        int i = 0;
        while (!isLockerAvailable) {
            isLockerAvailable = lockerAvailable[i];
            i++;
        }
        userLockerID = lockerID[i];
        userLockerPin = lockerPIN[i];
        System.out.println(userLockerID);
        System.out.println();
    }

    // generatePin()

    // printReceipt()

    // isLockerNumberValid()

    // getLockerNumber()

    // openLocker()

    // getInt()

    // getString()



}
