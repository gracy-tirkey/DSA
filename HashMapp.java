import java.util.HashMap;

public class HashMapp {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();

        // Adding key-value pairs to the HashMap
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Orange", 3);

        // Displaying the HashMap
        System.out.println("HashMap: " + map);

        // Accessing a value using its key
        int value = map.get("Banana");
        System.out.println("Value for key 'Banana': " + value);

        // Checking if a key exists
        boolean hasKey = map.containsKey("Apple");
        System.out.println("Contains key 'Apple': " + hasKey);

        // Removing a key-value pair
        map.remove("Orange");
        System.out.println("HashMap after removing 'Orange': " + map);
    }
}