import java.util.HashMap;

public class ValidAnagramProblem {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> charCountMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

            charCountMap.put(charS, charCountMap.getOrDefault(charS, 0) + 1);
            charCountMap.put(charT, charCountMap.getOrDefault(charT, 0) - 1);
        }

        for (int count : charCountMap.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t)); // Output: true

        String s2 = "rat";
        String t2 = "car";
        System.out.println(isAnagram(s2, t2)); // Output: false
    }
}
