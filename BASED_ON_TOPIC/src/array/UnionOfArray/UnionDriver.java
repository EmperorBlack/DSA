package array.UnionOfArray;

import java.util.ArrayList;

public class UnionDriver {

  public static void main(String[] args) {

    System.out.println(Solution.findUnion(new int[]{1,2,3,4,5},new int[]{1,2,3}));
  }
}


// a,b : the arrays
class Solution {
  // Function to return a list containing the union of the two arrays.
  public static ArrayList<Integer> findUnion(int a[], int b[]) {

    ArrayList<Integer> list = new ArrayList<>();
    int i =0;
    int j =0;

    while(i < a.length && j < b.length){

      if(a[i] < b[j]){
        list.add(a[i++]);
        while (i < a.length && a[i] == a[i-1]){
          i++;
        }
      } else if (a[i] > b[j]) {
        list.add(b[j++]);
        while (j < b.length && b[j] == b[j-1]){
          j++;
        }
      }else{
        list.add(a[i]);
        i++;
        j++;
        while (i < a.length && a[i] == a[i-1]){
          i++;
        }
        while (j < b.length && b[j] == b[j-1]){
          j++;
        }
      }
    }

    while (i < a.length){

      if(i!=0 && a[i]!=a[i-1]){
        list.add(a[i]);
      }
      i++;

    }

    while (j < b.length){

      if(j!=0 && b[j]!=b[j-1]){
        list.add(b[j]);
      }
      j++;

    }

    return list;
  }
}
