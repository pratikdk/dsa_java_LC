public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }
    
    public int dfsHeight(TreeNode root) { // dfsDepth
        if (root == null) return 0;
        
        int left = dfsHeight(root.left);
        if (left == -1) return -1; // early return
        int right = dfsHeight(root.right);
        if (right == -1) return -1; // early return
        
        if (Math.abs(left-right) > 1) return -1; // not balanced 
        
        return 1 + Math.max(left, right); // else return max depth/height at current node
    }
}
