package google.buildSegmentTree;

public class BuildSegmentTreeDriver {

}


class Solution{

  int[] segmentTree;
  int[] arr;

  Solution(int[] arr) {
    this.arr = arr;
    int n = arr.length;
    segmentTree = new int[2 * n];
    buildSegmentTree(arr, 0, 0, n-1);
  }

  private void buildSegmentTree(int[] arr, int index, int l, int r) {
    if(l == r){
      segmentTree[index] = arr[l];
      return;
    }
    if(l > r){
      return;
    }


    int mid = (l + r) / 2;
    buildSegmentTree(arr, 2*index +1, l, mid);
    buildSegmentTree(arr, 2*index +2, mid + 1, r);
    segmentTree[index] = segmentTree[2*index+1] + segmentTree[2*index+2];

  }

  private void updateTree(int index, int val){
    if(index < 0 || index >= arr.length){
      throw new IllegalArgumentException("Index out of bounds");
    }
    updateValue(index, val, 0, 0, arr.length - 1);
  }

  private void updateValue(int index, int val,int arrIndex, int l , int r){

    if(l == r){
      if(l == index){
        arr[l] = val;
        segmentTree[arrIndex] = val;
      }
    }


    int mid = (l+r)/2;
    if(index <= mid){
      updateValue(index, val, 2*arrIndex + 1, l, mid);
    }else{
      updateValue(index, val, 2*arrIndex + 2, mid+1, r);
    }
    segmentTree[arrIndex] = segmentTree[2*arrIndex + 1] + segmentTree[2*arrIndex + 2];
  }

  private int getSum(int left , int right){

    if(left < 0 || right >= arr.length || left > right){
      throw new IllegalArgumentException("Invalid range");
    }
    return getSum(0, left, right, 0, arr.length - 1);


  }

  private int getSum( int arrIndex, int left, int right, int l , int r){
//
    if(right < l || left > r){
      return 0;
    }
    if(left <= l && right >=r){
      return segmentTree[arrIndex];
    }

    int mid = (l + r) / 2;
    return getSum(2*arrIndex+1,left,right,l,mid) + getSum(2*arrIndex+2, left, right, mid+1,r);
  }


}