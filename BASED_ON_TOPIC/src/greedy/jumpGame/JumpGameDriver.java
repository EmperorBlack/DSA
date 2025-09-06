package greedy.jumpGame;

public class JumpGameDriver {

  public static void main(String[] args) {
    System.out.println(new Solution().jump(new int[]{2,3,1,1,4}));
  }
}


class Solution {
  public boolean canJump(int[] nums) {

    int reachable =0;
    for (int i = 0; i < nums.length; i++) {

      if(reachable < i){
        return false;
      }
      reachable = Math.max(reachable,i+nums[i]);
      if(reachable >= nums.length-1){
        return true;
      }

    }
    return true;
  }

  public int jump(int[] nums) {
    int nextReachable =0;
    int currRange =0;
    int count =0;
    for (int i = 0; i < nums.length-1; i++) {

      if(nextReachable < i+nums[i]){
        nextReachable = i+nums[i];
      }

      if(i >= currRange){
        count++;
        currRange = nextReachable;
//        if(currRange >= nums.length-1){
//          return count;
//        }
      }
    }
    return count;
  }
}