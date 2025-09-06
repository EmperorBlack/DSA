package randomPractice.peakElement2;

import java.util.Arrays;

public class PeakElement2Driver {

  public static void main(String[] args) {

    System.out.println(Arrays.toString(new Solution().findPeakGrid(new int[][]{{1, 4}, {3, 2}})));
  }
}

class Solution {
  public int[] findPeakGrid(int[][] mat) {
    int l = 0; int r = mat[0].length;

    while (l <= r){

      int mid = l + (r-l)/2;
      int ind = findMax(mat,mid);
      int left = mid > 0 ? mat[ind][mid-1] : -1;
      int right = mid < mat[0].length-1 ? mat[ind][mid+1] : -1;
      if(mat[ind][mid] > left && mat[ind][mid] > right){
        return new int[]{ind,mid};
      }else if(mat[ind][mid] > left){
        l = mid+1;
      }else{
        r= mid-1;
      }

    }

    return new int[]{-1,-1};





  }


  private int findMax(int arr[][],int col){

    int max = Integer.MIN_VALUE;
    int maxIndex = -1;
    for (int i = 0; i < arr.length; i++) {

      if(max < arr[i][col]){
        max = arr[i][col];
        maxIndex = i;
      }

    }
    return maxIndex;
  }

}

