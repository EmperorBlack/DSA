package array.kThPositiveNumber;

public class KthPositiveNumberDriver {

  public static void main(String[] args) {
    System.out.println(new Solution().findKthPositive(new int[]{2,3,4,7,11},5));
  }
}

class Solution {
  public int findKthPositive(int[] arr, int k) {

    return findHighBS(arr,0,arr.length-1,k)+k+1;

  }

  private int findHighBS(int arr[], int low, int high, int k){

    if(low>high){
      return high;
    }

    int mid = low +(high-low)/2;
    if(arr[mid]-(mid+1) < k){
      return findHighBS(arr,mid+1,high,k);
    }else{
      return findHighBS(arr,low,mid-1,k);
    }
  }
}
