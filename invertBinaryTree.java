//Leetcode 226  Invert Binary Tree  Easy
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
//solution1 -- recursive
//

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
	TreeNode temp = root.left;
	root.left = invertTree(root.right);
	root.right = invertTree(temp); 
        return root;
        
    }
}

//solution2 -- Nonrecursive
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return null;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode t = q.poll();
            TreeNode temp;
            temp = t.left;
            t.left = t.right;
            t.right = temp;
            if(t.left!=null)q.add(t.left);
            if(t.right!=null)q.add(t.right);
        }
        return root;
        
    }
}
