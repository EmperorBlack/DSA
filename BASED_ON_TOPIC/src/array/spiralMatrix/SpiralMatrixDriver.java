package array.spiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixDriver {

  public static void main(String[] args) {

    new Solution().spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}});
  }
}


class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {

    int rowMax = matrix.length-1;
    int colMax = matrix[0].length-1;
    int rowMin = 0;
    int colMin = 0;
    List<Integer> list = new ArrayList<>();

    while (rowMax >= rowMin && colMax >= colMin){

      int i = rowMin;
      int j = colMin;
      while (j <= colMax){
        list.add(matrix[i][j]);
        j++;
      }
      rowMin++;
      if(rowMin > rowMax){
        break;
      }
      i=rowMin;
      j= colMax;
      while (i <= rowMax){
        list.add(matrix[i][j]);
        i++;
      }
      colMax--;
      if(colMin>colMax){
        break;
      }

      j=colMax;
      i =rowMax;

      while (j >= colMin){
        list.add(matrix[i][j]);
        j--;
      }
      rowMax--;
      if(rowMin > rowMax){
        break;
      }
      j=colMin;
      i=rowMax;
      while (i >= rowMin){
        list.add(matrix[i][j]);
        i--;
      }

      colMin++;

    }

    System.out.println(list);
    return list;
  }
}