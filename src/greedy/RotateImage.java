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

        public static void rotate2V(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < (n + 1) / 2; i ++) {
                for (int j = 0; j < n / 2; j++) {
                    int temp = matrix[n - 1 - j][i];
                    matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                    matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                    matrix[j][n - 1 - i] = matrix[i][j];
                    matrix[i][j] = temp;
                }
            }
        }


    public static void main(String[] args) {
        //time complexity O(2N)
        int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        int[][]result = rotateImage(matrix);
        printMatrix(result);
        System.out.println("-------");
        //time complexity O(N)
        int[][] matrix2 = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        rotate2V(matrix2);
        printMatrix(matrix2);

    }

    private static void printMatrix(int[][]matrix){

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
    }
}
