//Leetcode 101 Symmetric Tree   Easy   Tree
//
//solution 1 - recursive
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        else return isSymmetric(root.left,root.right);
        
    }
    public boolean isSymmetric(TreeNode left, TreeNode right){
        if(left==null && right ==null)return true;
        if((left==null&&right!=null)||(left!=null &&right == null)||(left.val!= right.val))return false;
        return isSymmetric(left.left,right.right) && isSymmetric(left.right,right.left);
    }
}

//solution 2 - iterater

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.add(root.left);
        q2.add(root.right);
        while(!q1.isEmpty() && !q2.isEmpty()){
            TreeNode t1 = q1.poll();
            TreeNode t2 = q2.poll();
            if((t1 == null)&&(t2==null))continue;
            if((t1==null && t2!= null) || (t1!=null && t2==null))return false;
            if(t1.val != t2.val)return false;
            q1.add(t1.left);
            q1.add(t1.right);
            q2.add(t2.right);
            q2.add(t2.left);
        }
        return true;
    }
}
