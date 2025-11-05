import java.util.Stack;

public class TrappingWaterStack {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height)); // Output: 6
    }

    static int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int waterTrapped = 0;
        
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                
                if (stack.isEmpty()) {
                    break;
                }
                
                int distance = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                waterTrapped += distance * boundedHeight;
            }
            stack.push(i);
        }
        
        return waterTrapped;
    }
}
