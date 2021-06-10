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
    public List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        helper(root, 0);
        return ans;
    }

    void helper(TreeNode node, int depth) {
        if (node == null) return;

        if (ans.size() <= depth) {
            List<Integer> tmp = new ArrayList<>();
            ans.add(tmp);
        }
        ans.get(depth).add(node.val);
        helper(node.left, depth + 1);
        helper(node.right, depth + 1);
    }
    public static void main(String[] args) {
        TreeNode a = new TreeNode(15);
        TreeNode b = new TreeNode(7);
        TreeNode c = new TreeNode(20, a, b);
        TreeNode d = new TreeNode(9);
        TreeNode e = new TreeNode(3, d, c);
        Solution s = new Solution();
        List<List<Integer>> ss = s.levelOrder(e);
        System.out.println(ss);
    }
}