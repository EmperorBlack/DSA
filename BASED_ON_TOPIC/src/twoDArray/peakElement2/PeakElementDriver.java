package twoDArray.peakElement2;

public class PeakElementDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public int[] findPeakGrid(int[][] mat) {

    int i =0;int j = mat[0].length-1;
    while (i<=j){
      int mid = i+(j-i)/2;
      int maxRowInd = findMax(mat,mid);
      int left = mid-1 >= 0 ? mat[maxRowInd][mid-1]  : -1;
      int right = mid+1 < mat[0].length ? mat[maxRowInd][mid+1] : -1;
      if(mat[maxRowInd][mid] > left && mat[maxRowInd][mid] > right){
        return new int[]{maxRowInd,mid};
      } else if (mat[maxRowInd][mid] > left) {
        i = mid+1;
      } else  {
        j = mid-1;
      }

    }

return new int[]{-1,-1};


  }


  private int findMax(int arr[][],int col){
    int max = -1;int index =-1;
    for (int i = 0; i < arr.length; i++) {
      if(max < arr[i][col]){
        max = arr[i][col];
        index = i;
      }
    }
    return index;
  }

}
