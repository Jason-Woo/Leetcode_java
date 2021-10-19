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

    List<List<Integer>> ans;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ans = new ArrayList<>();
        helper(root, 1);
        return ans;
    }

    public void helper(TreeNode node, int depth) {
        if (node == null) return;
        if (ans.size() < depth) {
            List<Integer> layer = new ArrayList<>();
            ans.add(layer);
        }

        if (depth % 2 == 0) {
            ans.get(depth - 1).add(0, node.val);
        } else {
            ans.get(depth - 1).add(node.val);
        }
        if (node.left != null) {
            helper(node.left, depth + 1);
        }
        if (node.right != null) {
            helper(node.right, depth + 1);
        }
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(15);
        TreeNode b = new TreeNode(7);
        TreeNode c = new TreeNode(9);
        TreeNode d = new TreeNode(20);
        TreeNode e = new TreeNode(3);
        e.left = c;
        e.right = d;
        d.left = a;
        d.right = b;

        Solution s = new Solution();
        System.out.println(s.zigzagLevelOrder(e));

    }
}