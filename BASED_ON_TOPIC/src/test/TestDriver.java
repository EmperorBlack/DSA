package test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestDriver {

  public static void main(String[] args) {


    Map<String, Set<String>> map = new HashMap<>();

    map.put("a", new HashSet<>());

    Set<String> set = map.get("a");
    set.add("d");

    System.out.println(map);

  }
}
