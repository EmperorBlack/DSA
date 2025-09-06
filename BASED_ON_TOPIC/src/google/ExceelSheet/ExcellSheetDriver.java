package google.ExceelSheet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ExcellSheetDriver {

  public static void main(String[] args) {
    System.out.println(new Solution().convertToTitle(1));
  }
}


class Solution {
  public String convertToTitle(int columnNumber) {
    StringBuilder sb = new StringBuilder();
    while(columnNumber > 0){
      columnNumber = columnNumber-1;
      sb.insert(0,(char)('A'+columnNumber %26));
      columnNumber = columnNumber /26;
    }

    List<Integer> list = new ArrayList<>();

    int[] ll = new int[3];
//    Set<Integer> set = Stream.of(ll).collect(Collectors.toSet());
//    Set<Integer> set = new HashSet<>(Arrays.asList(ll));
   int[] l =  list.stream().mapToInt(i->i).toArray();

    return sb.toString();



  }
}