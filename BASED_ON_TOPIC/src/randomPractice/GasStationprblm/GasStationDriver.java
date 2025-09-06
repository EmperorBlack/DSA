package randomPractice.GasStationprblm;

public class GasStationDriver {

  public static void main(String[] args) {

  }
}

class Solution {
  public static double MinimiseMaxDistance(int []arr, int K){
    // Write your code here.

    int n = arr.length;
    double low =0;
    double high = 0;

    for (int i = 0; i < n-1; i++) {
      high = Math.max(high,arr[i+1]-arr[i]);
    }

    double diff = Math.pow(10,-6);
    while(high-low > diff){

      double mid = (low+high)/2.0;
      int cnt = numberOfGasStationRequired(mid,arr);
      if(cnt > K){
        low = mid;
      }else{
        high = mid;
      }

    }
    return high;
  }

  private static int numberOfGasStationRequired(double dist, int[] arr){

    int cnt = 0;
    for (int i = 1; i < arr.length; i++) {

      int numberInBet = (int)((arr[i]-arr[i-1])/dist);
      if((arr[i]-arr[i-1]) == numberInBet * dist){
        cnt--;
      }
        cnt += numberInBet;


    }
    return cnt;
  }

}
