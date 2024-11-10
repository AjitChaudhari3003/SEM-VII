import java.util.*;


public class QuickSort {

    private static final Random random = new Random();

    // Main function to perform quicksort
    public static void quickSort(int[] arr, int low, int high, boolean isRandomized) {
        if (low < high) {
            int pivotIndex = isRandomized ? randomizedPartition(arr, low, high) : 
            deterministicPartition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1, isRandomized);
            quickSort(arr, pivotIndex + 1, high, isRandomized);
        }
    }

    // Function for randomized partitioning
    private static int randomizedPartition(int[] arr, int low, int high) {
        int randomPivotIndex = low + random.nextInt(high - low + 1);
        swap(arr, randomPivotIndex, high);
        return partition(arr, low, high);
    }

    // Function for deterministic partitioning
    private static int deterministicPartition(int[] arr, int low, int high) {
        return partition(arr, low, high);
    }

    // Partition function
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;       
        int j = high;          
        while (i < j) {
            do {
                i++;
            } while (arr[i] < pivot);
    
            do {
                j--;
            } while (j > low && arr[j] > pivot);
    
            if (i < j) {
                swap(arr, i, j);
            }
        } ;
    
        swap(arr, i, high);
        return i; // Return the pivot index
    }
    

    // Helper function to swap elements
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input number of elements in the array
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        // Input elements of the array
        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        // Sort using Deterministic QuickSort
        int[] deterministicArr = arr.clone();
        quickSort(deterministicArr, 0, deterministicArr.length - 1, false);
        System.out.println("Sorted using Deterministic QuickSort: " + Arrays.toString(deterministicArr));

        // Sort using Randomized QuickSort
        int[] randomizedArr = arr.clone();
        quickSort(randomizedArr, 0, randomizedArr.length - 1, true);
        System.out.println("Sorted using Randomized QuickSort: " + Arrays.toString(randomizedArr));

        scanner.close();
    }
}
