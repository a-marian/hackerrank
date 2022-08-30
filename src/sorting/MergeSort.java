package sorting;

import java.util.Arrays;
import java.util.List;


public class MergeSort {


    public static  void mergeSort(int [] arr, int low, int high){
        //base case
        if (high <= low) return;
        //divide
        int middle = (low+high)/2;
        mergeSort(arr, low, middle);
        mergeSort(arr,middle+1, high);
        //conquer
         merge(arr, low, middle, high);
    }

    public static void merge(int[]array, int low, int mid, int high){
        // Creating temporary subarrays
        int leftArr[] = new int[mid - low + 1];
        int rightArr[] = new int[high - mid];

        // Copying our subarrays into temporaries
        for (int i = 0; i < leftArr.length; i++)
            leftArr[i] = array[low + i];
        for (int i = 0; i < rightArr.length; i++)
            rightArr[i] = array[mid + i + 1];

        //iterators containing current index of temp subArrays
        int leftIndex=0;
        int rightIndex=0;
        //copying from leftArray and rightArray back into array
        for (int i = low; i < high+1 ; i++) {
            // if there are still uncopied elements in R and L, copy minimum of the two
            if(leftIndex < leftArr.length && rightIndex < rightArr.length){
                if(leftArr[leftIndex] < rightArr[rightIndex]){
                    array[i] = leftArr[leftIndex];
                    leftIndex++;
                }else {
                    array[i] = rightArr[rightIndex];
                    rightIndex++;

                }
            } else if (leftIndex < leftArr.length) {
                //If all elements have been copied from rightArray, copy rest of leftArray
                array[i] = leftArr[leftIndex];
                leftIndex++;

            } else if (rightIndex < rightArr.length) {
                //if all elements have been copied from leftArray, copy rest of rightArray
                array[i] =rightArr[rightIndex];
                rightIndex++;

            }
            System.out.println(Arrays.toString(array));
        }
    }



    public static void main(String[] args) {

        List<Integer> array = Arrays.asList(2,1,3,1,2);
        int[] arrForMerge = array.stream().mapToInt(i-> i).toArray();
        mergeSort(arrForMerge, 0, arrForMerge.length-1);
        System.out.println(Arrays.toString(arrForMerge));

    }

}
