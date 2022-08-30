package greedy;
/**
 * You are given a matrix N*N rotate 90ª grades
 * [[1,2,3]             [[7,4,1],
 *  [4,5,6]     ->       [8,5,2],
 *  [7,8,9]]             [9,6,3]]
 * */
public class RotateImage {

    //Step 1: transpose matrix - to convert rows in columns
    //swap(array[i][j], array[i][j])

   static int[][] rotateImage(int[][] matrix){
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N ; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //step 2 - flip horizontally
        // swap(array[i][j], array[i][N-1-j])
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N/2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][N-1-j];
                matrix[i][N-1-j] = temp;
            }
        }

        return  matrix;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};

        int[][]result = rotateImage(matrix);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j]+ " ");
            }
            System.out.println();
        }
        //time complexity O(2N)
    }
}
