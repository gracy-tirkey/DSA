public class TrappingRainwater {

    public static void main(String[] args) {
        int height[] = {4,2,0,6,3,2,5};
        trappingRainwater(height);
    }

    public static void print(int[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    public static void trappingRainwater(int height[]){
        int leftMax[]=new int[height.length];
        leftMax[0]=height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }
        System.out.print("\n\n Left Max: ");
        print(leftMax);

        int rightMax[]=new int[height.length];
        rightMax[height.length-1]=height[height.length-1];
        for (int i = height.length-2; i >=0; i--) {
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }
        System.out.print("\n\n Right Max: ");
        print(rightMax);

        int totalTrappedWater = 0;
        int waterLevel=0;
        int[] trappedWater = new int[height.length];
        for (int i = 0; i < height.length; i++) {
            waterLevel=Math.min(leftMax[i], rightMax[i])-height[i];
            trappedWater[i]=waterLevel;
            totalTrappedWater += waterLevel;
        }
        System.out.print("\n\n Trapped Water: ");
        print(trappedWater);
        System.out.println("\n\n Total Trapped Rainwater is " +totalTrappedWater+" units\n");
    }
}
