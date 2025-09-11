public class Recursion {
    public static void main(String[] args) {

        String s = "appnnacollege";
        removeDuplicates(s, 0, new StringBuilder(""), new boolean[26]);

    }

    public static void printDec(int n){
        if(n == 0) return;
        System.out.print(n+" ");
        printDec(n-1);
    }

    public static void printInc(int n){
        if(n == 0) return;
        printInc(n-1);
        System.out.print(n+" ");
    }

    public static int calcFact(int n){
        if(n == 1) return 1;
        int fact = n * calcFact(n-1);
        return fact;
    }

    public static int calcFib(int n){
        if(n == 0 || n == 1 ) return n;
        int fib = calcFib(n-1) + calcFib(n-2);
        return fib;
    }

    public static int calcSum(int n){
        if(n == 1) return 1;
        int sum = n + calcSum(n-1);
        return sum;
    }

    public static boolean isSorted(int[] nums, int i){
        if(i == nums.length - 1) return true;
        if(nums[i] > nums[i+1]) return false;
        return isSorted(nums, i+1);
    }

    public static int firstOccurrence(int[] nums, int i, int key){
        if(i == nums.length) return -1;
        if(nums[i] == key) return i;
        return firstOccurrence(nums, i+1, key);
    }

    // Method-I
    public static int lastOccurrence(int[] nums, int i, int key){
        if( (i < 0) || nums[i] == key) return i;
        return lastOccurrence(nums, i-1, key);
    }

    // Method-II
    public static int lastOccurrence2(int[] nums, int i, int key){
        if( i == nums.length ) return -1;
        int isFound = lastOccurrence(nums, i+1, key);
        if(isFound == -1 && nums[i] == key) return i;
        return isFound;
    }

    // Method-I
    public static int power(int x, int n){
        if(n == 0) return 1;
        return x * power(x, n-1);
    }

    // Method-II(Optimized)
    public static int power2(int x, int n){
        if(n == 0) return 1;         
        int result = power(x, n/2);
                        // int result = power(x, n/2) * power(x, n/2);
        result *= result;

        if(n%2 != 0){
            result *= x;
        }
        return result;
    }

    public static void removeDuplicates(String s, int i, StringBuilder newStr, boolean[] map){
        if(i == s.length()) {
            System.out.println(newStr);
            return;
        }

        char currChar = s.charAt(i);
        if( map[currChar-'a'] == true) {
            removeDuplicates(s, i+1, newStr, map);
        }else{
            map[currChar-'a'] = true;
            removeDuplicates(s, i+1, newStr.append(currChar), map);
        }
    }

}