import java.util.HashSet;

public class HashSett {
    // used to store unique elements
    // no duplicates allowed
    // unordered collection
    // allows null values
    // implemented using hashmap internally
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();

        // Adding elements to the HashSet
        set.add("Apple");
        set.add("Banana");
        set.add("Cherry");
        set.add("Date");
        set.add("Banana");
        set.add("Cherry");  // Duplicate elements will be ignored

        // Displaying the HashSet
        System.out.println("HashSet: " + set);

        // Checking if an element exists
        String fruitToCheck = "Banana";
        if (set.contains(fruitToCheck)) {
            System.out.println(fruitToCheck + " is present in the HashSet.");
        } else {
            System.out.println(fruitToCheck + " is not present in the HashSet.");
        }

        // Removing an element
        set.remove("Date");
        System.out.println("After removing Date: " + set);

        // Iterating through the HashSet
        System.out.println("Iterating through the HashSet:");
        for (String fruit : set) {
            System.out.println(fruit);
        }
        set.clear();
        System.out.println("After clearing the HashSet: " + set);
        System.out.println("isEmpty(): "+ set.isEmpty());
    }
}
