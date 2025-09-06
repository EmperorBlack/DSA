package twoDArray.matrixMedian;

public class MatrixMedianDriver {

  public static void main(String[] args) {

    System.out.println(Solution.findMedian(new int[][]{{ 1, 5, 7, 9, 11 },
        { 2, 3, 4, 8, 9 },
        { 4, 11, 14, 19, 20 },
        {6, 10, 22, 99, 100 },
        { 7, 15, 17, 24, 28 }  },5,5
));
  }
}

class Solution {
  public static int findMedian(int matrix[][], int m, int n) {

    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for (int i = 0; i < matrix.length; i++) {

      min = Math.min(min,matrix[i][0]);
      max = Math.max(max,matrix[i][n-1]);

    }

    int midCount = (m*n)/2;
    while (min <= max){

      int mid = min + (max-min)/2;
      if(getCount(matrix,m,n, mid) <= midCount){
        min = mid+1;
      }else{
        max = mid-1;
      }
    }

    return min;

  }

  private static int getCount(int matrix[][], int m, int n,int median){

    int count = 0;
    for (int k = 0; k < matrix.length; k++) {
      int i =0; int j = matrix[k].length-1;

      while(i<=j){

        int mid = i+ (j-i)/2;

        if(matrix[k][mid] <= median){
          i = mid+1;
        }else{
          j = mid-1;
        }

      }
      count += i;

    }
    return count;
  }
}
