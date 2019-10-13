//Leetcode 145 Binary Tree Postorder Traversal
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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(root==null){
            return res;
        }
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        TreeNode head = root;
        while(!s.empty()){
            TreeNode t = s.peek();
            if((t.left==null && t.right==null) || t.left == head||t.right==head){
                res.add(t.val);
                s.pop();
                head = t;
            }else{
                if(t.right!=null)s.push(t.right);
                if(t.left!=null)s.push(t.left);
            }
        }
        return res;
        
    }
}
