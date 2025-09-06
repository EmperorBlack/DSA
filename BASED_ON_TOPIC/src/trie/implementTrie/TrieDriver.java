package trie.implementTrie;

public class TrieDriver {

}

//class MyTrie{
//
//  MyTrie[] ds = new MyTrie[26];
//  boolean isEnd;
//
//  public MyTrie( boolean isEnd) {
//    this.isEnd = isEnd;
//  }
//}
//
//
//class Trie {
//
//  MyTrie root = new MyTrie(false);
//
//  public Trie() {
//
//  }
//
//  public void insert(String word) {
//
//    MyTrie curr = root;
//    for (int i = 0; i < word.length(); i++) {
//
//      char c = word.charAt(i);
//      if(curr.ds[c-'a']== null){
//        curr.ds[c-'a'] = new MyTrie(false);
//      }
//      curr = curr.ds[c-'a'];
//      if(i == word.length()-1){
//        curr.isEnd = true;
//      }
//
//    }
//
//  }
//
//  public boolean search(String word) {
//
//    MyTrie curr = root;
//    for (int i = 0; i < word.length(); i++) {
//      char c = word.charAt(i);
//      if(curr.ds[c-'a'] == null){
//        return false;
//      }
//      curr = curr.ds[c-'a'];
//    }
//    return curr.isEnd;
//
//  }
//
//  public boolean startsWith(String prefix) {
//    MyTrie curr = root;
//    for (int i = 0; i < prefix.length(); i++) {
//      char c = prefix.charAt(i);
//      if(curr.ds[c-'a'] == null){
//        return false;
//      }
//      curr = curr.ds[c-'a'];
//    }
//    return true;
//  }
//}
// Better way

class Node{

  Node[] links = new Node[26];
  boolean isEnd = false;

  public Node() {
  }


  public boolean isEnd() {
    return isEnd;
  }

  public void setEnd(boolean end) {
    isEnd = end;
  }

  Node get(char ch){
    return links[ch-'a'];
  }

  void setChar(char ch){
    links[ch-'a'] = new Node();
  }

  boolean containsChar(char ch){
    return !(links[ch-'a'] == null);
  }

}


class MyTrie{

  MyTrie[] ds = new MyTrie[26];
  boolean isEnd;

  public MyTrie( boolean isEnd) {
    this.isEnd = isEnd;
  }
}


class Trie {

  Node root;

  public Trie() {

    root = new Node();
  }

  public void insert(String word) {

    Node curr = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if(!curr.containsChar(c)){
        curr.setChar(c);
      }
      curr = curr.get(c);
      if(i == word.length()-1){
        curr.setEnd(true);
      }
    }

  }

  public boolean search(String word) {

    Node curr = root;
    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if(!curr.containsChar(c)){
        return false;
      }
      curr = curr.get(c);
    }

    return curr.isEnd();

  }

  public boolean startsWith(String prefix) {
    Node curr = root;
    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if(!curr.containsChar(c)){
        return false;
      }
      curr = curr.get(c);
    }

    return true;
  }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

