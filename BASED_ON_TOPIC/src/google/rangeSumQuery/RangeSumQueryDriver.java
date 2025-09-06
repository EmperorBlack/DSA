package google.rangeSumQuery;

public class RangeSumQueryDriver {

  public static void main(String[] args) {

  }
}


class Sol {


  // Function to update a value in input array and segment tree.
  static void updateValue(int arr[], long st[], int n, int index, int val) {
    updateValueRange(arr,st,index, val, 0, n-1, 0 );
  }

  private static void updateValueRange(int arr[], long st[], int index, int val, int start, int end, int stIndex){

    int mid = (start + end) / 2;

    if(start == end){
      arr[index] = val;
      st[stIndex] = val;
      return;
    }

    if(index <= mid){
      updateValueRange(arr,st,index, val, start, mid,2*stIndex + 1);
    }else{
      updateValueRange(arr,st,index,val,mid+1,end, 2*stIndex + 2);
    }
    st[stIndex] = st[2*stIndex + 1] + st[2*stIndex + 2];

  }

  // Function to return sum of elements in range from index qs (query start)
  // to qe (query end).
  public static long getSum(long st[], int n, int l, int r) {
    return getSumUtil(st, l, r, 0, n - 1, 0);
  }
  private static long getSumUtil(long st[], int l, int r, int start, int end, int index) {

    if(r < start || l > end){
      return  0;
    }
    if(start >= l && end <= r){
      return st[index];
    }

    int mid = (start+end)/2;

    return getSumUtil(st, l, r, start, mid,(index*2)+1)+
        getSumUtil(st, l, r, mid+1, end,(index*2)+2);
  }

}