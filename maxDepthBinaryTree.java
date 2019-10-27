//Leetcode 104 Maximum Depth of Binary Tree
//solution 1 - recursive
public class Solution {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : (1 + Math.max(maxDepth(root.left), maxDepth(root.right)));
    }
}


//solution 2 - Iterator
class Solution {
	public int maxDepth(TreeNode root) {
        if(root == null)return 0;
        int res = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            res++;
            for(int i = q.size();i>0;i--){
                TreeNode t = q.poll();
                if(t.left == null && t.right == null)continue;
                if(t.left != null)q.add(t.left);
                if(t.right != null)q.add(t.right);
            }
            
        }
        return res;
        
    }
}
