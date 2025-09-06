package recursion.wordSearch;

public class WordSearchDriver {

  public static void main(String[] args) {

//    char c[][] = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    char c[][] = {{'a'}};
    System.out.println(new Solution().exist(c,"a"));

  }
}


class Solution {
  public boolean exist(char[][] board, String word) {


    int m = board.length;
    int n = board[0].length;
    boolean[][] visited = new boolean[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {

      if(exist(board,word,i,j,0,visited)){
        return true;
      }

      }
    }
    return false;
  }


  public boolean exist(char[][] board, String word, int i , int j, int wordInd, boolean[][] visited) {
    if(wordInd >= word.length()){
      return true;
    }
    if(board[i][j] != word.charAt(wordInd)){
      return false;
    }

    visited[i][j] = true;
    int[] delI = {1,0,-1,0};
    int[] delJ = {0,1,0,-1};

    for (int k = 0; k < 4; k++) {

      int di = i + delI[k];
      int dj = j + delJ[k];
      if (di >= board.length || di < 0 || dj >= board[0].length || dj < 0){
        continue;
      }
      if(!visited[di][dj] && exist(board,word,di,dj,wordInd+1,visited)){
        return true;
      }
    }

//    for special case where word already matched, but it is not going forward in recursion
//    because there is no valid index.
    if(wordInd+1 >= word.length()){
      return true;
    }

    visited[i][j] = false;
    return false;

  }

}