package google.AutoCompleteSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class AutoCompleteSystemDriver {

  public static void main(String[] args) {


    String[] sentences = {"i love you", "island", "iroman", "i love leetcode"};
    int[] times = {5, 3, 2, 2};

    AutocompleteSystem autocompleteSystem = new AutocompleteSystem(sentences, times);

    System.out.println(autocompleteSystem.input('i')); // ["i love you", "island", "i love leetcode"]
    System.out.println(autocompleteSystem.input(' ')); // ["i love you", "i love leetcode"]
    System.out.println(autocompleteSystem.input('a')); // []

  }
}



class Node {

  Node[] children;
  Map<String, Integer> sentenceMap;

  public Node() {
    this.children = new Node[27]; // 26 letters + space
    this.sentenceMap = new HashMap<>();
  }

  public void setChildren(char c){
    int index = c == ' ' ? 26 : c - 'a';
    if (children[index] == null) {
      children[index] = new Node();
    }
  }

  public Node getChildren(char c) {
    int index = c == ' ' ? 26 : c - 'a';
    return children[index];
  }

  public void addSentence(String sentence, int times){
    sentenceMap.put(sentence, sentenceMap.getOrDefault(sentence, 0) + times);
  }


}


class AutocompleteSystem {

  private final Node trieRoot;
  private Node currentNode;
  private StringBuilder currentInput;


  public AutocompleteSystem(String[] sentences, int[] times) {
    this.trieRoot = new Node();
    this.currentNode = trieRoot;
    this.currentInput = new StringBuilder();

    for(int i = 0; i < sentences.length; i++) {
      String sentence = sentences[i];
      int time = times[i];
      addSentence(sentence, time);
    }
  }


  public void addSentence(String sentence, int times){

    Node curr = trieRoot;

    for(char c : sentence.toCharArray()){
      curr.setChildren(c);
      curr = curr.getChildren(c);
      curr.addSentence(sentence,times);
    }
  }

  public List<String> input(char c) {

    if(c == '#'){
      String sentence = currentInput.toString();
      addSentence(sentence,1);
      currentInput = new StringBuilder();
      currentNode = trieRoot;
      return new ArrayList<>();
    }
    currentInput.append(c);
    if(currentNode == null){
      return Collections.emptyList();
    }
    currentNode = currentNode.getChildren(c);
    if(currentNode == null){
      return Collections.emptyList();
    }

    List<String> sentences = new ArrayList<>();
    for (Map.Entry<String, Integer> entry : currentNode.sentenceMap.entrySet()) {
      sentences.add(entry.getKey());
    }

//    // Sort the sentences based on frequency and lexicographical order
//    Collections.sort(sentences, (a, b) -> {
//      int freqA = currentNode.sentenceMap.get(a);
//      int freqB = currentNode.sentenceMap.get(b);
//      if (freqA != freqB) {
//        return freqB - freqA; // Sort by frequency in descending order
//      }
//      return a.compareTo(b); // Sort lexicographically
//    });

    Queue<String> pq = new PriorityQueue<>((a, b) -> {
      int freqA = currentNode.sentenceMap.get(a);
      int freqB = currentNode.sentenceMap.get(b);
      if (freqA != freqB) {
        return  freqA - freqB; // Sort by frequency in descending order
      }
      return b.compareTo(a); // Sort lexicographically
    });

    List<String> result = new ArrayList<>();
    for (String sentence : sentences) {
      pq.offer(sentence);
      if (pq.size() > 3) {
        pq.poll(); // Keep only the top 3 sentences
      }
    }

    while (!pq.isEmpty()) {
      result.add(0,pq.poll());
    }

   return result;
  }
}
