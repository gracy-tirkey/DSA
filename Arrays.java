public class Arrays {
    public static void main(String[] args) {
        int[] num = { -2, -3, 4, -1,-2, 1, 5, -3 };
        // binarySearch(num, 98);
        printSubArray(num);
        printMaxSubArray(num);
        printMaxSubArray2(num);
        printMaxSubArray3(num);
    }

    public static void print(int[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    public static void printSubArray(int[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                for (int k = start; k <= end; k++) {
                    System.out.print(arr[k] + "  ");
                }
                System.out.println();
            }
        }
    }

    // Brute Force
    public static void printMaxSubArray(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                int currentSum = 0;
                for (int k = start; k <= end; k++) {
                    currentSum += arr[k];
                }
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }
        System.out.println("Max sum of subarrays(Brute Force): " + maxSum);
    }

    // Prefix Array
    public static void printMaxSubArray2(int[] arr) {
        int maxSum = Integer.MIN_VALUE, currentSum = 0;
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = 0; i < arr.length; i++) {
            int start = i;
            for (int j = i; j < arr.length; j++) {
                int end = j;
                currentSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];
                maxSum = currentSum > maxSum ? currentSum : maxSum;
            }
        }
        System.out.println("Max sum of subarrays(Prefix array): " + maxSum);
    }

    // Kadane's Algorithm
    public static void printMaxSubArray3(int[] arr) {
        int maxSum = Integer.MIN_VALUE, currentSum = 0;
        
        for (int i = 0; i < arr.length; i++) {
            currentSum = currentSum + arr[i];
            if(currentSum<0){
                currentSum=0;
            }
            maxSum = Math.max(maxSum, currentSum);
        }
        System.out.println("Max sum of subarrays(Kadane's Algorithm): " + maxSum);
    }

    public static void update(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + 1;
        }
    }

    public static void binarySearch(int[] num, int key) {
        int start = 0, end = num.length - 1, mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (num[mid] == key) {
                System.out.println("Found at Index: " + mid);
                break;
            } else if (num[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
    }

    
}
