package stackAndQueues.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class BFSForAMatrix {

    static final int [] X_OFFSETS = {-1, 0, 1, 0};
    static final int [] Y_OFFSETS = {0, 1, 0, -1};

    static final int ROW = 4;
    static final int COL = 4;

    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static boolean isValid(boolean vis[][], int row, int col){
        if(row < 0 || col < 0 || row >= ROW || col >= COL) return false;
        if(vis[ROW][COL]) return false;

        return true;
    }

    static void BFS2DArray (int grid[][], boolean vis[][], int row, int col){
        Queue<Point> queuey = new LinkedList<>();
        queuey.add(new Point(row, col));
        vis[row][col] = true;

        while(!queuey.isEmpty()){
            Point point = queuey.peek();
            int x = point.x;
            int y = point.y;

            System.out.print(grid[x][y]+" ");
            queuey.remove();

            for (int i = 0; i < 4; i++) {
                int adjx = x + X_OFFSETS[i];
                int adjy = y + Y_OFFSETS[i];

                if(isValid(vis, adjx, adjy)){
                    queuey.add(new Point(adjx, adjy));
                    vis[adjx][adjy] = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Given input matrix
        int grid[][] = { { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };

        // Declare the visited array
        boolean [][]vis = new boolean[ROW][COL];

        BFS2DArray(grid, vis, 0, 0);
    }
}

