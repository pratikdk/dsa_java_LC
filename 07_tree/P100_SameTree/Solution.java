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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false; // either one of them is not null
        
        if (p.val != q.val) return false;
        
        boolean left = isSameTree(p.left, q.left);
        if (left == false) return false;
        boolean right = isSameTree(p.right, q.right);
        if (right == false) return false;
        
        return true; // values are equal, left & right are true, hence return true
    }
}
