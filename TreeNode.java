package amazonPrep;

import java.util.ArrayList;


//find minimum difference between the nodes of a binary tree
//use inorder traversal

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
class Solution {

    ArrayList<Integer> al = new ArrayList<>();

    public void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            al.add(root.val);
            inorder(root.right);
        }
    }

    public int findMinDif(TreeNode root){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<al.size()-1;i++){
            int x = al.get(i+1)-al.get(i);

            if(min>x) min=x;
        }
        return min;
    }

}