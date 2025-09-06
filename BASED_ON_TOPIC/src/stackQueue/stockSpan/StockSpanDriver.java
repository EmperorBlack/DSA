package stackQueue.stockSpan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StockSpanDriver {

  public static void main(String[] args) {

    StockSpanner stock = new StockSpanner();
  Arrays.stream(new int[]{100,80,60,70,60,75,85}).forEach(item-> System.out.println(stock.next(item)));
  }
}

class StockSpanner {

  List<Integer> list = new ArrayList<>();
  List<Integer> pbe = new ArrayList<>();

  public StockSpanner() {

  }

  public int next(int price) {

    if(list.isEmpty()){
      list.add(price);
      pbe.add(-1);
    }else{
      int p = list.size()-1;
      while ( p >= 0 && list.get(p) <= price ){
        p = pbe.get(p);
      }
      list.add(price);
      pbe.add(p);
    }
    return (pbe.size()-1)-pbe.get(pbe.size()-1);

  }
}
