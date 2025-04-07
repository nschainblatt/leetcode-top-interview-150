import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
	}
}

 class TreeNode {
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
 
class Solution {
    public int maxDepth(TreeNode root) {
      return maxDepth(root, 1);
    }

    private int maxDepth(TreeNode node, int current) {
      if (node == null) {
        return current - 1;
      }
      return Math.max(maxDepth(node.left, current + 1), maxDepth(node.right, current + 1));
    }
}
