public class RecursionQuestions {
    public static void main(String[] args) {
        // findIndices(new int[]{3,2,4,5,6,2,7,2,2}, 0, 2);
        // System.out.println("\n"+stringLength("Gracy Tirkey", 0, 0));
        // convertIntoString(2019);
        // String s = "abcab";
        // int n = s.length();
        // System.out.println(countContiguousSubstring(s, n,0,n-1));
        towerOfHanoi(3, "A", "B", "C");
    }

    public static void findIndices(int[] nums,int n, int key){
        if(n == nums.length){
            return;
        }
        if(nums[n] == key) System.out.print(n+" ");
        findIndices(nums, n+1, key);
    }
    
    public static int stringLength(String s, int n, int count){
        if(n==s.length()) return count;
        return stringLength(s, n+1, count+1);
    }

    public static void convertIntoString(int n){
        String[] digits = new String[]{"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        if(n == 0) return;
        convertIntoString(n/10);
        System.out.print(digits[n%10]+" ");
    }

    public static int countContiguousSubstring(String s, int n, int i, int j){

        if(n == 1) return 1;
        if(n <= 0) return 0;

        int res = countContiguousSubstring(s, n-1, i+1, j) + 
                    countContiguousSubstring(s, n-1, i, j-1) -
                    countContiguousSubstring(s, n-2, i+1, j);

        if(s.charAt(i) == s.charAt(j)) res++;

        return res;
    }

    public static void towerOfHanoi(int n, String src, String helper, String dest){
        if(n==1){
            System.out.println("Transfer disk "+n+" from "+src+" to "+dest);
            return;
        }
        towerOfHanoi(n-1, src, dest, helper);
        System.out.println("Transfer disk "+n+" from "+src+" to "+dest);
        towerOfHanoi(n-1, helper, src, dest);
    }
}
