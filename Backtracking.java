public class Backtracking {
    public static void main(String[] args) {
        // int[] nums = new int[5];
        // changeArr(nums, 0, 1);
        // printArr(nums);
        // findSubsets("abc", "", 0);
        findPermutations("abc", "");
    }

    public static void changeArr(int[] nums, int idx, int val){
        if(idx == 5){
            printArr(nums);
            return;
        }
        nums[idx] = val;
        changeArr(nums, idx+1, val+1);
        nums[idx] = nums[idx] - 2;
    }

    public static void printArr(int[] nums){
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i]+" ");
        }
    }

    public static void findSubsets(String s, String newStr, int idx){
        if(idx == s.length()){
            if(newStr.length() > 0){
                System.out.print(newStr+" ");
            }else{
                System.out.print("null");
            }
            return;
        }
        findSubsets(s, newStr+s.charAt(idx), idx+1);
        findSubsets(s, newStr, idx+1);
    }

    public static void findPermutations(String s, String ans){
        if(s.length() == 0){
            System.out.print(ans+"");
            return;
        }
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            String newStr = s.substring(0, i) + s.substring(i+1);
            findPermutations(newStr, ans+curr);
        }
        
    }


}
