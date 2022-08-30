package sorting;

public class SelectionSort {

    public static int[] selectionSort (int[] array ){
        int size = array.length;
        int temp = 0;
        for (int i = 0; i <size ; i++) {
            int minPosition = i;
            for (int j = i+1; j < size; j++) {
                if (array[j] < array[minPosition]){
                    minPosition = j;
                }
            }
            temp = array[i];
            array[i] = array[minPosition];
            array[minPosition] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[]array = {73, 4, 7, 1, 10, 8, 2, 22, 99, 50 };

        for (int val: selectionSort(array)) {
            System.out.print(val+ " ");
        }

    }
}
