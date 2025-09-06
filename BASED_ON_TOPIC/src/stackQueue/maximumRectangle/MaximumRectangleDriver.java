package stackQueue.maximumRectangle;

public class MaximumRectangleDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public int maximalRectangle(char[][] matrix) {

    int[] heights =new int[matrix[0].length];
    int maxRectResult = Integer.MIN_VALUE;
    for (int i = 0; i < matrix.length; i++) {

      for (int j = 0; j < matrix[0].length; j++) {

        if(matrix[i][j] == '0'){
          heights[j] = 0;
        }else{
          heights[j] = heights[j]+1;
        }
      }

      maxRectResult = Math.max(maxRectResult,maxRectangleInHistogram(heights));


    }
    return maxRectResult;

  }

  private int maxRectangleInHistogram(int[] arr){


    int[] preSmall = new int[arr.length];
    int[] nextSmall = new int[arr.length];

    preSmall[0] = -1;
    nextSmall[arr.length-1] = arr.length;

    for (int i = 1; i < arr.length; i++) {

      int p = i-1;
      while (p >= 0 && arr[p] >= arr[i]){
        p = preSmall[p];
      }
      preSmall[i] = p;
    }

    for (int i = arr.length-2; i >= 0; i--) {

      int p = i+1;
      while (p < arr.length && arr[p] >= arr[i]){
        p = nextSmall[p];
      }
      nextSmall[i] = p;
    }

    int maxRect = 0;

    for (int i = 0; i < arr.length; i++) {

      int currRect = (nextSmall[i]-preSmall[i]-1)*arr[i];
      maxRect = Math.max(currRect,maxRect);
    }


    return maxRect;
  }
}


