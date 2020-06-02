package app;
import java.util.Scanner; 
import java.util.InputMismatchException;

//Class for the menu structure of the project
public class Menu {
    //each runnable instance contains 1 MovieCollection and 1 MemberCollection
    MovieCollection collection = new MovieCollection();
    MemberCollection members = new MemberCollection();


    //main menu function
    public void mainMenu() {
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

            String select = input.nextLine();
            //int selection = 9; //set garbage int value to force default case on InputMismatchException

            //defensive code incase user input is not an int
            Boolean correctselect = true;
            try {
                Integer.parseInt(select);
            } catch (NumberFormatException e) {
                System.out.println("Invalid selection");
                correctselect = false;
            }

            //behaviour based on selection
            if (correctselect) {
                int selection = Integer.parseInt(select);
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
                        break;
                }// end switch
            }//end if
        }// end while
    }// function mainMenu


    //staff menu function
    public void staffMenu() {
        Scanner input = new Scanner(System.in);
        boolean displayMenu = true; //bool for loop

        System.out.print("Enter Username: ");
        String user = input.nextLine();

        //test username
        if (user.equals("staff")) {
            System.out.print("Enter Password: ");
            String pass = input.nextLine();

            //test password
            if (pass.equals("today123")) {

                //loop for displaying menu and menu behaviours
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

                    String select = input.nextLine();
                    //int selection = 9; //set garbage int value to force default case on InputMismatchException

                    //defensive code incase user input is not an int
                    Boolean correctselect = true;
                    try {
                        Integer.parseInt(select);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid selection");
                        correctselect = false;
                    }

                    if (correctselect) {
                        int selection = Integer.parseInt(select);
                        //behaviour based on selection
                        switch (selection) {
                            //add a new movie
                            case 1:
                                Movie movie = new Movie();

                                System.out.print("Enter the movie title: ");
                                String title = input.nextLine();

                                //Check if movie already exists
                                Movie oldMovie = collection.search(title);
                                if (oldMovie != null) {
                                    System.out.print("Enter the number of copies you would like to add: ");
                                    int copies = Integer.parseInt(input.nextLine());
                                    //remove old version
                                    collection.delete(title);
                                    //update new
                                    oldMovie.copies = oldMovie.copies + copies;
                                    oldMovie.copiesavailable = oldMovie.copiesavailable + copies;
                                    //add movie to MovieCollection
                                    collection.insert(title, oldMovie);

                                    System.out.println("Added" + copies + "new copies of" + title);

                                } else { //if movie doesn't exist in the collection

                                    System.out.print("Enter the starring actors(s): ");
                                    String starring = input.nextLine();
                                    System.out.print("Enter the director(s): ");
                                    String director = input.nextLine();

                                    System.out.println("Select the genre:");
                                    System.out.println("1. Drama");
                                    System.out.println("2. Adventure");
                                    System.out.println("3. Family");
                                    System.out.println("4. Action");
                                    System.out.println("5. Sci-Fi");
                                    System.out.println("6. Comedy");
                                    System.out.println("7. Thriller");
                                    System.out.println("8. Animated");
                                    System.out.println("9. Other");
                                    System.out.print("Make Selection(1-9): ");

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
                                            movie.genre = "Animated";
                                            break;
                                        case "8":
                                            movie.genre = "Thriller";
                                            break;
                                        case "9":
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
                                    System.out.print("Enter the release date (year): ");
                                    String date = input.nextLine();
                                    System.out.print("Enter the number of copies available: ");
                                    int copies = Integer.parseInt(input.nextLine());

                                    //update movie object
                                    movie.title = title;
                                    movie.starring = starring;
                                    movie.director = director;
                                    movie.duration = Integer.parseInt(duration);
                                    movie.date = date;
                                    movie.copies = copies;
                                    movie.timesrented = 0;
                                    movie.copiesavailable = copies;

                                    //add movie to MovieCollection
                                    collection.insert(title, movie);
                                }//end else

                                break;
                            //remove a movie
                            case 2:
                                System.out.print("Enter the movie title: ");
                                String removetitle = input.nextLine();

                                //if movie exists in collection
                                Movie removeMovie = collection.search(removetitle);
                                if (removeMovie == null) {
                                    System.out.println("No such movie exists");
                                //if all copies are loaned out
                                } else if (removeMovie.copiesavailable == 0) {
                                    System.out.println("Movie is on loan, cannot remove until returned");
                                //if there are still unloaned copies
                                } else if (removeMovie.copiesavailable > 0) {
                                    //if more than 1 copy, only reduce the copy count
                                    if (removeMovie.copies > 1) {
                                        collection.delete(removetitle);
                                        removeMovie.copies = removeMovie.copies - 1;
                                        removeMovie.copiesavailable = removeMovie.copiesavailable - 1;
                                        collection.insert(removeMovie.title, removeMovie);
                                        System.out.println("Title removed...");
                                    //otherwise delete the while thing
                                    } else {
                                        collection.delete(removetitle);
                                        System.out.println("Title removed...");
                                    }
                                }
                                
                                break;
                            //register a member
                            case 3:
                                Member member = new Member();

                                System.out.print("Enter member's firstname: ");
                                String firstname = input.nextLine();
                                System.out.print("Enter member's surname: ");
                                String surname = input.nextLine();

                                //concatenate username
                                String username = surname + firstname;

                                //check if member already exists
                                if (members.checkDuplicate(username)) {
                                    System.out.println(firstname + " " + surname + " has already registered");
                                } else {
                                    System.out.println("Your username will be: " + username);
                                
                                    System.out.print("Enter member's address: ");
                                    String address = input.nextLine();
                                    System.out.print("Enter member's phone number: ");
                                    String phone = input.nextLine();
                                    System.out.print("Enter member's password (4-digits): ");
                                    String password = input.nextLine();
                                    
                                    //check that password is a string of ints (characters)
                                    Boolean correctpw = true;
                                    for (char ch: password.toCharArray()) {
                                        int characterint = Character.getNumericValue(ch);
                                        if (characterint == -2 || characterint == -1) {
                                            correctpw = false;
                                            System.out.println("Please enter a valid password");
                                        }
                                    }

                                    if (correctpw) {
                                        //check that password is four digits long
                                        if (password.length() != 4) {
                                            System.out.println("Please enter a valid password");
                                        } else {

                                            member.firstname = firstname;
                                            member.surname = surname;
                                            member.username = username;
                                            member.address = address;
                                            member.phone = phone;
                                            member.password = password;

                                            //add member to memberCollection
                                            members.add(member);

                                            System.out.println("Successfully added " + firstname + " " + surname);
                                        }//end else
                                    }//end if

                                }//end else

                                break;
                            //find a registered member's phone number
                            case 4:
                                System.out.print("Enter member's firstname: ");
                                String fname = input.nextLine();
                                System.out.print("Enter member's surname: ");
                                String sname = input.nextLine();

                                //concatenate username
                                String uname = sname + fname;

                                //check if member of this name exists
                                if (members.checkDuplicate(uname)) {
                                    Member retrieved = members.get(uname);
                                    System.out.println(fname + " " + sname + "'s phone number is: " + retrieved.phone);
                                } else {
                                    System.out.println("There is no member with this name");
                                }

                                break;
                            //return to main menu
                            case 0:
                                System.out.println("Returning to Main Menu...");
                                displayMenu = false;
                                break;
                            default:
                                System.out.println("Invalid selection");
                                break;
                        }// end switch
                    }//end if

                }// end while

            } else {
                System.out.println("Invalid Password");
            }//end if password verification

        } else {
            System.out.println("Invalid Username");
        }//end if username verification
            
    }// function staffMenu


    //member menu function
    public void memberMenu() {
        Scanner input = new Scanner(System.in);
        boolean displayMenu = true;

        System.out.print("Enter your Username (lastnameFirstname): ");
        String user = input.nextLine();

        //check if a member with this username exists
        if (members.checkDuplicate(user)) {
            Member retrieved = members.get(user);

            //if the member's username matches
            if (retrieved.username.equals(user)) {
                System.out.print("Enter Password: ");
                String pass = input.nextLine();

                //check that password is a string of ints (characters)
                Boolean correctpw = true;
                for (char ch: pass.toCharArray()) {
                    int characterint = Character.getNumericValue(ch);
                    if (characterint == -2 || characterint == -1) {
                        correctpw = false;
                        System.out.println("Please enter a valid password");
                    }
                }

                if (correctpw) {
                    //if the password matches
                    if (retrieved.password.equals(pass)) {

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

                            String select = input.nextLine();
                            //int selection = 9; //set garbage int value to force default case on InputMismatchException

                            //defensive code for if the user input is not an integer
                            Boolean correctselect = true;
                            try {
                                Integer.parseInt(select);
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid selection");
                                correctselect = false;
                            }

                            if (correctselect) {
                                int selection = Integer.parseInt(select);
                                //switch statement for menu option behaviours
                                switch (selection) {
                                    //display all info about the movies in alphabetical order
                                    case 1:
                                        collection.displayAll();
                                        
                                        break;
                                    //borrow a DVD
                                    case 2:
                                        System.out.print("Enter the movie title: ");
                                        String borrowtitle = input.nextLine();

                                        //if the movie exists in the collection
                                        Movie borrowmovie = collection.search(borrowtitle);
                                        if (borrowmovie != null) {
                                            //if there are copies available to be borrowed
                                            if (borrowmovie.copiesavailable > 0) {
                                                //if the member does not currently have a copy of this movie
                                                if (!retrieved.loaned(borrowtitle)) {
                                                    //update in movie collection and add to member
                                                    if (retrieved.numborrowed < 10) {
                                                        borrowmovie.timesrented = borrowmovie.timesrented + 1;
                                                        borrowmovie.copiesavailable = borrowmovie.copiesavailable - 1;
                                                        //remove and update movie
                                                        collection.delete(borrowtitle);
                                                        collection.insert(borrowtitle, borrowmovie);
                                                        //add to member
                                                        retrieved.borrowmovie(borrowmovie);
                                                        retrieved.numborrowed = retrieved.numborrowed + 1;
                                                        System.out.println("You borrowed " + borrowtitle);
                                                    } else {
                                                        System.out.println("You have too many movies on loan");
                                                    }
                                                } else {
                                                    System.out.println("You already hav a copy of this DVD on loan");
                                                }
                                            } else {
                                                System.out.println("All copies of this DVD are currently loaned out");
                                            }
                                            
                                        } else {
                                            System.out.println("no such movie in collection");
                                        }

                                        break;
                                    //return a borrowed DVD
                                    case 3:
                                        System.out.print("Enter the movie title: ");
                                        String returntitle = input.nextLine();

                                        //if the movie exists in the collection
                                        Movie returnmovie = collection.search(returntitle);
                                        if (returnmovie != null) {
                                            //if movie currently on loan to member
                                            if (retrieved.loaned(returntitle)) {
                                                returnmovie.copiesavailable = returnmovie.copiesavailable + 1;
                                                collection.delete(returntitle);
                                                collection.insert(returntitle, returnmovie);

                                                //remove from member
                                                retrieved.returnmovie(returntitle);
                                                retrieved.numborrowed = retrieved.numborrowed - 1;
                                                System.out.println("You returned " + returntitle);
                                            } else {
                                                System.out.println("You do not have a current loan of this movie");
                                            }
                                        } else {
                                            System.out.println("no such movie in collection");
                                        }
                                        break;
                                    //list DVDs currently being held by the member
                                    case 4:
                                        System.out.println("You have the following movies on loan:");
                                        retrieved.listloans();
                                        break;
                                    //display the top 10 most frequently borrowed DVDs
                                    case 5:
                                        collection.displaytop10();
                                        break;
                                    case 0:
                                        System.out.println("Returning to Main Menu...");
                                        displayMenu = false;
                                        break;
                                    default:
                                        System.out.println("Invalid selection");
                                        break;
                                }// end switch
                            }//end if

                        }// end while
                    } else {
                        System.out.println("Invalid Password");
                    }//end password verification
                }//end password int or string verification
            } else {
                System.out.println("Invalid Username");
            }//end username verification
        } else {
            System.out.println("There is no member with this username");
        }//end check duplicate if
    }//function memberMenu
}

