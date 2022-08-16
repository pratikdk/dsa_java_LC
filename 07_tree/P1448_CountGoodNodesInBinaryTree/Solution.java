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
    public int goodNodes(TreeNode root) {
        int goodCount = dfsGood(root, Integer.MIN_VALUE);
        return goodCount;
    }

    public int dfsGood(TreeNode node, int max) {
        if (node == null) return 0;

        int left = dfsGood(node.left, Math.max(max, node.val));
        int right = dfsGood(node.right, Math.max(max, node.val));

        int res = left + right;
        res += (node.val >= max) ? 1 : 0;

        return res;
    }
}
