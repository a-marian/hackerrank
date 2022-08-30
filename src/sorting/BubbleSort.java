package sorting;

public class BubbleSort {

    public static int[] bubbleSort(int[] arr){
        int size= arr.length;
        int temp= 0;
        for (int i = 0; i < size; i++){
            //flag to check if any element was swapped
            boolean swapped = false;

            //starting with the last element
            for (int j = size -1; j > i; j--) {

                //comparing if the element is smaller than the previous one
                if(arr[j] < arr[j-1]){
                    temp = arr[j];
                    arr[j] =arr[j-1];
                    arr[j-1] = temp;
                    swapped = true;
                }
            }
            //if no element was swapped that means the array was sorted
            // and we do not need to perform any  additional loop
            if(swapped == true) break;
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] array = { 2,3, 1, 5, 7, 9, 4};

        for (int val : bubbleSort(array)) {
            System.out.print(val + " ");
        }
    }
}
