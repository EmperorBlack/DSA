package linkedList.allOneDS;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOneDSDriver {

  public static void main(String[] args) {

    AllOne all = new AllOne();
    all.inc("hello");
    all.inc("hello");
    System.out.println(all.getMaxKey());
  }

}

class Node {
  Set<String> keys;
  int freq;
  Node next;
  Node prev;

  public Node(String key, int freq) {
    keys = new HashSet<>();
    keys.add(key);
    this.freq = freq;
  }
}

class AllOne {

  Map<String, Node> keyToNode = new HashMap<>();
  Node head = new Node("", -1);
  Node tail = new Node("", -1);

  public AllOne() {
    head.next = tail;
    tail.prev = head;
  }

  public void inc(String key) {
    if (!keyToNode.containsKey(key)) {
      if (head.next.freq == 1) {
        head.next.keys.add(key);
        keyToNode.put(key, head.next);
      } else {
        Node newNode = new Node(key, 1);
        insertAfter(head, newNode);
        keyToNode.put(key, newNode);
      }
    } else {
      Node curr = keyToNode.get(key);
      curr.keys.remove(key);
      Node next = curr.next;

      if (next.freq == curr.freq + 1) {
        next.keys.add(key);
        keyToNode.put(key, next);
      } else {
        Node newNode = new Node(key, curr.freq + 1);
        insertAfter(curr, newNode);
        keyToNode.put(key, newNode);
      }

      if (curr.keys.isEmpty()) {
        remove(curr);
      }
    }
  }

  public void dec(String key) {
    Node curr = keyToNode.get(key);
    curr.keys.remove(key);

    if (curr.freq == 1) {
      keyToNode.remove(key);
    } else {
      Node prev = curr.prev;
      if (prev.freq == curr.freq - 1) {
        prev.keys.add(key);
        keyToNode.put(key, prev);
      } else {
        Node newNode = new Node(key, curr.freq - 1);
        insertAfter(prev, newNode);
        keyToNode.put(key, newNode);
      }
    }

    if (curr.keys.isEmpty()) {
      remove(curr);
    }
  }

  public String getMaxKey() {
    return tail.prev.keys.iterator().next();
  }

  public String getMinKey() {
    return head.next.keys.iterator().next();
  }

  private void insertAfter(Node prev, Node node) {
    Node next = prev.next;
    prev.next = node;
    node.prev = prev;
    node.next = next;
    next.prev = node;
  }

  private void remove(Node node) {
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }
}












