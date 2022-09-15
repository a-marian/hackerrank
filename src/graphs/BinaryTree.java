package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTree {
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stacky = new Stack<>();

        TreeNode current = root;

        while(current != null || !stacky.isEmpty()){
            while(current != null){
                stacky.push(current);
                current = current.left;
            }

            current = stacky.pop();
            result.add(current.val);
            current = current.right;
        }
        return result;
    }

    List<Integer> resultPreOrderTraversal = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {

        if (root != null){
            resultPreOrderTraversal.add(root.val);
            preorderTraversal(root.left);
            preorderTraversal(root.right);

        }
        return resultPreOrderTraversal;
    }

    List<Integer> resultPostOrderTraversal = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {

        if(root != null){
            postorderTraversal(root.left);
            postorderTraversal(root.right);
            resultPostOrderTraversal.add(root.val);
        }
        return resultPostOrderTraversal;
    }
}
