package graph.floodFill;

import java.util.Arrays;

public class FloodFillDriver {

  public static void main(String[] args) {

    int[][] input = {{0,0,0},{0,0,0}};
    new Solution().floodFill(input,1,1,2);
    System.out.println(Arrays.toString(input[0]));
    System.out.println(Arrays.toString(input[1]));
//    System.out.println(Arrays.toString(input[2]));
  }
}

class Solution {
  public int[][] floodFill(int[][] image, int sr, int sc, int color) {
    if(image[sr][sc] == color){
      return image;
    }

    int srcClr = image[sr][sc];
    dfs(image,sr,sc,srcClr,color);
    return image;

  }

  private void dfs(int[][] image, int sr, int sc,int srcClr, int color){
    if(sr <0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] == color || image[sr][sc] != srcClr){
      return;
    }

    image[sr][sc] = color;
    dfs(image,sr+1,sc,srcClr,color);
    dfs(image,sr-1,sc,srcClr,color);
    dfs(image,sr,sc+1,srcClr,color);
    dfs(image,sr,sc-1,srcClr,color);

  }
}
