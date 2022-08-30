package stackAndQueues.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class ConvertNegativeValuesInMatrix {

    static class Point {
        int x, y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    //function to check whether given coordinates is a valid cell or not
    private static boolean isValid(int i, int j, int M, int N){
        return (i >= 0 && i < M) && (j >= 0 && j < N);
    }

    //Below arrays detail all four possible movements from a cell
    // (top, right, bottom and left)
    private static int[] row = {-1, 0, 0, 1};
    private static int[] col = {0, -1, 1, 0};

    //returns true if the matrix contains at least one negative value
    private static  boolean hasNegative(int[][]mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] < 0){
                    return true;
                }
            }
        }
        return false;
    }

    //find the minimum number of passes required
    // to convert all negative values in the given matrix to positive
    public static int findMinPasses(int[][] mat){
        //base case
        if(mat == null || mat.length == 0){
            return 0;
        }
        //M * N matrix
        int M= mat.length;
        int N= mat[0].length;

        //create a queue to store cell coordinates of positive integers
        Queue<Point> queuey = new ArrayDeque<>();

        //enqueue cell coordinates of all positive numbers in the matrix
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(mat[i][j] > 0){
                    queuey.offer(new Point(i,j));
                }
            }
        }

        //to keep track of the time taken to make all numbers positive
        int passes = 0;

        //loop till all reacheable negative numbers in the matrix are processed
        while(!queuey.isEmpty()){
            //use two queue to separate positive numbers involved in the previous pass
            // with positive numbers involved in the current pass
            Queue<Point> q;
            //copy contents of the original queue q to another queue q and empty the original queue
            q = new ArrayDeque<>(queuey);
            queuey.clear();

            //START OF THE CURRENT PASS

            //process all cells in the queue
            while(!q.isEmpty()){
                //pop front node and process it
                int x = q.peek().x;
                int y = q.peek().y;
                q.poll();

                //check all four adjacent cell of is valid and has a negative value
                for (int k = 0; k < row.length; k++) {
                    if(isValid(x+ row[k], y +col[k], M, N) && mat[x+ row[k]][y+col[k]] < 0){
                        //make the value positive
                        mat[x+row[k]][y+col[k]] = -mat[x+row[k]][y+col[k]];
                        //enqueue adjacent cell
                        queuey.add(new Point(x+row[k], y+col[k]));
                    }
                }
            }
            /* End of the current pass */

            //increment number of passes by 1
            passes++;
        }
        //return number of passes or -1
        // if the matrix has an unreachable cell which is negative
        return hasNegative(mat) ? -1 : (passes -1);
    }

    public static void main(String[] args) {
        int[][] mat = {
                {-1, -9, 0, -1, 0},
                {-8, -3, -2, 9, -7},
                {2, 0, 0, -6, 0},
                {0, -7, -3, 5, -4}
        };
        int pass = findMinPasses(mat);
        if(pass != -1){
            System.out.print("The total number of passes required is " + pass);
        }else {
            System.out.print("Invalid input");
        }

    }
}
