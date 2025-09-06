package linkedList.doubleLL;

public class DoubleLLDriver {

  public static void main(String[] args) {
//    System.out.println(new Solution().constructDLL(new int[]{1,2,3,4,5}));
    Node root = new Node(2);
    Node node1 = new Node(4);
    Node node2 = new Node(5);

    root.next = node1;node1.prev = root;
    node1.next = node2; node2.prev = node1;

    System.out.println(new Solution_2().addNode(root,2,6));

  }
}

class Node {
  int data;
  Node next;
  Node prev;

  Node(int x) {
    data = x;
    next = null;
    prev = null;
  }
}

class Solution {
  Node constructDLL(int arr[]) {
    // Code here
    if(arr == null){
      return null;
    }
    Node root = new Node(arr[0]);
    Node current = root;
    for(int i=1 ;i<arr.length; i++){

      Node nextNode = new Node(i);

      current.next = nextNode;
      nextNode.prev = current;
      current = current.next;

    }
    return root;

  }
}

class Solution_2 {
  // Function to insert a new node at given position in doubly linked list.
  Node addNode(Node head, int p, int x) {
    // Your code here

    Node root = head;

    for(int i =0; i<p;i++){


      head = head.next;


    }

    Node next = head.next;
    Node newNode = new Node(x);

    if(next != null){

      next.prev = newNode;
      newNode.next = next;
    }

    newNode.prev = head;
    head.next = newNode;
    return root;

  }
}


