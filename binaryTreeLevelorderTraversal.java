//Leetcode 102 Binary Tree Level Order Traversal
//
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root==null)return res;
        q.add(root);
        while(!q.isEmpty()){
            ArrayList<Integer> oneLevel = new ArrayList<Integer>();
            for(int i = q.size();i>0;i--){
                TreeNode t = q.poll();
                oneLevel.add(t.val);
                if(t.left!=null)q.add(t.left);
                if(t.right!=null)q.add(t.right);
            }
            res.add(oneLevel);
        }   
        return res;
    }
}
