package dp.TriangleMinPathDp;

import java.util.Arrays;
import java.util.List;

public class TriangleMinPathDpDriver {

  public static void main(String[] args) {
    List<List<Integer>> nestedList = Arrays.asList(
        Arrays.asList(2),
        Arrays.asList(3, 4),
        Arrays.asList(6, 5, 7),
        Arrays.asList(4, 1, 8, 3)
    );

    System.out.println(new Solution().minimumTotal( nestedList));
  }
}

class Solution {
  public int minimumTotal(List<List<Integer>> triangle) {

//    List<List<Integer>> dp = new java.util.ArrayList<>();
//    for (int i = 0; i < triangle.size(); i++) {
//      dp.add(new java.util.ArrayList<>());
//      for (int j = 0; j < triangle.get(i).size(); j++) {
//        dp.get(i).add(-1);
//      }
//    }


//    return minimumTotalHelper(triangle,0,0,dp);
    return minimumTotalTab(triangle);
  }

  private int minimumTotalHelper(List<List<Integer>> triangle, int index, int col, List<List<Integer>> dp){

    if(index == triangle.size()-1){
      return triangle.get(index).get(col);
    }

    if(dp.get(index).get(col) != -1){
      return dp.get(index).get(col);
    }

    int left = triangle.get(index).get(col) + minimumTotalHelper(triangle,index+1,col,dp);
    int right = triangle.get(index).get(col) + minimumTotalHelper(triangle,index+1,col+1,dp);
    dp.get(index).set(col,Math.min(left,right));
    return Math.min(left,right);
  }

  private int minimumTotalTab(List<List<Integer>> triangle){

    for (int i = triangle.size()-2; i >=0 ; i--) {

      for (int j = 0; j < triangle.get(i).size(); j++) {

        int left = triangle.get(i+1).get(j)+ triangle.get(i).get(j);
        int right = triangle.get(i+1).get(j+1)+ triangle.get(i).get(j);
        triangle.get(i).set(j,Math.min(left,right));
      }

    }

    return triangle.get(0).get(0);


  }
}
