package array.minimizeMaximumDistanceGasStation;

import java.util.PriorityQueue;

public class GasStationDriver {

  public static void main(String[] args) {

    System.out.println(Solution_2.MinimiseMaxDistance(new int[]{1, 2, 3, 4, 5, 6, 7}, 6));
  }

}


//Brute approach
class Solution {

  public static double MinimiseMaxDistance(int[] arr, int K) {

    int[] howMany = new int[arr.length - 1];

    for (int i = 0; i < K; i++) {

      double maxValue = 0;
      int maxIndex = -1;

      for (int j = 0; j < arr.length - 1; j++) {

        double diff = arr[j + 1] - arr[j];
        double sectionLen = diff / (howMany[j] + 1);
        if (sectionLen > maxValue) {
          maxValue = sectionLen;
          maxIndex = j;
        }
      }
      howMany[maxIndex]++;
    }

    double maxValue = 0;
    for (int j = 0; j < arr.length - 1; j++) {

      double diff = arr[j + 1] - arr[j];
      double sectionLen = diff / (howMany[j] + 1);
      if (sectionLen > maxValue) {
        maxValue = sectionLen;
      }
    }

    return maxValue;


  }
}

//this solution is enough
class Solution_2 {

  static class Pair{
    int index;
    double distance;
    int value;

    public Pair(int index, double distance, int value) {
      this.index = index;
      this.distance = distance;
      this.value = value;
    }
  }
  public static double MinimiseMaxDistance(int[] arr, int K) {

    PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((p1,p2)-> Double.compare(p2.distance,p1.distance));

    for (int j = 0; j < arr.length - 1; j++) {

      double diff = arr[j + 1] - arr[j];
      priorityQueue.offer(new Pair(j,diff,1));
    }

    while (K >0){

      Pair p = priorityQueue.poll();
      p.distance = (double) (arr[p.index + 1] - arr[p.index]) /(p.value+1);
      priorityQueue.offer(new Pair(p.index, p.distance, p.value+1));
      K--;
    }

    return priorityQueue.peek().distance;

  }
}



//modified BS
class Solution_3{

  public static int numberOfGasStationsRequired(double dist, int[] arr) {
    int n = arr.length; // size of the array
    int cnt = 0;
    for (int i = 1; i < n; i++) {
      int numberInBetween = (int)((arr[i] - arr[i - 1]) / dist);
      if ((arr[i] - arr[i - 1]) == (dist * numberInBetween)) {
        numberInBetween--;
      }
      cnt += numberInBetween;
    }
    return cnt;
  }

  public static double MinimiseMaxDistance(int[] arr, int k) {
    int n = arr.length; // size of the array
    double low = 0;
    double high = 0;

    //Find the maximum distance:
    for (int i = 0; i < n - 1; i++) {
      high = Math.max(high, (double)(arr[i + 1] - arr[i]));
    }

    //Apply Binary search:
    double diff = 1e-6 ;
    while (high - low > diff) {
      double mid = (low + high) / (2.0);
      int cnt = numberOfGasStationsRequired(mid, arr);
      if (cnt > k) {
        low = mid;
      } else {
        high = mid;
      }
    }
    return high;
  }

}

