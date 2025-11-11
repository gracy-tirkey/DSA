import java.util.Arrays;

public class GreedyAlgoProblems {
    public static void main(String[] args) {
        System.out.println(maxBalancedStringPartitions("LRRRRLLRLLRL"));
        System.out.println(kthLargestOddNumber(new int[]{-10, 10}, 8));
        System.out.println(smallestStringOfLenAndNSumK(3, 27));
        System.out.println(BuyAndSellStock(new int[]{7,1,5,3,6,4}, 6));
        int a[] = {7,2,5,10,8};
        splitArrayIntoKSubArrays(a, a.length, 2, 0, 0, 0);
        System.out.println(a + "\n");
    }

    public static int maxBalancedStringPartitions(String s) {
        int countL = 0, countR = 0, partitions = 0;
        for (char c : s.toCharArray()) {
            if (c == 'L') {
                countL++;
            } else if (c == 'R') {
                countR++;
            }
            if (countL == countR) {
                partitions++;
            }
        }
        return partitions;
    }

    public static int kthLargestOddNumber(int[] range, int K){
        if(K <= 0) return 0;
        
        int L = range[0];
        int R = range[1];

        if((R & 1) > 0){
            int Count = (int)Math.ceil((R - L + 1) / 2);
            if(K > Count) return 0;
            else return (R - 2 * K + 2);
        }else{
            int Count = (R - L + 1) / 2;
            if(K > Count) return 0;
            else return (R - 2 * K + 1);
        }
    }
    public static char[] smallestStringOfLenAndNSumK( int n, int k){
        char arr[] = new char[n];
        Arrays.fill(arr, 'a');
        for(int i = n-1; i >= 0 && k > 0; i--){
            k-=i;
            if(k >= 0){
                if(k >= 2){
                    arr[i] = 'z';
                    k -= 26;
                }else{
                    arr[i] = (char)(k + 97 - 1);
                    k -= arr[i] - 'a' + 1;
                }
            }else break;
            k += i;
        }
        return arr;
    }

    public static int BuyAndSellStock(int prices[], int n){
        int buyPrices = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < n; i++){
            if(prices[i] < buyPrices){
                buyPrices = prices[i];
            }else if(prices[i] - buyPrices > maxProfit){
                maxProfit = prices[i] - buyPrices;
            }
        }
        return maxProfit;
    }

    public static void splitArrayIntoKSubArrays( int a[], int n,  int k, int index, int sum,int maxSum){
        int ans = Integer.MAX_VALUE;
        if(k == 1){
            maxSum = Math.max(maxSum, sum);
            sum = 0;
            for(int i = index; i < n; i++){
                sum += a[i];
            }
            maxSum = Math.max(maxSum, sum);
            ans = Math.min(ans, maxSum);
            return;
        }
        sum = 0;
        for(int i = index; i < n - k + 1; i++){
            sum += a[i];
            maxSum = Math.max(maxSum, sum);
            splitArrayIntoKSubArrays(a, n, k - 1, i+1, sum, maxSum);
        }
    }

}
