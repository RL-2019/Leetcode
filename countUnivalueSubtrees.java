//Leetcode 250 Count Univalue Subtrees
//
class Solution {
    int res = 0;
    public int countUnivalSubtrees(TreeNode root) {
        if(root == null)return 0;
        if(isUnival(root,root.val))++res;
        countUnivalSubtrees(root.left);
        countUnivalSubtrees(root.right);
        return res;
        
    }
    public boolean isUnival(TreeNode root, int val){
        if(root == null)return true;
        return root.val == val && isUnival(root.left,val) && isUnival(root.right,val);
    }        
    
}


//solution 2 recursive
//
class Solution {
	public int countUnivalSubtrees(TreeNode root) {
		HashSet<TreeNode> res = new HashSet<TreeNode>();
		if (root == null)
			return 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);

		TreeNode head = root;
		while (!stack.empty()) {
			TreeNode t = stack.peek();
			if ((t.left == null && t.right == null) || (t.left == head) || (t.right == head)) {
				if (t.left == null && t.right == null) {
					res.add(t);
				} else if ((t.left == null) && res.contains(t.right) && t.val == t.right.val) {
					res.add(t);
				} else if ((t.right == null) && res.contains(t.left) && t.val == t.left.val) {
					res.add(t);
				} else if ((t.left != null) && (t.right != null) && (res.contains(t.left)) && (res.contains(t.right))
						&& t.val == t.left.val && t.val == t.right.val) {
					res.add(t);
				}
				stack.pop();
				head = t;
			} else {
				if (t.right != null)
					stack.push(t.right);
				if (t.left != null)
					stack.push(t.left);
			}
		}
		return res.size();

	}
}
