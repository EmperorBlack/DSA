package graph.wordLadderOne;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

public class WordLadderDriver {

  public static void main(String[] args) {

  }
}


class Pair {
  String word;
  int distance;

  public Pair(String word, int distance) {
    this.word = word;
    this.distance = distance;
  }
}

class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {


    if(!wordList.contains(endWord) || beginWord.equals(endWord)){
      return 0;
    }

    Queue<Pair> queue = new ArrayDeque<>();
    queue.offer(new Pair(beginWord, 1));

    wordList.remove(beginWord);

    while (!queue.isEmpty()){

      Pair curr = queue.poll();

      for (int i = 0; i < curr.word.length(); i++) {
        StringBuilder word = new StringBuilder(curr.word);

        for (char c = 'a'; c<='z';c++){

          word.setCharAt(i,c);
          if(word.toString().equals(endWord)){
            return curr.distance+1;
          } else if(wordList.contains(word.toString())){
            queue.offer(new Pair(word.toString(),curr.distance+1));
            wordList.remove(word.toString());
          }
          word.setCharAt(i,curr.word.charAt(i));
        }
      }
    }


    return 0;
  }
}