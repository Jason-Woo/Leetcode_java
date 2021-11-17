import java.util.ArrayList;
import java.util.List;



class Solution {

    List<List<Integer>> ans;

    public List<List<Integer>> findLeaves(TreeNode root) {
        TreeNode dummy = new TreeNode();
        dummy.left = root;
        ans = new ArrayList<>();
        while (dummy.left != null || dummy.right != null) {
            List<Integer> list = new ArrayList<>();
            ans.add(list);
            helper(dummy);
        }
        return ans;
    }

    public void helper(TreeNode node) {
        if (node.left != null) {
            if (node.left.left == null && node.left.right == null) {
                ans.get(ans.size() - 1).add(node.left.val);
                node.left = null;
            } else {
                helper(node.left);
            }
        }
        if (node.right != null) {
            if (node.right.left == null && node.right.right == null) {
                ans.get(ans.size() - 1).add(node.right.val);
                node.right = null;
            } else {
                helper(node.right);
            }
        }
    }
}

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