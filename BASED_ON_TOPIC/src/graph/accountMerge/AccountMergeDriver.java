package graph.accountMerge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

public class AccountMergeDriver {

  public static void main(String[] args) {


    List<List<String>> accounts = new ArrayList<>();

    accounts.add(new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com")));
    accounts.add(new ArrayList<>(Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com")));
    accounts.add(new ArrayList<>(Arrays.asList("Mary", "mary@mail.com")));
    accounts.add(new ArrayList<>(Arrays.asList("John", "johnnybravo@mail.com")));

    System.out.println(new Solution().accountsMerge(accounts));

  }
}

class Solution {
  public List<List<String>> accountsMerge(List<List<String>> accounts) {

    int node = accounts.size();
    DisjointSet set = new DisjointSet(node);

    Map<String, Integer> mapNodeToEmails = new HashMap<>();


    for (int i = 0; i < node; i++) {
      for (int j = 1; j < accounts.get(i).size(); j++) {
        String email = accounts.get(i).get(j);
        if(mapNodeToEmails.containsKey(email)){
          set.unionBySize(i,mapNodeToEmails.get(email));
        }else{
          mapNodeToEmails.put(email,i);
        }
      }
    }

    Map<Integer, TreeSet<String>> mergedEmails = new HashMap<>();

    for (Map.Entry<String,Integer> emailAndNode: mapNodeToEmails.entrySet()){
      int nodeUp = set.findParent(emailAndNode.getValue());
      TreeSet<String> treeSet =  mergedEmails.getOrDefault(nodeUp,new TreeSet<>());
      treeSet.add(emailAndNode.getKey());
      mergedEmails.put(nodeUp,treeSet);
    }

    List<List<String>> result = new ArrayList<>();
    for (Map.Entry<Integer, TreeSet<String>> entry : mergedEmails.entrySet()){
      List<String> list = new ArrayList<>(entry.getValue());
      list.add(0,accounts.get(entry.getKey()).get(0));
      result.add(list);
    }
    return result;

  }
}

class DisjointSet{

  List<Integer> parents = new ArrayList<>();
  List<Integer> size = new ArrayList<>();

  public DisjointSet(int n) {
    for (int i = 0; i < n; i++) {

      parents.add(i);
      size.add(1);
    }
  }

  public int findParent(int node){

    if(node == parents.get(node)){
      return node;
    }

    int uP = findParent(parents.get(node));
    parents.set(node,uP);
    return uP;
  }

  public void unionBySize(int u , int v){

    int upU = findParent(u);
    int upV = findParent(v);

    if(upU == upV){
      return;
    }

    int upUSize = size.get(upU);
    int upVSize = size.get(upV);

    if(upUSize > upVSize){
      parents.set(upV,upU);
      size.set(upU,upUSize+upVSize);
    }else{
      parents.set(upU,upV);
      size.set(upV,upUSize+upVSize);
    }



  }
}
