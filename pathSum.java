//Leetcode 112 Path Sum   Easy    Tree
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
    public static boolean hasPathSum(TreeNode root, int sum) {
        HashSet<Integer> set = new HashSet<Integer>();
        if(root!=null)helper(root,0,set);
        if(set.contains(sum))return true;
        else return false;
        
    }
    public static void helper(TreeNode node, int out, HashSet res){
        if(node.left == null && node.right == null){
            res.add(out+node.val);
        }
        
        if(node.left!= null){
            helper(node.left,out+node.val,res);
        }
        
        if(node.right!=null){
            helper(node.right, out+node.val,res);
        }
    }
}

//solution 2   - recursive
//
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)return false;
        if(root.left==null && root.right==null && root.val == sum)return true;
        return hasPathSum(root.left,sum-root.val) || hasPathSum(root.right,sum-root.val);
        
    }
}

//solution 3  -- Non-recursive
//
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)return false;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode t = s.pop();
            if(t.left == null && t.right == null && t.val == sum)return true;
            if(t.right != null){
                t.right.val += t.val;
                s.push(t.right);
            }
            if(t.left != null){
                t.left.val += t.val;
                s.push(t.left);
            }
        }
        return false;
    }
}

