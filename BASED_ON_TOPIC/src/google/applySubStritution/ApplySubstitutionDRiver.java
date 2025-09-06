package google.applySubStritution;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ApplySubstitutionDRiver {

  public static void main(String[] args) {

//    System.out.println(new Solution().applySubstitutions(Arrays.asList(Arrays.asList("A","bce"),Arrays.asList("B","ace"), Arrays.asList("C","abc%B%")),"%A%_%B%_%C%"));
    System.out.println(new Solution().applySubstitutions(Arrays.asList(Arrays.asList("O","eohcr")),"%O%"));
  }
}

class Solution {
  public String applySubstitutions(List<List<String>> replacements, String text) {


    Map<String, String> mapping = new HashMap<>();
    for (List<String> replacement : replacements){
      mapping.put(replacement.get(0), replacement.get(1));
    }

    List<List<Integer>> graph = new ArrayList<>();
    for(int i=0;i< 26;i++){
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < replacements.size(); i++) {
      char key = replacements.get(i).get(0).charAt(0);
      String replacementText = replacements.get(i).get(1);

      for (int j = 0; j < replacementText.length(); j++) {
        if(replacementText.charAt(j) == '%'){
          char c = replacementText.charAt(j+1);
          graph.get(key-'A').add(c-'A');
          j = j+2;
        }
      }
    }
    

    int[] indegree = new int[26];
    for(int i=0;i< graph.size();i++){
      for (int j = 0; j < graph.get(i).size(); j++) {
        int dest = graph.get(i).get(j);
        indegree[dest]++;
      }
    }
    Queue<Integer> queue = new ArrayDeque<>();

    for (int i = 0; i < indegree.length; i++) {
      if(indegree[i] ==0 && mapping.get(String.valueOf((char)(i+'A')))!=null){
        queue.offer(i);
      }
    }
    
    List<Integer> tSort = new ArrayList<>();
    while (!queue.isEmpty()){
      int node = queue.poll();
      tSort.add(node);
      for (int i = 0; i < graph.get(node).size(); i++) {
        indegree[graph.get(node).get(i)]--;
        if(indegree[graph.get(node).get(i)] ==0){
          queue.offer(graph.get(node).get(i));
        }
      }
    }

    for (int i = 0; i < tSort.size(); i++) {
      int node =tSort.get(i);
      String onlyKey = String.valueOf((char)(node+'A'));
      String key = "%"+onlyKey+"%";
      text = text.replaceAll(key,mapping.get(onlyKey));
    }
    
    
    return text;
  }

  
}

class Solution_2 {
  public String applySubstitutions(List<List<String>> replacements, String text) {

    // Use fixed-size array instead of HashMap
    String[] mapping = new String[26];

    for (List<String> replacement : replacements) {
      char key = replacement.get(0).charAt(0);
      mapping[key - 'A'] = replacement.get(1);
    }

    // Fixed size graph and indegree
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < 26; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < replacements.size(); i++) {
      char from = replacements.get(i).get(0).charAt(0);
      String replacementText = replacements.get(i).get(1);

      for (int j = 0; j < replacementText.length() - 2; j++) {
        if (replacementText.charAt(j) == '%' && replacementText.charAt(j + 2) == '%') {
          char to = replacementText.charAt(j + 1);
          graph.get(from - 'A').add(to - 'A');
          j += 2;
        }
      }
    }

    int[] indegree = new int[26];
    for (int i = 0; i < 26; i++) {
      for (int neighbor : graph.get(i)) {
        indegree[neighbor]++;
      }
    }

    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < 26; i++) {
      if (mapping[i] != null && indegree[i] == 0) {
        queue.offer(i);
      }
    }

    List<Integer> tSort = new ArrayList<>();
    while (!queue.isEmpty()) {
      int node = queue.poll();
      tSort.add(node);
      for (int neighbor : graph.get(node)) {
        if (--indegree[neighbor] == 0) {
          queue.offer(neighbor);
        }
      }
    }

    // Apply replacements in topological order
    for (int i = tSort.size() - 1; i >= 0; i--) {
      int node = tSort.get(i);
      String key = "%" + (char) (node + 'A') + "%";
      String val = mapping[node];
      if (val == null) continue;

      StringBuilder newVal = new StringBuilder();
      for (int j = 0; j < val.length(); ) {
        if (val.charAt(j) == '%' && j + 2 < val.length() && val.charAt(j + 2) == '%') {
          char sub = val.charAt(j + 1);
          String repl = mapping[sub - 'A'];
          newVal.append(repl != null ? repl : "%" + sub + "%");
          j += 3;
        } else {
          newVal.append(val.charAt(j++));
        }
      }
      mapping[node] = newVal.toString();
    }

    // Final replacement on input text
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < text.length(); ) {
      if (text.charAt(i) == '%' && i + 2 < text.length() && text.charAt(i + 2) == '%') {
        char key = text.charAt(i + 1);
        String repl = mapping[key - 'A'];
        result.append(repl != null ? repl : "%" + key + "%");
        i += 3;
      } else {
        result.append(text.charAt(i++));
      }
    }

    return result.toString();
  }
}
