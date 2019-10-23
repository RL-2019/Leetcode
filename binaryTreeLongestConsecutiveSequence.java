//Leetcode 298 Binary Tree Longest Consecutive Sequence    (M)  (Tree)
//solution 1 - recursive
class Solution {
    int res = 0;
    
    public int longestConsecutive(TreeNode root) {
        if(root == null)return 0;
        dfs(root,root.val,0);
        return res;
        
    }
    public void dfs(TreeNode node,int v,int out){
        if(node == null)return;
        if(node.val == v+1)out++;
        else out = 1;
        res = Math.max(res,out);
        dfs(node.left,node.val,out);
        dfs(node.right,node.val,out);
    }
}

//solution 2 - recursive
class Solution {
    int res = 0;
    public int longestConsecutive(TreeNode root) {
        if(root == null)return 0;
        dfs(root, 1);
        return res;
    }
    public void dfs(TreeNode node,int len){
        res = Math.max(res,len);
        if(node.left!=null){
            if(node.left.val == node.val+1){
                dfs(node.left,len+1);
            }else{
                dfs(node.left,1);
            }

        }
        if(node.right!=null){
            if(node.right.val == node.val+1){
                dfs(node.right,len+1);
            }else{
                dfs(node.right,1);
            }            
        }
    }
}

//solution 3 - iterator

class Solution {
    public int longestConsecutive(TreeNode root) {
        int res = 0;
        if(root == null)return 0;
        Queue<TreeNode> q = new LinkedList<TreeNode> ();
        q.add(root);
        while(!q.isEmpty()){
            int len = 1;
            TreeNode node = q.poll();
            while((node.left != null && node.left.val == node.val+1) || (node.right != null && node.right.val == node.val+1)){
                if(node.left != null && node.left.val == node.val+1){
                    if(node.right != null)q.add(node.right);
                    node = node.left;
                }else if(node.right != null && node.right.val == node.val+1){
                    if(node.left != null)q.add(node.left);
                    node = node.right;
                }
                len++;
            }
            if(node.left != null)q.add(node.left);
            if(node.right != null)q.add(node.right);
            res = Math.max(res,len);
        }
        return res;

    }
}
