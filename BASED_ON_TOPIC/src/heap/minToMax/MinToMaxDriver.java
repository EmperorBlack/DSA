package heap.minToMax;

public class MinToMaxDriver {

  public static void main(String[] args) {

  }
}


class Solution {
  static void convertMinToMaxHeap(int N, int arr[]) {
    // code here

    int nonLeaf = (N/2)-1;
    for (int i = nonLeaf; i >=0 ; i--) {
      maxHeapify(i,arr);
    }


  }

  public static void maxHeapify(int root, int[] arr){

    int l = (2*root)+1;
    int r = (2*root)+2;

    int big = root;

    if(l < arr.length && arr[l] > arr[big] ){
      big = l;
    }

    if(r < arr.length && arr[r] > arr[big] ){
      big = r;
    }

    if(big!=root){
      int temp = arr[root];
      arr[root] = arr[big];
      arr[big] = temp;
      maxHeapify(big,arr);
    }



  }
}


