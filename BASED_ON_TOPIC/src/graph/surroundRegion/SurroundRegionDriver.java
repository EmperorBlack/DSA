package graph.surroundRegion;

public class SurroundRegionDriver {

  public static void main(String[] args) {
    new Solution().solve(new char[][]{
            {'X','X','X','X'},
            {'X','O','O','X'},
            {'X','X','O','X'},
            {'X','O','X','X'}
        }
    );
  }
}

class Solution {
  public void solve(char[][] board) {

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {

        if((i == 0 || i == (board.length-1) || j ==0 || j == board[i].length-1) && board[i][j] =='O'){
          board[i][j] = 'E';
          exploreUnSurroundRegion(board, i, j);
        }
      }

    }

    for (int i = 0; i < board.length ; i++) {
      for (int j = 0; j < board[i].length; j++) {

        if(board[i][j] == 'O'){
          board[i][j] = 'X';
        } else if (board[i][j] == 'E') {
          board[i][j] = 'O';
        }
      }
    }

  }

  private void exploreUnSurroundRegion(char[][] board, int i, int j){

    int[] delRow = {-1, 0, 1, 0};
    int[] delCol = {0, 1, 0, -1};

    for (int k = 0; k < 4; k++) {

      int delI = i + delRow[k];
      int delJ = j + delCol[k];

      if(delI >=0 && delJ >=0 && delI < board.length && delJ < board[0].length && board[delI][delJ] == 'O'){
        board[delI][delJ] = 'E';
        exploreUnSurroundRegion(board, delI, delJ);
      }
    }


  }
}
