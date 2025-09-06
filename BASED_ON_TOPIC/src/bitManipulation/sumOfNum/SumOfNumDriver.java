package bitManipulation.sumOfNum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class SumOfNumDriver {

  public static void main(String[] args) {

//    int[] to_delete = new int[]{};
//    Integer[] arr= new Integer[2];
//    arr[1] = -1;
//    Integer[] newArr = arr.clone();
//    newArr[1] =2;
//
//    System.out.println(Arrays.toString(newArr));
//    System.out.println(Arrays.toString(arr));

    SnapshotArray_2 snap = new SnapshotArray_2(1);
    snap.set(0,15);
    snap.snap();
    snap.snap();
    snap.snap();
    System.out.println(snap.get(0,2));
//    snap.set(2,4);
    snap.snap();
    snap.snap();
//    snap.set(1,4);
    System.out.println(snap.get(0,0));


  }
}


class Solution {
  public int getSum(int a, int b) {


    int carry = b, sum =0;
    while(carry!=0){

      sum = a^b;
      carry= (a^b) << 1;
      a=sum;
      b=carry;

    }
    return sum;

  }
}

class SnapshotArray {

  int snapIndex =0;
  Map<Integer, Integer[]> snapShots = new HashMap<>();
  Integer[] curr;

  public SnapshotArray(int length) {

    curr = new Integer[length];
  }

  public void set(int index, int val) {
    curr[index] = val;
  }

  public int snap() {

    snapShots.put(snapIndex,curr.clone());
    return snapIndex++;
  }

  public int get(int index, int snap_id) {

    if(snapShots.get(snap_id)[index] == null){
      return 0;
    }
    return snapShots.get(snap_id)[index];

  }
}

class Pair{
  int snapId;
  int value;

  public Pair(int snapId, int value) {
    this.snapId = snapId;
    this.value = value;
  }
}

class SnapshotArray_2 {

  int snapIndex =0;
  List<Pair>[] snapArray;

  public SnapshotArray_2(int length) {
    snapArray = new List[length];
    for (int i =0;i< length;i++){
      snapArray[i] = new ArrayList<>();
    }
  }

  public void set(int index, int val) {
    List<Pair> list = snapArray[index];
    if (!list.isEmpty() && list.get(list.size() - 1).snapId == snapIndex) {
      list.get(list.size() - 1).value = val; // overwrite last set in same snap
    } else {
      list.add(new Pair(snapIndex, val));
    }
  }

  public int snap() {
    return snapIndex++;
  }

  public int get(int index, int snap_id) {

    List<Pair> list = snapArray[index];

   int l =0;
   int r = list.size()-1;
   int res = 0;

   while (l<=r){
     int mid = l + (r-l)/2;
     Pair p = list.get(mid);
     if(p.snapId == snap_id){
       return p.value;
     } else if (p.snapId < snap_id) {
       l = mid+1;
       res = p.value;
     } else {
       r = mid-1;
     }
   }

   return res;

  }

}