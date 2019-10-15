//Leetcode 113 Path Sun II    Medium  Tree
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
       List<List<Integer>> res = new ArrayList<List<Integer>>();
       if(root == null)return res;
        ArrayList<Integer> out = new ArrayList<Integer>();
        helper(root, sum, out, res);
        return res;
        
    }
    public void helper(TreeNode node, int sum, ArrayList<Integer> out, List<List<Integer>> res){
        if(node==null) return;
        out.add(node.val);
        if(node.left == null & node.right == null & node.val == sum){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.addAll(out);
            res.add(temp);
        }
        helper(node.left,sum-node.val,out, res);
        helper(node.right,sum-node.val,out,res);
        out.remove(out.size()-1);
            
    }
}

//solution 2 - non-recursive
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<TreeNode> s = new ArrayList<TreeNode>();
        TreeNode cur = root, pre = null;
        int val = 0;
        while(cur!= null || !s.isEmpty()){
            while(cur!=null){
                s.add(cur);
                val += cur.val;
                cur = cur.left;
                
            }
            cur = s.get(s.size()-1);
            if(cur.left == null && cur.right == null && val == sum ){
                ArrayList<Integer> temp = new ArrayList<Integer>();
                for(TreeNode t: s){
                    temp.add(t.val);
                }
                res.add(temp);
            }
            if(cur.right!=null && cur.right != pre){
                cur = cur.right;
            }
            else{
                pre = cur;
                val -= cur.val;
                s.remove(cur);
                cur = null;
            }
        }
        return res;
        
    }
}

