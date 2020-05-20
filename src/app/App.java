package app;
import java.util.Scanner; 
import java.util.InputMismatchException;

public class App {
    public static void main(String[] args) throws Exception {
        mainMenu();
        
    }// main

    public static void mainMenu() {
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("\n\n");
            System.out.println("Welcome to the Community Library");
            System.out.println("===========Main Menu============");
            System.out.println("1. Staff Login");
            System.out.println("2. Member Login");
            System.out.println("0. Exit");
            System.out.println("================================\n");
            System.out.print("Please make a selection (1-2, or 0 to exit): ");

            
            int selection = 9; //set garbage int value to force default case on InputMismatchException

            try {
                selection = input.nextInt();
            } catch (InputMismatchException e) {
                //System.out.println("Invalid selection");
            }

            switch (selection) {
                case 1:
                    //credential verification
                    System.out.print("Enter username: ");
                    String username = "Kate";

                    username = input.nextLine();
                    System.out.println(username);

                    //staffMenu();
                    
                    break;
                case 2:
                    //TODO: implement credential verification
                    memberMenu();
                    break;
                case 0:
                    System.out.println("Leaving the program now...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid selection");
                    //break;
            }// end switch
        }// end while
    }// function mainMenu

    public static void staffMenu() {
        Scanner input = new Scanner(System.in);
        boolean displayMenu = true;

        while(displayMenu) {
            System.out.println("\n\n");
            System.out.println("===========Staff Menu===========");
            System.out.println("1. Add a new movie DVD");
            System.out.println("2. Remove a movie DVD");
            System.out.println("3. Register a new Member");
            System.out.println("4. Find a registered member's phone number");
            System.out.println("0. Return to main menu");
            System.out.println("================================");
            System.out.print("Please make a selection (1-4, or 0 to return to main menu): ");

            int selection = 9; //set garbage int value to force default case on InputMismatchException

            try {
                selection = input.nextInt();
            } catch (InputMismatchException e) {
                //System.out.println("Invalid selection");
            }

            switch (selection) {
                case 1:
                    System.out.println("add a new DVD");
                    break;
                case 2:
                    System.out.println("remove a DVD");
                    break;
                case 3:
                    System.out.println("register member");
                    break;
                case 4:
                    System.out.println("find phone no.");
                    break;
                case 0:
                    System.out.println("Returning to Main Menu...");
                    displayMenu = false;
                    break;
                default:
                    System.out.println("Invalid selection");
            }// end switch

        }// end while
    }// function staffMenu

    public static void memberMenu() {
        Scanner input = new Scanner(System.in);
        boolean displayMenu = true;

        while(displayMenu) {
            System.out.println("\n\n");
            System.out.println("===========Member Menu==========");
            System.out.println("1. Display all movies");
            System.out.println("2. Borrow a movie DVD");
            System.out.println("3. Return a movie DVD");
            System.out.println("4. List current borrowed movie DVDs");
            System.out.println("5. Display top 10 most popular movies");
            System.out.println("0. Return to main menu");
            System.out.println("================================");
            System.out.print("Please make a selection (1-5, or 0 to return to main menu): ");

            int selection = 9; //set garbage int value to force default case on InputMismatchException

            try {
                selection = input.nextInt();
            } catch (InputMismatchException e) {
                //System.out.println("Invalid selection");
            }

            switch (selection) {
                case 1:
                    System.out.println("display all movies");
                    break;
                case 2:
                    System.out.println("borrow DVD");
                    break;
                case 3:
                    System.out.println("return DVD");
                    break;
                case 4:
                    System.out.println("list current loans");
                    break;
                case 5:
                    System.out.println("display top 10");
                    break;
                case 0:
                    System.out.println("Returning to Main Menu...");
                    displayMenu = false;
                    break;
                default:
                    System.out.println("Invalid selection");
            }// end switch

        }// end while
    }//function memberMenu

}// class App