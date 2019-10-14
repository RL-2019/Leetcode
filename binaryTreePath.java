//Leetcode 257 Binary Tree Paths   Easy   Tree
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
    public static List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> res = new ArrayList<String>();
        if(root!=null)helper(root,"",res);
        return res;
        
    }
    public static void helper(TreeNode node,String out, ArrayList<String> res){
        if(node.left == null && node.right == null){
            res.add(out+Integer.toString(node.val));
            }
        if(node.left != null){
            helper(node.left,out+Integer.toString(node.val)+"->",res);
        }
        if(node.right != null){
            helper(node.right,out+Integer.toString(node.val)+"->",res);
        }
    }
}
