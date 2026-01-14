import java.util.TreeMap;

// keys are sorted in natural order
public class TreeMapp {
    // put, get, remove are O(log n)
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        // Inserting key-value pairs
        treeMap.put(3, "Three");
        treeMap.put(1, "One");
        treeMap.put(2, "Two");

        // Displaying the TreeMap (keys will be in sorted order)
        System.out.println("TreeMap: " + treeMap);

        // Accessing a value
        String value = treeMap.get(2);
        System.out.println("Value for key 2: " + value);

        // Removing a key-value pair
        treeMap.remove(1);
        System.out.println("TreeMap after removing key 1: " + treeMap);
    }
}
