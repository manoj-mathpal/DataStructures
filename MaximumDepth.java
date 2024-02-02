package DSA.binaryTree;

public class MaximumDepth {

      public static class TreeNode {
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

    static class Solution {
        int len = 0;

        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            int leftMax = maxDepth(root.left);
            int rightMax = maxDepth(root.right);
            return Math.max(leftMax, rightMax) + 1;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right= new TreeNode(20);
        root.right.left= new TreeNode(15);
        root.right.right= new TreeNode(17);
        System.out.println(new Solution().maxDepth(root));

    }
}
