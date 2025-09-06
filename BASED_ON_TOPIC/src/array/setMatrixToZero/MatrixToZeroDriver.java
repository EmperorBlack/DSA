package array.setMatrixToZero;

public class MatrixToZeroDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public void setZeroes(int[][] matrix) {


    int[] rows = new int[matrix.length];
    int[] cols = new int[matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {

        if(matrix[i][j] == 0){
          rows[i] = 1;
          cols[j] =1;
        }

      }
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[i].length; j++) {
        if(rows[i] ==1 || cols[j] ==1){

          matrix[i][j] = 0;
        }
      }
    }
  }
}


class Solution2 {
  public void setZeroes(int[][] matrix) {


    int rows = matrix.length-1;
    int cols = matrix[0].length-1;
    int col0 = 1;

    for (int i = 0; i < matrix.length; i++) {
      if(matrix[i][0] == 0 )
        col0 =0;
      for (int j = 1; j < matrix[i].length; j++) {

        if(matrix[i][j] == 0){
          matrix[i][0] =0;
          matrix[0][j] =0;
        }

      }
    }

    for (int i = rows; i > 0; i--) {
      for (int j = cols; j > 0; j--) {
        if(matrix[i][0] ==0 || matrix[0][j] == 0){

          matrix[i][j] = 0;
        }
      }
      if (col0 == 0) matrix[i][0] = 0;
    }
  }
}

