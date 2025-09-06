package stackQueue.lruCache;

import java.util.HashMap;
import java.util.Map;

public class LruDriver {

  public static void main(String[] args) {

    LRUCache cache = new LRUCache(2);
//    while (true){
//
//      Scanner sc = new Scanner(System.in);
//      System.out.println("wants to put -0 or get -1");
//      int op = sc.nextInt();
//      if(op == 0){
//        System.out.println("enter key value separated new line");
//        int key = sc.nextInt();
//        int val = sc.nextInt();
//        cache.put(key,val);
//      }else{
//        System.out.println("enter key");
//        int key = sc.nextInt();
//        System.out.println("value for entered key = " + cache.get(key));
//      }
//
//      sc.nextLine();
//      System.out.println("Do you want to exit, yes or no");
//      if(sc.nextLine().equals("yes")){
//        break;
//      }
//
//    }

    cache.put(1,1);
    cache.put(2,2);
    System.out.println(cache.get(1));
    cache.put(3,3);
    System.out.println(cache.get(2));
  }
}

class Node{

  Node next;
  Node prev;
  int val;
  int key;

  public Node(int key, int val) {
    this.key = key;
    this.val = val;
  }
}

class LRUCache {

  int capacity;
  int size = 0;
  Node rear = new Node(-1,-1);
  Node front = new Node(-1,-1);
  Map<Integer,Node> map = new HashMap<>();

  public LRUCache(int capacity) {

    this.capacity = capacity;
    front.next = rear;
    rear.prev = rear;

  }

  public int get(int key) {

    if(!map.containsKey(key)){
      return -1;
    }
    Node node = map.get(key);
    removeNode(node);
    addNode(node);
    return node.val;
  }

  public void put(int key, int value) {

    if(map.containsKey(key)){
      Node node = map.get(key);
      node.val = value;
      map.put(key,node);
      removeNode(node);
      addNode(node);
    }else{
      if(size == capacity){
        Node tail = getTail();
        removeNode(tail);
        map.remove(tail.key);
        size--;
      }
      Node node = new Node(key,value);
      addNode(node);
      map.put(key,node);
      size++;
    }


  }

  public Node getTail(){
    return rear.prev;
  }

  public void removeNode(Node node){
    node.next.prev = node.prev;
    node.prev.next = node.next;

  }

  public void addNode(Node node){

    front.next.prev = node;
    node.next = front.next;
    front.next = node;
    node.prev = front;
  }
}
