package array.AllocateBooks;

import java.util.ArrayList;
import java.util.Arrays;

public class AllocateBooksDriver {

  public static void main(String[] args) {

    System.out.println(Solution.findPages( new ArrayList<>(Arrays.asList(12,34,67,90)),4,2));
  }
}
class Solution {
  public static int findPages(ArrayList<Integer> arr, int n, int m) {
    // Write your code here.

    if(n < m ){
      return -1;
    }
    int pages =0;
    int max = 0;
    for (int a : arr){
      pages += a;
      max = Math.max(max,a);
    }


    return findPagesBS(arr,m,max,pages);

  }

  private  static int findPagesBS(ArrayList<Integer> arr, int student, int i, int j){

    if(i > j){
      return i;
    }

    int mid = i + (j-i)/2;
    if(canDistribute(arr,mid) <= student){
      return findPagesBS(arr, student,i, mid-1);
    } else{
      return findPagesBS(arr, student, mid+1,j);
    }

  }

  private static int canDistribute(ArrayList<Integer> arr, int pages){

    int currentPages = 0;
    int studentCnt =1;
    for (int i = 0; i < arr.size(); i++) {

      if(currentPages + arr.get(i) <= pages){

        currentPages += arr.get(i);

      }else{
        studentCnt++;
        currentPages = arr.get(i);
      }

    }

    return studentCnt;


  }


}