package greedy.nMeeting;

import java.util.ArrayList;
import java.util.List;

public class NMettingDriver {

  public static void main(String[] args) {

  }
}

class Pair{
  int start;
  int end;

  public Pair(int start, int end) {
    this.start = start;
    this.end = end;
  }
}
class Solution {
  // Function to find the maximum number of meetings that can
  // be performed in a meeting room.
  public int maxMeetings(int start[], int end[]) {
    // add your code here
    List<Pair> list = new ArrayList<>();

    for (int i = 0; i < start.length; i++) {
      list.add(new Pair(start[i],end[i]));
    }

    list.sort((p1,p2)-> Integer.compare(p1.end, p2.end));

    Pair curr = new Pair(0,Integer.MIN_VALUE);
    int count =0;
    for (int i = 0; i < list.size(); i++) {

      Pair temp = list.get(i);
      if(temp.start > curr.end ){
        count++;
        curr = temp;
      }
    }
    return count;


  }
}
