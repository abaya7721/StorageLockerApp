import java.util.Random;
import java.util.Scanner;

public class StorageLockerApp {

    // Define global variables, data types
    public static String userLockerID;
    public static String userLockerPin;

    // Create integer variable total 10 lockers
    public static int totalAvailableLockers = 10;

    // boolean lockerAvailable[]
    public static String[] lockerID = {"A1", "A2", "A3"};
    public static String[] lockerPIN = {"00001", "00002,", "000003"};
    public static boolean[] lockerAvailable = {true, true, true};


    // Set up new scanner instance


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
        while (true) {
            displayMainMenu();
            int menuChoice = getChoice();
            if (menuChoice == 1) {
                rentLocker();
            }
            //getAnAvailableLocker();

        }


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

    // displayChoices() return String

    // getChoice()
    public static int getChoice() {
        Scanner console = new Scanner(System.in);
        return Integer.parseInt(console.nextLine());
    }

    // rentLocker()
    public static void rentLocker() {
        int firstAvailableLocker = getAnAvailableLocker();
        System.out.println("Locker " + lockerID[firstAvailableLocker]);
        System.out.println("PIN " + lockerPIN[firstAvailableLocker] + " Thanks for renting.");
        lockerAvailable[firstAvailableLocker] = false;
    }

    // accessLocker()

    // releaseLocker()

    // generatePin()

    // printReceipt()

    // isLockerNumberValid()

    // openLocker()

    // getInt()

    // getString()
}