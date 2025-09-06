package graph.alienDictionary;

import java.util.ArrayList;
import java.util.List;

public class AlienDictionaryDriver {

  public static void main(String[] args) {

    System.out.println(Solution.getAlienLanguage(new String[]{"a","aa","aaa"},1));
  }
}


class Solution {
  public static String getAlienLanguage(String []dictionary, int k) {
    // Write your code here.

    List<List<Integer>> graph = new ArrayList<>();

    for (int i = 0; i < k; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 1; i < dictionary.length; i++) {

      String word1 = dictionary[i-1];
      String word2 = dictionary[i];

      int minLength = Math.min(word1.length(),word2.length());

      for (int j = 0; j < minLength; j++) {
        if(word1.charAt(j) != word2.charAt(j)){
          int src = word1.charAt(j) -'a';
          int dst = word2.charAt(j) - 'a';

          graph.get(src).add(dst);
          break;
        }

      }

    }
    boolean[] visited = new boolean[k];
    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < visited.length; i++) {
      if(!visited[i]) {
        dfs(graph, i, visited, result);
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int i = result.size()-1; i >=0 ; i--) {
      sb.append((char)(result.get(i)+'a'));
    }
    return sb.toString();

  }

  private static void dfs(List<List<Integer>> graph, int src, boolean[] visited,List<Integer> result){
    visited[src] = true;

    for (int i = 0; i < graph.get(src).size(); i++) {
      int next = graph.get(src).get(i);
      if(!visited[next]){
        dfs(graph, next, visited, result);
      }
    }
    result.add(src);
  }
}
