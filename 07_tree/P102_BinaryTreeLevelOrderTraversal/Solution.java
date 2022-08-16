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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfsLevel(root, res, 0);
        return res;
    }

    public void dfsLevel(TreeNode node, List<List<Integer>> res, int level) {
        if (node == null) return;

        if (level == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(node.val);

        dfsLevel(node.left, res, level+1);
        dfsLevel(node.right, res, level+1);
    }

//     public List<List<Integer>> levelOrder2(TreeNode root) {
//         List<List<Integer>> res = new ArrayList<>();
//         if (root == null) return res;

//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);

//         while (!queue.isEmpty()) {
//             List<Integer> tmp = new ArrayList<>();
//             int qSize = queue.size();
//             for (int i = 0; i < qSize; i++) {
//                 if (queue.peek().left != null) queue.add(queue.peek().left);
//                 if (queue.peek().right != null) queue.add(queue.peek().right);
//                 tmp.add(queue.poll().val);
//             }
//             res.add(tmp);
//         }

//         return res;
//      }
}
