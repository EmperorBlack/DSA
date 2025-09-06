package randomPractice.matrixMedian;

public class MatrixMedianDriver {

  public static void main(String[] args) {

  }

}

class Solution {
  int median(int mat[][]) {
    // code here

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < mat[0].length; i++) {

      min = Math.min(min,mat[i][0]);
      max = Math.max(max,mat[i][mat[0].length-1]);
    }
    int m = mat.length;
    int n = mat[0].length;

    int midCount = (m*n)/2;
    while (min<=max){

      int mid = min + (max-min)/2;
      int lessCount = getLessThanCount(mat,mid);

      if(lessCount <= midCount){
        min = mid+1;
      }else{
        max = mid-1;
      }

    }
    return min;

  }

  int getLessThanCount(int mat[][], int target){

    int count =0;
    for (int i = 0; i < mat.length; i++) {

      int l = 0,r = mat[0].length-1;
      while(l <= r){
        int mid = l+ (r-l)/2;
        if(mat[i][mid] <= target){
          l = mid+1;
        }else{
          r= mid-1;
        }
      }
      count += l;
    }
    return count;
  }
}
