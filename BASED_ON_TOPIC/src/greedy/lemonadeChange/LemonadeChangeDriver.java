package greedy.lemonadeChange;

public class LemonadeChangeDriver {

}

class Solution {
  public boolean lemonadeChange(int[] bills) {

    int fives = 0;
    int tens = 0;

    for (int i = 0; i < bills.length; i++) {

      if(bills[i] == 5){
        fives++;
      } else if (bills[i] == 10) {

        if(fives > 0){
          fives--;
          tens++;
        }else{
          return false;
        }

      }else {

        if(fives > 0 && tens > 0){
          fives--;
          tens--;
        } else if (fives >= 3) {
          fives = fives-3;
        }else{
          return false;
        }

      }


    }
    return true;

  }
}
