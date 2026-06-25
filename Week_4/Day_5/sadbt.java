public class Codec {

    // Serialize
    public String serialize(TreeNode root) {

        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    private void preorder(TreeNode root, StringBuilder sb) {

        if(root == null) {
            sb.append("N,");
            return;
        }

        sb.append(root.val).append(",");

        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    // Deserialize
    int index = 0;

    public TreeNode deserialize(String data) {

        String[] arr = data.split(",");
        index = 0;

        return build(arr);
    }

    private TreeNode build(String[] arr) {

        if(arr[index].equals("N")) {
            index++;
            return null;
        }

        TreeNode root =
                new TreeNode(Integer.parseInt(arr[index++]));

        root.left = build(arr);
        root.right = build(arr);

        return root;
    }
}