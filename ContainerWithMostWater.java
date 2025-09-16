import java.util.ArrayList;
public class ContainerWithMostWater {
    public static void main(String[] args) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(storedWater(height));
        System.out.println(storedWater2(height));
    }

    // Brute Force
    public static int storedWater(ArrayList<Integer> height){
        int maxWater = 0;
        for(int i = 0; i<height.size(); i++){
            for(int j = i+1; j<height.size(); j++){
                int h = Math.min(height.get(i), height.get(j));
                int w = j-i;
                int currWater = h * w;
                maxWater = Math.max(currWater, maxWater);
            }
        }
        return maxWater;
    }

    // 2-pointer Approach
    public static int storedWater2(ArrayList<Integer> height){
        int maxWater = 0, leftPointer = 0, rightPointer = height.size()-1;

        while(leftPointer<rightPointer){
            int h = Math.min(height.get(leftPointer), height.get(rightPointer));
            int w = rightPointer - leftPointer;
            int currWater = h * w;
            maxWater = Math.max(currWater, maxWater);

            if(leftPointer<rightPointer){
                leftPointer++;
            }else{
                rightPointer--;
            }
        }
        return maxWater;
    }
}
