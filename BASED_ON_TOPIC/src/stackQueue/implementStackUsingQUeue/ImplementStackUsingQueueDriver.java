package stackQueue.implementStackUsingQUeue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ImplementStackUsingQueueDriver {

}

class MyStack {

  Queue<Integer> queue;
  public MyStack() {
    queue = new ArrayDeque<>();
  }

  public void push(int x) {
    queue.offer(x);
    for (int i = 0; i < queue.size()-1; i++) {
      queue.offer(queue.poll());
    }

  }

  public int pop() {
    return queue.poll();
  }

  public int top() {
    return queue.peek();
  }

  public boolean empty() {
      return queue.isEmpty();
  }
}

class MyQueue {


  Stack<Integer> stack = new Stack<>();
  Stack<Integer> revStack = new Stack<>();


  public MyQueue() {

  }

  public void push(int x) {
    stack.push(x);
  }

  public int pop() {

    if(revStack.isEmpty()){
      while (!stack.empty()){
        revStack.push(stack.pop());
      }
    }
    return revStack.pop();
  }

  public int peek() {
    if(revStack.isEmpty()){
      while (!stack.empty()){
        revStack.push(stack.pop());
      }
    }
    return revStack.peek();
  }

  public boolean empty() {
    return stack.empty() && revStack.empty();
  }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
