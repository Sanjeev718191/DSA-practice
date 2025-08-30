public class leetcode297 {
    // link - https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
}

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "X";
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val+","+left+","+right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        return deserialize(nodes);
    }
    private TreeNode deserialize(Queue<String> nodes) {
        String s = nodes.poll();
        if(s.equals("X")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = deserialize(nodes);
        root.right = deserialize(nodes);
        return root;
    }
}