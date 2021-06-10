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
    List<Integer> ans = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return ans;
        }
        helper(root);
        return ans;
    }
    public void helper(TreeNode node) {
        if (node.left != null) {
            helper(node.left);
        }
        ans.add(node.val);
        if (node.right != null) {
            helper(node.right);
        }
    }
}