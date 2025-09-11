public class DivideAndConquer {
    public static void main(String[] args) {
        // int[] nums = new int[]{6,3,9,5,2,8,-9};
        // mergeSort(nums, 0, (nums.length-1));
        // quickSort(nums, 0, nums.length-1);
        // print(nums);

        int[] nums = new int[]{4,5,6,7,0,1,2,3};
        System.out.println(searchInARotatedAndSortedArray(nums, 0, 0,nums.length));
    }

    public static void mergeSort(int[] nums, int startIndex, int endIndex){
        if(startIndex >= endIndex) return;
        int mid = startIndex + (endIndex - startIndex)/2;
        mergeSort(nums, startIndex, mid);
        mergeSort(nums, mid+1, endIndex);
        merge(nums, startIndex, mid, endIndex);
    }

    public static void merge(int[] nums, int startIndex, int mid, int endIndex){
        int[] temp = new int[endIndex-startIndex+1];
        int i = startIndex; //iterator for first sorted array
        int j = mid+1; //iterator for second sorted array
        int k = 0;

        while(i<=mid && j<=endIndex){
            if(nums[i]<nums[j]){
                temp[k] = nums[i];
                i++;
            }else{
                temp[k] = nums[j];
                j++;
            }
            k++;
        }

        // for leftover elements of first sorted array
        while(i <= mid){
            temp[k++] = nums[i++];
        }
        // for leftover elements of second sorted array
        while(j <= endIndex){
            temp[k++] = nums[j++];
        }

        //copy temp array into original array
        for(k=0, i=startIndex; k<temp.length; k++, i++){
            nums[i] = temp[k];
        }
    }

    public static void print(int[] nums) {
        System.out.println();
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + "  ");
        }
    }

    public static void quickSort(int[] nums, int startIndex, int endIndex){
        if(startIndex>=endIndex) return;

        int pIdx = partition(nums, startIndex, endIndex);
        quickSort(nums, startIndex, pIdx-1);
        quickSort(nums, pIdx+1, endIndex);
    }

    public static int partition(int[] nums, int startIndex, int endIndex){
        int pivot = nums[endIndex];
        int i = startIndex - 1;

        for( int j = startIndex; j<endIndex; j++){
            if(nums[j] <= pivot){
                i++;
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
            }
        }
        i++;
        int temp = pivot;
        nums[endIndex] = nums[i];
        nums[i] = temp;

        return i;
    }

    public static int searchInARotatedAndSortedArray(int[] nums,int key, int startIndex, int endIndex){
        if(startIndex>endIndex) return -1;
        int mid = startIndex + (endIndex - startIndex)/2;
        if(nums[mid] == key) return mid;
        
        if(nums[startIndex] <= nums[mid]){
            // case a :L1-left
            if(nums[startIndex]<key && key<nums[mid]){
                return searchInARotatedAndSortedArray(nums, key, startIndex, mid-1);
            }
            // case b :right
            else{
                return searchInARotatedAndSortedArray(nums, key, mid+1, endIndex);
            }
        }
        else{
            // case c: L2-right
            if(nums[mid]<key && key<nums[endIndex]){
                return searchInARotatedAndSortedArray(nums, key, mid+1, endIndex);
            }
            else{
                return searchInARotatedAndSortedArray(nums, key, startIndex, mid-1);
            }
        }
    }
}
