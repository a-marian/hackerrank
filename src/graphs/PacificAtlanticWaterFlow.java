package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow {

    public static void main(String[] args)
    {
        int[][] mat=
        {
                { 1,2,2,3,5 },
                { 3,2,3,4,4 },
                { 2,4,5,3,1 },
                { 6,7,1,4,5 },
                { 5,1,1,2,4 },
        };

        List<List<Integer>> result =  pacificAtlantic(mat);

        for (List<Integer> position : result ) {
            System.out.println(position);
        }
    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        //M*N matrix
        int ROWS = heights.length;
        int COLS = heights[0].length;

        boolean[][]atlanticVisited = new boolean[ROWS][COLS];
        boolean[][]pacificVisited = new boolean[ROWS][COLS];

        for (int col = 0; col < COLS ; col++) {
           DFS(0,col, ROWS, COLS, pacificVisited, heights[0][col], heights);
           DFS(ROWS-1, col, ROWS, COLS, atlanticVisited, heights[ROWS-1][col], heights);
        }
        for (int row = 0; row < ROWS; row++) {
            DFS(row, 0, ROWS, COLS, pacificVisited, heights[row][0], heights);
            DFS(row, COLS-1, ROWS, COLS, atlanticVisited, heights[row][COLS-1], heights);
        }

        List<List<Integer>> response = new ArrayList<List<Integer>>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS ; j++) {
                if(pacificVisited[i][j] && atlanticVisited[i][j])
                    response.add(Arrays.asList(i,j));
            }
        }
        return response;
    }

    private static void DFS(int row, int col, int rows, int cols,
                            boolean[][]visited, int prevHeight, int [][]heights){

        if(row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col]
                || prevHeight > heights[row][col])
            return;
        visited[row][col] = true;
        DFS(row+1, col, rows, cols, visited, heights[row][col], heights);
        DFS( row-1, col, rows, cols, visited,heights[row][col], heights);
        DFS(row, col+1, rows, cols, visited, heights[row][col], heights);
        DFS(row, col-1, rows, cols, visited, heights[row][col], heights);
    }
}

