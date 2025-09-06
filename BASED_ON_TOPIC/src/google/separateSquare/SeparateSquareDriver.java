package google.separateSquare;

public class SeparateSquareDriver {

  public static void main(String[] args) {

  }
}


class Solution {
  public double separateSquares(int[][] squares) {

    double minY = getMinY(squares);
    double maxY = getMaxY(squares);
    double precision = 1e-5;

    while (maxY - minY > precision){
      double midY = (minY+maxY)/2;

      if(isLowerHalfLarger(squares, midY)){
        maxY = midY;
      }else {
        minY = midY;
      }
    }
    return minY;



  }


  private double getMinY (int[][] squares){

    double minY = squares[0][1];
    for(int[] sqr : squares){
      minY = Math.min(minY,sqr[1]);
    }
    return minY;
  }

  private double getMaxY(int[][] squares){

    double maxY = squares[0][1] + squares[0][2];
    for(int[] sqr : squares){
      maxY = Math.max(maxY,sqr[1] + sqr[2]);
    }
    return maxY;
  }

  private boolean isLowerHalfLarger(int[][] squares, double midY){
    double lowerArea = 0, upperArea = 0;

    for (int[] sqr : squares){

      double bottomY = sqr[1],side= sqr[2], topY = bottomY+side;

      if(topY <= midY){
        lowerArea += side*side;
      } else if (bottomY >= midY) {
        upperArea += side*side;
      }else{
        double below = midY-bottomY, above = topY-midY;
        lowerArea += below * side;
        upperArea += above * side;
      }

    }

    return lowerArea >= upperArea;

  }
}

