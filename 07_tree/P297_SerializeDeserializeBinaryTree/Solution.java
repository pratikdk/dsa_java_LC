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

public class Codec {
    private static final String NN = "X";
    private static final String SPLITTER = ",";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfsPreorder(root, sb);
        return sb.toString();
    }

    private void dfsPreorder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append(NN).append(SPLITTER);
            return;
        }
        sb.append(node.val).append(SPLITTER);
        dfsPreorder(node.left, sb);
        dfsPreorder(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> nodeQ = new LinkedList<>();
        nodeQ.addAll(Arrays.asList(data.split(SPLITTER)));
        TreeNode root = dfsBuildTree(nodeQ);
        return root;
    }

    private TreeNode dfsBuildTree(Deque<String> nodes) {
        String val = nodes.remove();
        if (val.equals(NN)) return null;
        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = dfsBuildTree(nodes);
        node.right = dfsBuildTree(nodes);
        return node;
    }
}
