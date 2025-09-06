package math.primeFactors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrimeFactors {

  public static void main(String[] args) {

    System.out.println(Arrays.toString(new Solution_2().AllPrimeFactors(49)));
  }
}

//the number which devide N and at the same time it should be prime.
//any multiple of one factor will not devide it further
//we removes prime it will be devide by only prime

class Solution
{
  public int[] AllPrimeFactors(int N)
  {

    List<Integer> list = new ArrayList<>();
    for (int i = 2; i <= Math.sqrt(N); i++) {

      if(N%i == 0){
        list.add(i);
      }
      while (N % i == 0){
        N = N/i;
      }
    }
    if(N > 1){
      list.add(N);
    }
    return list.stream().mapToInt(a->a).toArray();

  }
}

class Solution_2
{
  public int[] AllPrimeFactors(int N)
  {

    List<Integer> list = new ArrayList<>();
    int curr = 2;
    while (curr <= Math.sqrt(N)){


      if(N%curr == 0){
        list.add(curr);
      }
      while (N%curr == 0){
        N = N/curr;
      }


      if(curr == 2){
        curr = curr+1;
      }else{
        curr = curr+2;
      }
    }
    if(N > 1){
      list.add(N);
    }
    return list.stream().mapToInt(a->a).toArray();

  }
}



