//Leetcode 100  Same Tree
//
//solution 1
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null &&q==null)return true;
        if((p==null&&q!=null)||(p!=null&&q==null)||(p.val!=q.val))return false;
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        
    }
}

//solution 2

class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        if(p == null &&q==null)return true;
        if((p== null && q!=null)||(p!=null &&q==null))return false;
        s1.push(p);s2.push(q);
        while(!s1.empty() && !s2.empty()){
            TreeNode t1 = s1.peek(); s1.pop();
            TreeNode t2 = s2.peek();s2.pop();
            if(t1.val!=t2.val)return false;
            if(t1.left!=null)s1.push(t1.left);
            if(t2.left!=null)s2.push(t2.left);
            if(s1.size()!=s2.size())return false;
            if(t1.right!=null)s1.push(t1.right);
            if(t2.right!=null)s2.push(t2.right);
            if(s1.size()!=s2.size())return false;
        }
        return s1.size()==s2.size();
        }
}

