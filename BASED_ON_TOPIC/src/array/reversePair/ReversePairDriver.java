package array.reversePair;

public class ReversePairDriver {

  public static void main(String[] args) {

    System.out.println( new Solution().reversePairs(new int[]{2,4,3,5,1}));

  }
}

class Solution {
  static int inVerCount =0;
  public int reversePairs(int[] nums) {
    inVerCount = 0;
    mergeSort(nums,0, nums.length-1);
    return inVerCount;

  }


   void mergeSort(int arr[], int i, int j){


    if(i < j){
      int mid = i + (j-i)/2;
      mergeSort(arr, i,mid);
      mergeSort(arr,mid+1,j);
      merge(arr,i,j,mid);
    }

  }

   void merge(int arr[], int i, int j, int k){

    int[] arr1 = new int[(k-i)+1];
    int[] arr2 = new int[j-k];

    for (int l = 0; l < arr1.length; l++) {
      arr1[l] = arr[i+l];
    }

    for (int l = 0; l < arr2.length; l++) {
      arr2[l] = arr[k+l+1];
    }

    int q =0;
    int r =0;
    while (q < arr1.length && r < arr2.length){

      if(arr1[q] > (2L * arr2[r])){
        inVerCount = inVerCount + (arr1.length-q);
        r++;
      }else{
        q++;
      }


    }

    int m = 0;
    int n =0;
    int z = i;
    while (m<arr1.length && n<arr2.length){

      if(arr1[m] < arr2[n]){
        arr[z] = arr1[m++];
      }else{
        arr[z] = arr2[n++];
      }
      z++;
    }

    while (m<arr1.length){
      arr[z] = arr1[m++];
      z++;
    }

    while (n<arr2.length){
      arr[z] = arr2[n++];
      z++;
    }


  }
}
