//Leetcode 111 Minimum Depth of Binary Tree
//Solution 1 - recursive
//二叉树的经典问题之最小深度问题就是就最短路径的节点个数，还是用深度优先搜索DFS来完成，万能的递归啊。首先判空，若当前结点不存在，直接返回0。然后看若左子结点不存在，那么对右子结点调用递归函数，并加1返回。反之，若右子结点不存在，那么对左子结点调用递归函数，并加1返回。若左右子结点都存在，则分别对左右子结点调用递归函数，将二者中的较小值加1返回即可，参见代码如下：

class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)return 0;
        if(root.left == null) return 1+minDepth(root.right);
        if(root.right == null)return 1+minDepth(root.left);
        return 1+Math.min(minDepth(root.left),minDepth(root.right));
        
    }

}

//solution 2 - iterator
//
//我们也可以是迭代来做，层序遍历，记录遍历的层数，一旦我们遍历到第一个叶结点，就将当前层数返回，即为二叉树的最小深度，参见代码如下：
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null)return 0;
        int res = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode> ();
        q.add(root);
        while(!q.isEmpty()){
            res++;
            for(int i = q.size();i>0;i--){
                TreeNode t = q.poll();
                if(t.left == null && t.right == null)return res;
                if(t.left != null)q.add(t.left);
                if(t.right != null)q.add(t.right);
            }
        }
        return -1;
        
    }
}
