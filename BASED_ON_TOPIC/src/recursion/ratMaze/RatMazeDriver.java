package recursion.ratMaze;

import java.util.ArrayList;
import java.util.Collections;

public class RatMazeDriver {

  public static void main(String[] args) {

  }
}


class Solution {
  // Function to find all possible paths
  public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
    // code here

    ArrayList<String> result = new ArrayList<>();
    boolean[][] visited = new boolean[mat.size()][mat.get(0).size()];
    findPathHelper(mat,visited,result,new StringBuilder(),0,0);
    Collections.sort(result);
    return result;

  }

  private void findPathHelper(ArrayList<ArrayList<Integer>> mat, boolean[][] visited, ArrayList<String> result, StringBuilder temp,int i, int j){

    if(i >= mat.size() || j >= mat.get(0).size() || i < 0 || j < 0 || visited[i][j]){
      return;
    }

    if(i == mat.size()-1 && j == mat.get(0).size()-1){
      result.add(new String(temp));
    }

    visited[i][j] = true;
    if(mat.get(i).get(j) == 1){

        findPathHelper(mat,visited, result, temp.append("D"), i+1, j);
        temp.deleteCharAt(temp.length()-1);
        findPathHelper(mat,visited, result, temp.append("R"), i, j+1);
        temp.deleteCharAt(temp.length()-1);
        findPathHelper(mat,visited, result, temp.append("U"), i-1, j);
        temp.deleteCharAt(temp.length()-1);
        findPathHelper(mat,visited, result, temp.append("L"), i, j-1);
        temp.deleteCharAt(temp.length()-1);

    }

    visited[i][j] = false;

  }
}