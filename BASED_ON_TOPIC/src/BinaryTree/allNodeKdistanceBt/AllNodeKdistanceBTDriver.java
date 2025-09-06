package BinaryTree.allNodeKdistanceBt;
import java.util.*;

public class AllNodeKdistanceBTDriver {

  public static void main(String[] args) {

    TreeNode root = new TreeNode(0);
    root.left = new TreeNode(1);
    root.left.left = new TreeNode(3);
    root.left.right = new TreeNode(2);

    System.out.println(new Solution().distanceK(root,root.left.right,1));
  }
}
class TreeNode {
       int val;
       TreeNode left;
       TreeNode right;
       TreeNode(int x) { val = x; }
}

class Solution {
  public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
    if(root == null || target ==null){
      return new ArrayList<>();
    }
    Map<Integer,TreeNode> parentMap = new HashMap<>();
    setParentMap(root,parentMap);


    Queue<TreeNode> queue = new ArrayDeque<>();
    Set<Integer> visited = new HashSet<>();
    queue.offer(target);
    visited.add(target.val);

    int dist =0;
    while (!queue.isEmpty() && dist<k){

      int size = queue.size();
      dist++;
      for (int i = 0; i < size; i++) {

        TreeNode temp = queue.poll();
        if(temp.left!=null && !visited.contains(temp.left.val)){
          queue.offer(temp.left);
          visited.add(temp.left.val);
        }

        if(temp.right!=null && !visited.contains(temp.right.val)){
          queue.offer(temp.right);
          visited.add(temp.right.val);
        }

        if(parentMap.containsKey(temp.val) && !visited.contains(parentMap.get(temp.val).val)){
          queue.offer(parentMap.get(temp.val));
          visited.add(parentMap.get(temp.val).val);
        }
      }
    }

    List<Integer> result = new ArrayList<>();
    while (!queue.isEmpty()){
      result.add(queue.poll().val);
    }
    return result;

  }

  private void setParentMap(TreeNode root,Map<Integer,TreeNode> parentMap){

    Queue<TreeNode> queue = new ArrayDeque<>();
    queue.offer(root);

    while (!queue.isEmpty()){
      TreeNode temp = queue.poll();
      if(temp.left!=null){
        parentMap.put(temp.left.val, temp);
        queue.offer(temp.left);
      }
      if(temp.right!=null){
        parentMap.put(temp.right.val, temp);
        queue.offer(temp.right);
      }
    }
  }

}