import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

class User {
    public int id;
    public String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name;
    }
}

public class CollectionComparison {
    public static void main(String[] args) {
        // Array
        User[] userArray = new User[2];
        userArray[0] = new User(1, "Alice");
        userArray[1] = new User(2, "Bob");
        System.out.println("Array:");
        for (User user : userArray) {
            System.out.println(user);
        }

        // ArrayList
        List<User> userArrayList = new ArrayList<>();
        userArrayList.add(new User(3, "Charlie"));
        userArrayList.add(new User(4, "Dave"));
        System.out.println("\nArrayList:");
        for (User user : userArrayList) {
            System.out.println(user);
        }

        // Vector
        Vector<User> userVector = new Vector<>();
        userVector.add(new User(5, "Eve"));
        userVector.add(new User(6, "Frank"));
        System.out.println("\nVector:");
        for (User user : userVector) {
            System.out.println(user);
        }
    }
}