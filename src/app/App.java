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
                    staffMenu();
                    break;
                case 2:
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

        System.out.print("Enter Username: ");
        String user = input.nextLine();

        if (user.equals("staff")) {
            System.out.print("Enter Password: ");
            String pass = input.nextLine();

            if (pass.equals("today123")) {

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
                        input.nextLine();
                    } catch (InputMismatchException e) {
                        //System.out.println("Invalid selection");
                    }

                    switch (selection) {
                        case 1:
                            Movie movie = new Movie();

                            System.out.print("Enter the movie title: ");
                            String title = input.nextLine();
                            movie.title = title;
                            System.out.print("Enter the starring actors(s): ");
                            String starring = input.nextLine();
                            movie.starring = starring;
                            System.out.print("Enter the director(s): ");
                            String director = input.nextLine();
                            movie.director = director;

                            System.out.println("Select the genre:");
                            System.out.println("1. Drama");
                            System.out.println("2. Adventure");
                            System.out.println("3. Family");
                            System.out.println("4. Action");
                            System.out.println("5. Sci-Fi");
                            System.out.println("6. Comedy");
                            System.out.println("7. Thriller");
                            System.out.println("8. Other");
                            System.out.print("Make Selection(1-8): ");

                            String genre = input.nextLine();
                            switch (genre) {
                                case "1":
                                    movie.genre = "Drama";
                                    break;
                                case "2":
                                    movie.genre = "Adventure";
                                    break;
                                case "3":
                                    movie.genre = "Family";
                                    break;
                                case "4":
                                    movie.genre = "Action";
                                    break;
                                case "5":
                                    movie.genre = "Sci-Fi";
                                    break;
                                case "6":
                                    movie.genre = "Comedy";
                                    break;
                                case "7":
                                    movie.genre = "Thriller";
                                    break;
                                case "8":
                                    movie.genre = "Other";
                                    break;
                                default:
                                    movie.genre = "Other";
                            }// end genre switch

                            System.out.println("Select the classification:");
                            System.out.println("1. General (G)");
                            System.out.println("2. Parental Guidance (PG)");
                            System.out.println("3. Mature (M15+)");
                            System.out.println("4. Mature Accompanied (MA15+)");
                            System.out.print("Make Selection(1-4): ");

                            String classification = input.nextLine();
                            switch (classification) {
                                case "1":
                                    movie.classification = "General (G)";
                                    break;
                                case "2":
                                    movie.classification = "Parental Guidance (PG)";
                                    break;
                                case "3":
                                    movie.classification = "Mature (M15+)";
                                    break;
                                case "4":
                                    movie.classification = "Mature Accompanied (MA15+)";
                                    break;
                                default:
                                    movie.classification = "Unrated";
                            }//end classification switch

                            System.out.print("Enter the duration (minutes): ");
                            String duration = input.nextLine();
                            movie.duration = Integer.parseInt(duration);
                            System.out.print("Enter the release date (year): ");
                            String date = input.nextLine();
                            movie.date = date;
                            System.out.print("Enter the number of copies available: ");
                            int copies = Integer.parseInt(input.nextLine());

                            //add movie(s) to MovieCollection


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
                
            } else {
                System.out.println("Invalid Password");
            }//end if password verification

        } else {
            System.out.println("Invalid Username");
        }//end if username verification
            
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
                input.nextLine();
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