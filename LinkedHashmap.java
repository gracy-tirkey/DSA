import java.util.LinkedHashMap;
import java.util.HashMap;

// maintains insertion order of elements
public class LinkedHashmap {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
        lhm.put("Apple", 1);
        lhm.put("Banana", 2);
        lhm.put("Cherry", 3);
        lhm.put("Date", 4);
        lhm.put("Elderberry", 5);
        System.out.println("LinkedHashMap: " + lhm);
        
        // comparison with HashMap
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("Apple", 1);
        hm.put("Banana", 2);    
        hm.put("Cherry", 3);
        hm.put("Date", 4);
        hm.put("Elderberry", 5);
        System.out.println("HashMap: " + hm);

    }
}
