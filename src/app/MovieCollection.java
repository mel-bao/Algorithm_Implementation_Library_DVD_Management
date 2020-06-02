package app;

import java.util.ArrayList; //this is only used for converting BST to an array

public class MovieCollection {
  
    //Class containing left and right child of current node and key, value pair
    class BSTNode { 
        String key; 
        Movie value;
        BSTNode left, right; 
  
        public BSTNode(String item, Movie thing) { 
            key = item;
            value = thing;
            left = right = null; 
        } 

        //recursive search function
        public Movie search (String key) {
            if (this.key.equals(key)) {
                return value;
            }
    
            if (key.compareTo(this.key) < 0) {
                return left == null ? null : left.search(key);
            } else {
                return right == null ? null : right.search(key);
            }
        }
    } 
  
    //Root of BST 
    BSTNode root; 
  
    //Constructor 
    public MovieCollection() {  
        root = null;  
    } 

    //delete
    public void delete(String key) { 
        root = deleteRec(root, key); 
    } 
  
    //recursive delete function
    private BSTNode deleteRec(BSTNode root, String key) { 
        //empty tree
        if (root == null) {
            return root; 
        }
  
        //compare down tthe tree
        if (key.compareTo(root.key) < 0) {
            root.left = deleteRec(root.left, key); 
        } else if (key.compareTo(root.key) > 0) {
            root.right = deleteRec(root.right, key); 
  
        //if key is same as root's key, delete this node 
        } else { 
            // node with only one leaf or no leaf
            if (root.left == null) {
                return root.right; 
            } else if (root.right == null) {
                return root.left; 
            }
  
            //node with two children: Get the inorder successor (smallest (leftmost) in the right subtree) 
            root.key = minValue(root.right); 
  
            //Delete the inorder successor 
            root.right = deleteRec(root.right, root.key); 
        } 
  
        return root; 
    } 
  
    //helper function
    private String minValue(BSTNode root) { 
        String minv = root.key; 
        while (root.left != null) { 
            minv = root.left.key; 
            root = root.left; 
        } 
        return minv; 
    }
  
    //insert
    public void insert(String key, Movie value) { 
       root = insertRec(root, key, value); 
    } 
      
    //recursive insert
    private BSTNode insertRec(BSTNode root, String key, Movie value) { 
  
        //if empty tree, create new node
        if (root == null) { 
            root = new BSTNode(key, value); 
            return root; 
        } 
  
        //compare down to tree
        if (key.compareTo(root.key) < 0) {
            root.left = insertRec(root.left, key, value); 
        } else if (key.compareTo(root.key) > 0) {
            root.right = insertRec(root.right, key, value); 
        }
  
        //return and exit
        return root; 
    } 
  
    // display all movies in collection recursive function
    public void displayAll()  { 
       displayAllRec(root); 
    } 
  
    //this does inorder transversal of the tree to
    //display all movies in alphabetical order
    private void displayAllRec(BSTNode root) { 
        if (root != null) { 
            displayAllRec(root.left);
            System.out.println("Title: " + root.key);
            System.out.println("Starring: " + root.value.starring);
            System.out.println("Director: " + root.value.director);
            System.out.println("Genre: " + root.value.genre);
            System.out.println("Classification: " + root.value.classification + " minutes");
            System.out.println("Duration: " + root.value.duration);
            System.out.println("Release Date: " + root.value.date);
            System.out.println("Copies Available: " + root.value.copiesavailable);
            System.out.println("Times Rented: " + root.value.timesrented);
            System.out.println("\n");
            displayAllRec(root.right);
        } else {
            //System.out.println("No movies in collection...");
        }
    } 

    //find Node with given key and return it's value
    public Movie search(String key) {
        return root == null ? null : root.search(key);
    }

    //display the top 10 most frequently borrowed DVDs in descending order of the frequency
    public void displaytop10() {
        //collect movies in array
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies = toArray();

        //Insertion sort of n elements in unordered array movies
        int n = movies.size();

        for (int i = 1; i < n; i++) {
            Movie movie = movies.get(i);
            int j = i - 1;

            while( j >= 0 && movies.get(j).timesrented < movie.timesrented) {
                movies.set(j + 1, movies.get(j));
                j = j - 1;
            }
            movies.set(j + 1, movie);
        }

        //print the results
        for (int i = 0; i < 10; i++) {
            System.out.println(movies.get(i).title + " borrowed " + movies.get(i).timesrented + " times.");
        }
    }

    //helper function to return array of movies in BST
    private ArrayList<Movie> toArray() {
        BSTNode n = root;
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies = collect(n, movies);

        return movies;
    }
      
    //recursive helper function
    private ArrayList<Movie> collect(BSTNode n, ArrayList<Movie> movies) {  
        if (n.left != null) {
            //if there is a left (smaller) value, we go there first
            movies = collect(n.left, movies);
        }
        
        //once we've got all left (smaller) values we can add the value of out current Node.
        movies.add(n.value);
        
        if (n.right != null) {
            //if there is a right (larger) value we get it next
            movies = collect(n.right, movies);
        }
        
        return movies;
    }

}