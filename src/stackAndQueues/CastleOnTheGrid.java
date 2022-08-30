package stackAndQueues;

import java.util.*;
import java.util.stream.IntStream;

public class CastleOnTheGrid {

    static final int [] X_OFFSETS = {-1, 0, 1, 0};
    static final int [] Y_OFFSETS = {0, 1, 0, -1};

    static class Point{
        int x;
        int y;

        Point(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

    public static int minimumMoves(List<String> grid,
                                   int startX, int startY, int goalX, int goalY) {
        if (startX == goalX && startY == goalY) return 0;
        //create a queue for doing BFS
        int gridsize = grid.size();
        char[][] gridmat = new char[gridsize][gridsize];
        //making the matrix
        for (int i = 0; i < gridsize; i++) {
            for (int j = 0; j < gridsize ; j++) {
                gridmat[i][j] = grid.get(i).charAt(j);
                System.out.print(gridmat[i][j]+" ");
            }
            System.out.println();
        }

        int[][] moves = new int[gridsize][gridsize];
        IntStream.range(0, gridsize).forEach(x -> Arrays.fill(moves[x], -1));
        moves[startX][startY] = 0;

        Queue<Point> queuey = new ArrayDeque<>();
        queuey.offer(new Point(startX, startY));

        while(true){
            Point point = queuey.poll();
            for (int i = 0; i < X_OFFSETS.length; i++) {
                int adjx =  point.x;
                int adjy = point.y;

                while(isValid(gridmat, adjx+X_OFFSETS[i], adjy+Y_OFFSETS[i])){
                    adjx += X_OFFSETS[i];
                    adjy += Y_OFFSETS[i];

                    if(adjx == goalX && adjy == goalY ){
                        return moves[point.x][point.y]+1;
                    }
                    if(moves[adjx][adjy] < 0){
                        moves[adjx][adjy] = moves[point.x][point.y] +1;
                        queuey.offer(new Point(adjx, adjy));
                    }
                }
            }
        }
    }

    static boolean isValid(char[][]grid, int x, int y){
        return x >= 0 && x < grid.length && y >= 0 && y < grid.length && grid[x][y] == '.';
    }

    public static void main(String[] args) {
        List<String> grid1 = new ArrayList<>(Arrays.asList(".X.", ".X.", "..."));
        int startX=0, startY=0, goalX=0, goalY=2;
        System.out.println(minimumMoves(grid1, startX, startY, goalX, goalY));




    }
}
