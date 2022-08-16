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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfsRight(root, res, 0);
        return res;
    }
    
    public void dfsRight(TreeNode node, List<Integer> res, int level) {
        if (node == null) return;
        
        if (res.size() == level) {
            res.add(node.val);
        }
        
        dfsRight(node.right, res, level+1);
        dfsRight(node.left, res, level+1);
    }
}
