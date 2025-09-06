package stackQueue.stackUsingLL;

public class StackUsingLLDriver {


}

 class StackNode {
     int data;
     StackNode next;
     StackNode(int a) {
         data = a;
         next = null;
     }
 }


class MyStack {

  StackNode top;



  // Function to push an integer into the stack.
  void push(int a) {
    if(top == null){
     top = new StackNode(a);
    }else{
      StackNode temp = new StackNode(a);
      temp.next = top;
      top = temp;
    }
  }

  // Function to remove an item from top of the stack.
  int pop() {
    if(top == null){
      return -1;
    }
    int data = top.data;
    top = top.next;
    return data;


  }


}
