package app;

public class MovieCollection {

    private BSTNode root;

    public void insert( String key, Object value ) {
        if ( root == null ) {
            root = new BSTNode( key, value );
        } else {
            root.insert( key, value );
        }
    }

    public Object search( String key ) {
        return root == null ? null : root.search( key );
    }
}