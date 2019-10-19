//Leetcode 129  Sum Root to Leaf Numbers   (M)  Tree
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
//solution 1 - iterator
class Solution {
    public int sumNumbers(TreeNode root) {
        int res = 0;
        List<TreeNode> s = new ArrayList<TreeNode>();
        TreeNode cur = root,pre=null;
        while(cur!=null || !s.isEmpty()){
            while(cur!= null){
                s.add(cur);
                cur = cur.left;
            }
        
        cur = s.get(s.size()-1);
        if(cur.left == null && cur.right == null){
            int temp = 0;
            for(int i=0;i<s.size();i++){
                temp = temp*10+s.get(i).val;
            }
            res += temp;
        }
        if(cur.right != null && cur.right != pre){
            cur = cur.right;
        }else{
            pre = cur;
            s.remove(cur);
            cur = null;
        }
        
       } 
        return res;
        
    }
}

//solution 2 - iterator
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
    public int sumNumbers(TreeNode root) {
        int res = 0;
        if(root == null)return 0;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        while(!s.isEmpty()){
            TreeNode t = s.pop();
            if(t.left == null && t.right == null){
                res += t.val;
            }
            if(t.right!= null){
                t.right.val += 10*t.val;
                s.push(t.right);
            }
            if(t.left!= null){
                t.left.val += 10*t.val;
                s.push(t.left);
            }
            
        }
       return res; 
    }
}

//solution 3 - recursive
class Solution {
    public int sumNumbers(TreeNode root) {
        return sumNumbersDFS(root,0);
        
    }
    public int sumNumbersDFS(TreeNode node, int sum){
        if(node == null)return 0;
        sum = sum*10+ node.val;
        if(node.left == null & node.right == null)return sum;
        return sumNumbersDFS(node.left,sum)+sumNumbersDFS(node.right,sum);
        
    }
}
