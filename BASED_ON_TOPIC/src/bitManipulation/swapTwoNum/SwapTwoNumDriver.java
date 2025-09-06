package bitManipulation.swapTwoNum;

import java.util.Arrays;
import java.util.List;

public class SwapTwoNumDriver {

}
class Solution{
  static List<Integer> get(int a,int b)
  {
    // code here

    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
    return Arrays.asList(a,b);

  }
}