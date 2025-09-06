package BinaryTree.serialise;

public class SerialiseDriver {

  public static void main(String[] args) {

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.right.left = new TreeNode(4);
    root.right.right = new TreeNode(5);
    String code =  new Codec().serialize(root);
    TreeNode node = new Codec().deserialize(code);
  }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

class Codec {

  static int i =0;
  // Encodes a tree to a single string.
  public String serialize(TreeNode root) {

    StringBuilder sb = new StringBuilder();
    serde(root,sb);
    System.out.println(sb);
    return sb.toString();
  }

  private void serde(TreeNode root, StringBuilder sb){
    if(root == null){
      sb.append("#,");
      return ;
    }

    sb.append(root.val).append(",");
    serde(root.left,sb);
    serde(root.right,sb);

  }

  // Decodes your encoded data to tree.
  public TreeNode deserialize(String data) {

    String[] nodes = data.split(",");
    i =0;
    return deSerde(nodes);
  }

  private TreeNode deSerde(String[] nodes ){

    if(i >= nodes.length-1){
      return null;
    }

    if(nodes[i].equals("#")){
      i++;
      return null;
    }

    TreeNode root = new TreeNode(Integer.parseInt(nodes[i]));
    i++;
    root.left = deSerde(nodes);
    root.right= deSerde(nodes);
    return root;
  }


}

