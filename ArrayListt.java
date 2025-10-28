import java.util.ArrayList;
import java.util.Collections;
public class ArrayListt {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mainList = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ArrayList<Integer> list3 = new ArrayList<>();

        for(int i = 1; i<=5; i++){
            list1.add(i*1);
            list2.add(i*2);
            list3.add(i*3);
        }
        mainList.add(list1);
        mainList.add(list2);
        mainList.add(list3);

        for(int i = 0; i<mainList.size(); i++){
            ArrayList<Integer> currList = mainList.get(i);
            for(int j = 0; j<currList.size(); j++){
                System.out.print(currList.get(j)+" ");
            }
            System.out.println();
        }  

        // Add at a specific index
        list1.add(5,11);
        System.out.println(list1);

        // Delete Operation - O(n)
        list1.remove(3);
        System.out.println("List1: "+list1);

        // Set Operation - O(n)
        list1.set(3, 9);
        System.out.println(list1);

        // Contains Operation - O(n)
        System.out.println(list1.contains(9));
        System.out.println(list1.contains(15));

        // print reverse - O(n) 
        printReverseArray(list1);

        // find maximum element - O(n)
        System.out.println("Max: "+findMax(list1));
        
        // swap two numbers 
        swapNums(list1, 1, 2);
        System.out.println(list1);
    
        // sort elements in ascending order
        Collections.sort(list1);
        System.out.println(list1);

        // sort elements in descending order
        Collections.sort(list1,Collections.reverseOrder());
        System.out.println(list1);

        // passed by reference
        System.out.println(mainList);
    
    }

    public static void printReverseArray(ArrayList<Integer> nums){
        for(int i = nums.size()-1; i>=0; i--){
            System.out.print(nums.get(i)+" ");
        }
        System.out.println();
    }

    public static int findMax(ArrayList<Integer> nums){
        int max = Integer.MIN_VALUE;
        for(int i = nums.size()-1; i>=0; i--){
            if(nums.get(i)>max) max = nums.get(i);
        }
        return max;
    }

    public static void swapNums(ArrayList<Integer> nums, int idx1, int idx2){
        int temp = nums.get(idx1);
        nums.set(idx1, nums.get(idx2));
        nums.set(idx2, temp);
    }


}
