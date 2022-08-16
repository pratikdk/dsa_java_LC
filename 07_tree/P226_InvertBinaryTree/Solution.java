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

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }

    // public TreeNode invertTree(TreeNode root) {
    //     if (root == null) return null;
    //     TreeNode tmp = invertTree(root.right);
    //     root.right = invertTree(root.left);
    //     root.left = tmp;
    //     return root;
    // }
}

