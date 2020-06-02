package app;

public class Member {
    String firstname;
    String surname;
    String address;
    String phone;
    String password;
    String username;
    Movie[] borrowed = new Movie[10];
    int numborrowed;

    public Member() {
        numborrowed = 0;
    }

    //return true if the given movie already exists for this member
    public Boolean loaned(String title) {
        for (int i = 0; i < 10; i++) {
            if (borrowed[i] != null) {
                if (borrowed[i].title.equals(title)) {
                    return true;
                }
            }
        }
        return false;
    }

    //remove the movie from the borrowed array
    public void returnmovie(String title) {
        for (int i = 0; i < 10; i++) {
            if (borrowed[i] != null) {
                if (borrowed[i].title.equals(title)) {
                    //Movie blank = new Movie();
                    //borrowed[i] = blank;
                    borrowed[i] = null;
                    break;
                }
            }
        }
    }

    //add the movie to the first available index in the borrowed array
    public void borrowmovie(Movie movie) {

        for (int i = 0; i < 10; i++) {
            //if (borrowed[i].title == null || borrowed[i].title.isEmpty()) {
            if (borrowed[i] == null) {
                borrowed[i] = movie;
                break;
            }
        }
    }

    //list the non-null movies in the borrowed array
    public void listloans() {
        System.out.println("You have " + numborrowed + " movies on loan");
        for (int i = 0; i < 10; i++) {
            //if (borrowed[i].title != null && !borrowed[i].title.isEmpty()) {
            if (borrowed[i] != null) {
                System.out.println("Title: " + borrowed[i].title);
            }
        }
    }

}