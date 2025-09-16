import java.util.ArrayList;

public class PairSum {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 1; i<=6; i++){
            list.add(i);
        }
        int target = 5;
        System.out.println(pairSum1(list, target));
        System.out.println(pairSum2(list, target));
        
        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(11);
        list2.add(15);
        list2.add(6);
        list2.add(8);
        list2.add(9);
        list2.add(10);
        int target2 = 16;
        System.out.println(pairSum3(list2, target2));
    }

    // Brute Force
    public static boolean pairSum1(ArrayList<Integer> list, int target){
        for(int i = 1; i<list.size(); i++){
            for(int j = i+1; i<list.size(); j++){
                if(list.get(i)+list.get(j) == target){                  
                    System.out.println("("+list.get(i)+","+list.get(j)+")");
                    return true;
                } 
            }
        }
        return false;
    }

    // 2 pointer Approach
    public static boolean pairSum2(ArrayList<Integer> list, int target){
        int leftPointer = 0, rightPointer = list.size()-1;

        while(leftPointer<rightPointer){
            if(list.get(leftPointer)+list.get(rightPointer) == target){
                System.out.println("("+list.get(leftPointer)+","+list.get(rightPointer)+")");
                return true;
            }else if(list.get(leftPointer)+list.get(rightPointer) > target){
                rightPointer--;
            }else{
                leftPointer++;
            }
        }
        return false;
    }

    // Sorted & Rotated Array
    public static boolean pairSum3(ArrayList<Integer> list, int target){
        int pivot=0;
        for(int i = 0; i<list.size()-1; i++){
            if(list.get(i)>list.get(i+1)){
                pivot = i+1;
                break;
            }
        }

        int leftPointer = pivot, rightPointer = pivot-1;

        while(leftPointer != rightPointer){
            if(list.get(leftPointer)+list.get(rightPointer) == target){
                System.out.println("("+list.get(leftPointer)+","+list.get(rightPointer)+")");
                return true;
            }else if(list.get(leftPointer)+list.get(rightPointer) > target){
                rightPointer = (list.size()+rightPointer-1)%list.size();
            }else{
                leftPointer = (leftPointer+1)%list.size();
            }
        }
        return false;
    }
}
