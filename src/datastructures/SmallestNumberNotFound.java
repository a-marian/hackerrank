package datastructures;
/** Write a function to find the smallest positive integer that is not found in provided array  **/

public class SmallestNumberNotFound {

    public static int findSmallestNumberNotFound(int[]a){
        int smallest = 1;
        int size = a.length;
        int numbers = 0;
        while (numbers < size){

            for (int i = 0; i < size; i++) {
                if(a[i] == smallest) {
                    smallest = a[i] + 1;
                    break;
                }

            }
            numbers++;
        }
        return smallest;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 6, 4, 1, 2};
        int res = findSmallestNumberNotFound(array);
        System.out.println(res);
    }
}
