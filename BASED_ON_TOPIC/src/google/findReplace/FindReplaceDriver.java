package google.findReplace;

import java.util.Arrays;

public class FindReplaceDriver
{

  public static void main(String[] args) {

    System.out.println(new Solution().findReplaceString("abcd", new int[]{0,2}, new String[]{"a","cd"},new String[]{"eee", "ffff"}));
  }
}

class Tuple{

  int index;
  String source;
  String target;

  public Tuple(int index, String source, String target){
    this.index = index;
    this.source = source;
    this.target = target;
  }
}

class Solution {
  public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {

    Tuple[] tuples = new Tuple[indices.length];
    for(int i=0;i<indices.length;i++){
      tuples[i] = new Tuple(indices[i],sources[i],targets[i]);
    }

    Arrays.sort(tuples, (t1,t2)-> Integer.compare(t1.index,t2.index));

    return replace(new StringBuilder(s),tuples,0 ).toString();

  }

  private StringBuilder replace(StringBuilder sb , Tuple[] tuples, int index){

    if(index >= tuples.length){
      return sb;
    }

    Tuple t = tuples[index];
    StringBuilder sub = replace(sb,tuples, index+1);
    String subString = sub.substring(t.index, t.index+t.source.length());
    if(subString.equals(t.source)){
      sub.replace(t.index, t.index+t.source.length(),t.target);
    }
    return sub;
  }
}