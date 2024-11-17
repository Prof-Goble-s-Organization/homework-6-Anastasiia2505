
import java.util.Arrays;

public class HeapSort {
	public static void heapSort(Integer[] values) {
        int length = values.length;
        for (int i = (length / 2) - 1; i >= 0; i--) {
            trickleDown(values, i, length);
        }
        
        for (int i = length - 1; i > 0; i--) {
            swap(values, 0, i);
            trickleDown(values, 0, i);
        }
    }

    
    public static void trickleDown(Integer[] arr, int i, int length) {
        int biggest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < length && arr[left] > arr[biggest]) {
            biggest = left;
        }

        if (right < length && arr[right] > arr[biggest]) {
            biggest = right;
        }

        if (biggest != i) {
            swap(arr, i, biggest);
            trickleDown(arr, biggest, length);
        }
    }

    public static void swap(Integer[] arr, int n, int k) {
        int temp = arr[n];
        arr[n] = arr[k];
        arr[k] = temp;
    }
    
    public static void main(String[] args) {
        int size = 20;
        Integer[] list = new Integer[size];

        for (int i = 0; i < list.length; i++) {
            list[i] = i;
        }

        System.out.println("Unsorted List: " + Arrays.toString(list));
        heapSort(list);
        System.out.println("  Sorted List:" + Arrays.toString(list));
        
        Integer[] list2 = new Integer[] {8,6,4,9,1,0,3,5,2,6,8,0,5};
        System.out.println("Unsorted List: " + Arrays.toString(list2));
        heapSort(list2);
        System.out.println("  Sorted List:" + Arrays.toString(list2));
    }
}
