package greedy.pageFault;

import java.util.LinkedHashSet;

public class PageFaultDriver {

  public static void main(String[] args) {

    System.out.println(Solution.pageFaults(9,4,new int[]{5 ,0 ,1 ,3 ,2 ,4, 1 ,0 ,5}));
  }
}


class Solution{
  static int pageFaults(int N, int C, int pages[]){
    // code here

    int count = 0;
    LinkedHashSet<Integer> set = new LinkedHashSet<>();

    for (int i = 0; i < pages.length; i++) {

      if(!set.contains(pages[i])){
        set.add(pages[i]);
        count++;

        if(set.size() > C){
          Integer obj = set.iterator().next();
          set.remove(obj);
        }
      }else{
        set.remove(pages[i]);
        set.add(pages[i]);
      }

    }
    return count;

  }
}