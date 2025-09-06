package twoDArray.maximumOne;

public class MaximumOneDriver {

  public static void main(String[] args) {

    System.out.println(new Solution_g().rowWithMax1s(new int[][]{{0,1,1,1},{0,0,1,1},{1,1,1,1},{0,0,0,0}}));


  }


}
class Solution {
  public int[] rowAndMaximumOnes(int[][] mat) {


    int row[] = new int[mat.length];

    for (int i = 0; i < mat.length; i++) {
      int ones =0;
      for (int j = 0; j < mat[i].length; j++) {
        if(mat[i][j] == 1){
          ones++;
        }

      }

      row[i] = ones;

    }

    int max = Integer.MIN_VALUE;
    int index =-1;
    for (int i = 0; i < row.length; i++) {

      if(max < row[i]){
        max = row[i];
        index = i;
      }
    }
    return new int[]{index,max};

  }
}

//sorted row arrays
class Solution_g {
  public int rowWithMax1s(int arr[][]) {
    return rowWithMax1Bs(arr);
  }

  public int rowWithMax1Bs(int arr[][]){

    int index = -1;
    int max = 0;
    for (int i = 0; i < arr.length; i++) {

      int tempIndex = getIndexOfOne(arr[i]);
      int tempMax = arr[i].length - tempIndex;
      if(tempMax > max){
        max = tempMax;
        index = i;
      }

    }
    return index;


  }

  public int getIndexOfOne(int arr[]){
    int i = 0;
    int j = arr.length-1;
    while(i <= j){

      int mid = i + (j-i)/2;
      if(arr[mid] == 1){
        j = mid-1;
      }else{
        i= mid+1;
      }
    }
    return i;
  }
}