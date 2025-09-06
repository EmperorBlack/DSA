package array.countInversion;

import java.util.Arrays;

public class CountInversionDriver {

  public static void main(String[] args) {
    int[] arr = new int[]{10, 10, 10};
    int count = Solution.inversionCount(arr);
    System.out.println(Arrays.toString(arr));
    System.out.println(count);
  }

}


class Solution {
  // Function to count inversions in the array.
  static int inVerCount =0;
  static int inversionCount(int arr[]) {
    inVerCount = 0;
    mergeSort(arr,0, arr.length-1);
    return inVerCount;
  }


  static void mergeSort(int arr[], int i, int j){


    if(i < j){
      int mid = i + (j-i)/2;
      mergeSort(arr, i,mid);
      mergeSort(arr,mid+1,j);
      merge(arr,i,j,mid);
    }

  }

  static void merge(int arr[], int i, int j, int k){

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

      if(arr1[q] > arr2[r]){
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