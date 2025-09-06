package heap.isMinheap;

public class IsMeanHeapDriver {

  public static void main(String[] args) {

    System.out.println(new Solution().countSub(new long[]{90 ,15 ,10 ,7 ,12 ,2},6));
  }
}

class Solution {

  public boolean countSub(long arr[], long n)
  {

    for (int i = (int)((n/2)-1); i >=0 ; i--) {

      if(arr[i] < arr[(2*i)+1] || ((2*i)+2) < n && arr[i] < arr[(2*i)+2]){
        return false;
      }
    }
    return true;

  }
}