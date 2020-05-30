package app;

public class BSTNode {
    private String key;
    private Object value;
    private BSTNode left, right;

    public BSTNode( String key, Object value ) {
        this.key = key;
        this.value = value;
    }

    //if key not found in BST then it is added. If key already exists then that node's value
    //is updated.
    public void insert( String key, Object value ) {
        if ( key.compareTo( this.key ) < 0 ) {             
            
            if ( left != null ) {                 
                left.insert( key, value );             
            } else {                 
                left = new BSTNode( key, value );             
            } 

        } else if ( key.compareTo( this.key ) > 0 ) {
            
            if ( right != null ) {
                right.insert( key, value );
            } else {
                right = new BSTNode( key, value );
            }

        } else {
            //update this one
            this.value = value;
        }
    }

    //find Node with given key and return it's value
    public Object search( String key ) {
        if ( this.key.equals( key ) ) {
            return value;
        }

        if ( key.compareTo( this.key ) < 0 ) {
            return left == null ? null : left.search( key );
        } else {
            return right == null ? null : right.search( key );
        }
    }
}