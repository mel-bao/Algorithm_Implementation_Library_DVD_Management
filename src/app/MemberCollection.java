package app;

public class MemberCollection {
    public static Member[] array;
    public static int length;

    public MemberCollection() {
        length = 0;
    }
    
    //add a member to the end of the resized array
    public void add(Member member) {
        length = length + 1;
        Member[] newArray = new Member[length];

        for (int i = 0; i < length - 1; i++) {
            newArray[i] = array[i];
        }

        newArray[length - 1] = member;
        array = newArray;
    }

    //retrieve a member from the array
    public Member get(String username) {
        for (int i = 0; i < length; i++) {
            if (array[i].username.equals(username)) {
                return array[i];
            }
        }
        return null;
    }

    //return true if a given member already exists in the array
    public Boolean checkDuplicate(String username) {
        for (int i = 0; i < length; i++) {
            if (array[i].username.equals(username)) {
                return true;
            }
        }
        return false;
    }
}