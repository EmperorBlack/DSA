package stackQueue.LFUcache;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public class LFUCacheDriver {

  public static void main(String[] args) {

  }
}

class Node {

  int val;
  int freq;

  public Node(int val, int freq) {
    this.val = val;
    this.freq = freq;
  }

  public Node() {
  }

  public int getVal() {
    return val;
  }

  public void setVal(int val) {
    this.val = val;
  }

  public int getFreq() {
    return freq;
  }

  public void setFreq(int freq) {
    this.freq = freq;
  }
}

class LFUCache {

  int capacity;
  Map<Integer,Node> keyToValNFrq = new HashMap<>();
  Map<Integer, LinkedHashSet<Integer>> freqToLruKeys = new HashMap<>();
  int leastFreq = 0;

  public LFUCache(int capacity) {
    this.capacity = capacity;
  }

  public int get(int key) {

    if(keyToValNFrq.get(key) == null){
      return -1;
    }
    Node node = keyToValNFrq.get(key);
    int freq = node.freq;

    LinkedHashSet<Integer> keys = freqToLruKeys.get(freq);
    keys.remove(key);

    if(keys.isEmpty() && leastFreq == freq){
      leastFreq++;
    }
    LinkedHashSet<Integer> nextFreq = freqToLruKeys.getOrDefault(freq+1,new LinkedHashSet<>());
    nextFreq.add(key);
    freqToLruKeys.put(freq+1,nextFreq);
    node.setFreq(freq+1);
    keyToValNFrq.put(key,node);
    return keyToValNFrq.get(key).getVal();

  }

  public void put(int key, int value) {

    if(keyToValNFrq.get(key)!= null){

      Node node = keyToValNFrq.get(key);
      node.setVal(value);
      keyToValNFrq.put(key,node);
      get(key);
      return;
    }

    if(keyToValNFrq.size() == capacity){

      int keyToDelete = freqToLruKeys.get(leastFreq).iterator().next();
      freqToLruKeys.get(leastFreq).remove(keyToDelete);
      keyToValNFrq.remove(keyToDelete);
    }

    leastFreq = 1;
    LinkedHashSet<Integer> keys = freqToLruKeys.getOrDefault(leastFreq,new LinkedHashSet<>());
    keys.add(key);
    freqToLruKeys.put(leastFreq,keys);

    Node node = keyToValNFrq.getOrDefault(key,new Node());
    node.setFreq(1);
    node.setVal(value);
    keyToValNFrq.put(key,node);
  }
}

