// import java.util.  Scanner, Random
//

import java.util.Random;
import java.util.Scanner;

public class LockerAppExp {

    // Define global variables, data types
    public static String userLockerID;
    public static String userLockerPin;

    // Create integer variable total 10 lockers
    public static int totalAvailableLockers = 10;

    // boolean lockerAvailable[]
    public static String[] lockerID = {"A1", "A2", "A3","A4","A5","A6","A7","A8","A9","A10"};
    public static String[] lockerPIN = {"0000", "0000,","00000","00000","000","0000","0000","0000", "0000", "0000"};
    public static boolean[] lockerAvailable = new boolean[totalAvailableLockers];


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
        if (getAnAvailableLocker() != -1) {
            System.out.print("1. Rent a Locker");
        }
        System.out.println("\n2. Access a Locker \n3. Release a Locker \n" +
                    "--- \nAny other key to exit.");
        }

    // displayChoices() return String
    public static void displayChoices(String[] displayOptions, boolean[] available) {
        for (int i = 0; i < displayOptions.length; i++) {
            if (available[i]){
                System.out.println(i + 1 + ": " + displayOptions[i]);
            }
            }
     }

    // getChoice()
    public static int getChoice(){
        Scanner console = new Scanner(System.in);
        return getInt();
    }

    // rentLocker()
    public static void rentLocker(String lockerNumber, String pin){
        System.out.println("Thank you.\n Your locker number is "+ lockerNumber +"\nYour locker pin is "+ pin);
    }


    // accessLocker()
    public static void accessLocker(){
        displayChoices(lockerID,lockerAvailable);
        boolean checkLocker = isLockerNumberValid(lockerID);
            if (checkLocker) {
                System.out.println("Enter PIN");
            }


        }

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

    public static int getAnAvailableLocker(){
        int firstAvailableLocker = -1;
        for (int i = 0; i < lockerAvailable.length; i++){
            if (lockerAvailable[i]){
                return i;
            }
        }
       return firstAvailableLocker;

    }

    // generatePin()
    public static String generatePin() {
        Random random = new Random();
        String randomPin = Integer.toString(random.nextInt(99));
        return randomPin;
    }

    // printReceipt()

    // isLockerNumberValid()
    public static boolean isLockerNumberValid(String[] lockerID){
    boolean found = false;
    String getLocker = getLockerNumber();
    // Iterate through the array to check if the target exists
        for (String element : lockerID) {
            if (element.equals(getLocker)) {
                found = true;
                break;
            }
        }
        return found;
    }

    // getLockerNumber()
    public static String getLockerNumber(){
        Scanner console = new Scanner(System.in);
        System.out.println("Please enter a locker number.");
        String enteredLocker = console.nextLine();
        return enteredLocker;
    }

    // openLocker()

    // getInt()
    public static int getInt(){
            Scanner console = new java.util.Scanner(System.in);
            int i = 0;
            while (i == 0){
                try {
                    i = Integer.parseInt(console.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Enter a valid number");
                }
            }
            return i;
        }
    }


    // getString()


