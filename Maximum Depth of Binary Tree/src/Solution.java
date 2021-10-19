import java.util.ArrayList;
import java.util.List;

class TreeNode {
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
    public int maxDepth(TreeNode root) {
        int ans = 0;
        if (root == null) {
            return ans;
        }

        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> tmp = new ArrayList<>();
            ans += 1;
            while (!queue.isEmpty()) {
                TreeNode curr = queue.get(0);
                if (curr.left != null) tmp.add(curr.left);
                if (curr.right != null) tmp.add(curr.right);
                queue.remove(0);
            }
            queue.addAll(tmp);
        }
        return ans;
    }
}