package miscellaneous.stackAndQueues.dfs;
/**
* Given a 2D  board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 * Example:
 * board = [
 *     [A, B, C, E],
 *     [S, F, C, S],
 *     [A, D, E, E]
 * ]
 * Given word = "ABCCED", return true
 * Given word= "SEE", return true
 * Given word= "ABCB", return false
 * */
public class WordSearch {

    public boolean exist(char[][]board, String word){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j] == word.charAt(0) && dfs(board, i,j));
            }
        }
        return false;
    }

    boolean dfs(char[][]matrix, int a, int b){
        return false;
    }
}
