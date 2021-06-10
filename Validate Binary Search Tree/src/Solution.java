
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
    boolean isValidBST(TreeNode node) {
        return helper(node, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    boolean helper(TreeNode node, long max, long min) {
        if (node == null) return true;
        if (node.val >= max || node.val <= min) return false;
        return helper(node.left, node.val, min) && helper(node.right, max, node.val);
    }
}