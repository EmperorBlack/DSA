package dp.maximalSquare;

public class MaxSquareDriver {


  public static void main(String[] args) {
    char[][] matrix = {
        {'0', '1'},
        {'1','0'}
    };
    System.out.println(new Solution_2().maximalSquare(matrix));
  }
}

class Solution {
  public int maximalSquare(char[][] matrix) {

    int[] histo = new int[matrix[0].length];
    int maxSquare = 0;
    for(int i = 0;i< matrix.length;i++){
      for(int j = 0;j< matrix[0].length;j++){
        if(matrix[i][j] == '0'){
          histo[j] = 0;
        }else{
          histo[j] = histo[j]+1;
        }
      }

      int max = maximalHisto(histo);
      maxSquare = Math.max(max,maxSquare);
    }
    return maxSquare;

  }


  private int maximalHisto(int[] histo){

    int[] preSmall = new int[histo.length];
    int[] nextSmall = new int[histo.length];

    for(int i=0;i<histo.length;i++){

      int index = i-1;
      while(index >=0 && histo[index] >= histo[i]){
        index = preSmall[index];
      }
      preSmall[i] = index;
    }

    for(int i=histo.length-1;i>=0;i--){

      int index = i+1;
      while(index < histo.length && histo[index] >= histo[i]){
        index = nextSmall[index];
      }
      nextSmall[i] = index;
    }

    int maxSquare = 0;
    for(int i=0;i<histo.length;i++){

      int range = (nextSmall[i]-preSmall[i])-1;
      if(histo[i] <= range){
        int square = histo[i]*histo[i];
        if(maxSquare < square){
          maxSquare = square;
        }
      }

    }
    return maxSquare;


  }
}


class Solution_2 {
  public int maximalSquare(char[][] matrix) {


    int[][] countMat = new int[matrix.length][matrix[0].length];
    int max =0;
    for(int i =0;i<matrix.length;i++){
      if(matrix[i][0] == '0'){
        countMat[i][0] = 0;
      }else{
        countMat[i][0] = 1;
      }
      max = Math.max(max,countMat[i][0]);
    }

    for(int i =0;i<matrix[0].length;i++){
      if(matrix[0][i] == '0'){
        countMat[0][i] = 0;
      }else{
        countMat[0][i] = 1;
      }
      max = Math.max(max,countMat[0][i]);
    }


    for(int row = 1;row< matrix.length;row++){
      for(int col =1;col<matrix[0].length;col++){

        if(matrix[row][col] == '1'){


          countMat[row][col] = Math.min(Math.min(countMat[row-1][col],countMat[row][col-1]),countMat[row-1][col-1])+1;

          max = Math.max(max,countMat[row][col]);

        }

      }
    }
    return max*max;




  }
}

