package recursion.nQueen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueenDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().solveNQueens(1));
  }
}


class Solution {
  public List<List<String>> solveNQueens(int n) {

    char[][] board = new char[n][n];
    for (int i = 0; i < n; i++) {
      Arrays.fill(board[i],'.');
    }

    boolean[] row = new boolean[n];
    boolean[] upDia = new boolean[(2*n) - 1];
    boolean[] downDia = new boolean[(2*n) - 1];
    List<List<String>> result = new ArrayList<>();
    solve(board,0,result,row,upDia,downDia,n);
    return result;

  }

  public void solve(char[][] board,int c, List<List<String>> result,boolean[] row, boolean[] upDia,boolean[] downDia, int n ){

    if(c == n){
      addResult(board,result);
      return;
    }

    for (int i = 0; i < n; i++) {

      if(canPlace(i,c,row,upDia,downDia,n)){
        board[i][c] = 'Q';
        mark(i,c,row,upDia,downDia,n);
        solve(board,c+1,result,row,upDia,downDia,n);
        mark(i,c,row,upDia,downDia,n);
        board[i][c] = '.';
      }

    }



  }

  public void addResult(char[][] board,List<List<String>> result){

    List<String> list = new ArrayList<>();
    for (char[] chars : board) {
      list.add(String.valueOf(chars));
    }
    result.add(list);
  }

  public boolean canPlace(int i, int j, boolean[] row, boolean[] upDia,boolean[] downDia, int n){

    if(row[i]  || upDia[i+j] || downDia[(i-j)+(n-1)]){
      return false;
    }
    return true;
  }

  public void mark(int i, int j, boolean[] row, boolean[] upDia,boolean[] downDia, int n){
    row[i] = !row[i];
    upDia[i+j] = !upDia[i+j];
    downDia[(i-j)+(n-1)] = !downDia[(i-j)+(n-1)];
  }
}