package stackQueue.queueUsingLL;

public class QueueUsingLLDriver {

  public static void main(String[] args) {

  }
}

class QueueNode
{
  int data;
  QueueNode next;
  QueueNode(int a)
  {
    data = a;
    next = null;
  }
}

class MyQueue
{
  QueueNode front, rear;

  //Function to push an element into the queue.
  void push(int a)
  {
    if(rear == null){
      rear = front = new QueueNode(a);
    }else{
      rear.next = new QueueNode(a);
      rear = rear.next;
    }
  }

  //Function to pop front element from the queue.
  int pop()
  {
    if(front == null){
      rear = null;
      return -1;
    }
    int data = front.data;;
    front=front.next;
    return data;
  }
}
