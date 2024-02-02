package phonePe;

public class SortArray {

    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = low - 1;
//{4, 2, 1, 3, 0, 5, 3};
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;
                // Swap array[i] and array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Swap array[i + 1] and array[high] (put the pivot element in its correct position)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] array = {4, 2, 1, 3, 0, 6,5};

        // Sort the array using quicksort
        quickSort(array, 0, array.length - 1);

        // Print the sorted array
        System.out.println("Sorted Array:");
        for (int num : array) {
            System.out.print(num + " ");
        }
    }

}
