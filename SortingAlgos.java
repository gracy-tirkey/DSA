public class SortingAlgos {
    public static void main(String[] args) {
        int[] numbers = { 5, 4, 1, 3, 2 };
        print(numbers);
        countingSort(numbers);
    }

    public static void print(int[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    public static void bubbleSort(int numbers[]) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
        print(numbers);
    }

    public static void selectionSort(int numbers[]) {
        for (int i = 0; i < numbers.length - 1; i++) {
            int minPos = i;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[minPos] > numbers[j]) {
                    minPos = j;
                }
            }

            int temp = numbers[minPos];
            numbers[minPos] = numbers[i];
            numbers[i] = temp;
        }
        print(numbers);
    }

    public static void insertionSort(int numbers[]) {
        for (int i = 1; i < numbers.length; i++) {
            int currentElement = numbers[i];
            int prevElement = i - 1;
            while (prevElement >= 0 && numbers[prevElement] > currentElement) {
                numbers[prevElement + 1] = numbers[prevElement];
                prevElement--;
            }
            numbers[prevElement + 1] = currentElement;
        }
        print(numbers);
    }

    public static void countingSort(int numbers[]) {
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            largest=Math.max(largest, numbers[i]);
        }
        int count[] = new int[largest+1];
        for (int i = 0; i < numbers.length; i++) {
            count[numbers[i]]++;
        }

        int j=0;
        for( int i = 0 ; i<count.length ; i++){
            while (count[i]>0) {
                numbers[j] = i;
                j++;
                count[i]--;
            }
        }
        print(numbers);
    }
}
