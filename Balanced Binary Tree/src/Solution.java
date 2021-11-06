import java.util.HashSet;

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
    boolean ans = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        dfs(root, 0);
        return ans;
    }

    public int dfs(TreeNode node, int depth) {
        int dLeft = depth;
        int dRight = depth;
        if (node.left != null) {
            dLeft = Math.max(dfs(node.left, depth + 1), dLeft);
        }
        if (node.right != null) {
            dRight = Math.max(dfs(node.right, depth + 1), dRight);
        }
        if (Math.abs(dRight - dLeft) > 1) ans = false;
        return Math.max(dLeft, dRight);
    }
}