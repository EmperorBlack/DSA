package twoDArray.SeachIn2DMat2;

public class SearchIn2DMatrixDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().searchMatrix(new int[][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}},5));
  }
}

class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {


    int i = 0; int j = matrix[0].length-1;
    while (i < matrix.length && j >= 0){

      if(matrix[i][j] == target){
        return true;
      }else if (matrix[i][j] > target){
        j--;
      }else {
        i++;
      }
    }
    return false;
  }
}

class Solution_2 {
  public boolean searchMatrix(int[][] matrix, int target) {


    int i = 0; int j = (matrix[0].length * matrix.length)-1;
    while (i <= j){

      int mid = i+(j-i)/2;
      int delRow = mid/matrix[0].length;
      int delCol = mid%matrix[0].length;
      if(matrix[delRow][delCol] == target){
        return true;
      }else if (matrix[delRow][delCol] > target){
        j = mid-1;
      }else {
        i = mid+1;
      }
    }
    return false;
  }
}
