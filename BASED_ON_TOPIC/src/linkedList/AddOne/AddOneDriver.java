package linkedList.AddOne;

public class AddOneDriver {

  public static void main(String[] args) {

    Node root = new Node(4,new Node(5,new Node(6)));
    System.out.println(new Solution().addOne(root));
  }
}

class Node{
  int data;
  Node next;

  Node(int x){
    data = x;
    next = null;
  }

  Node(int x,Node next){
    data = x;
    this.next = next;
  }

}

class Solution {
  public Node addOne(Node head) {
    // code here.

    Node root = reverse(head);
    Node current = root;
    Node pre = null;
    int carry = 1;

    while(current!= null){
      int digit = (current.data + carry)%10;
      carry = (current.data + carry)/10;
      current.data = digit;
      pre = current;
      current = current.next;
    }

    if(carry != 0){
      pre.next = new Node(carry);
    }
    return reverse(root);

  }

  public Node reverse(Node head){

    Node pre = null;
    while(head != null){
      Node temp = head.next;
      head.next = pre;
      pre = head;
      head = temp;
    }
    return pre;
  }
}

