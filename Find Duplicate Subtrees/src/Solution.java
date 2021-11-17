import java.util.*;

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

    List<TreeNode> ans;
    Map<String, Integer> memo;

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ans = new ArrayList<>();
        memo = new HashMap();
        helper(root);
        return ans;
    }

    public String helper(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        if (node.left != null) {
            sb.append(helper(node.left));
        } else {
            sb.append("#");
        }
        sb.append(',');
        if (node.right != null) {
            sb.append(helper(node.right));
        } else {
            sb.append("#");
        }
        sb.append(',');
        sb.append(node.val);
        String postTraverse = sb.toString();
        if (memo.getOrDefault(postTraverse, 0) == 1) {
            ans.add(node);
        }
        memo.put(postTraverse, memo.getOrDefault(postTraverse, 0) + 1);
        return postTraverse;
    }
    public String helper2(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        if (node.left != null) {
            sb.append(helper(node.left));
        } else {
            sb.append("#");
        }
        sb.append(',');
        sb.append(node.val);
        sb.append(',');
        if (node.right != null) {
            sb.append(helper(node.right));
        } else {
            sb.append("#");
        }
        String postTraverse = sb.toString();
        if (memo.getOrDefault(postTraverse, 0) == 1) {
            ans.add(node);
        }
        memo.put(postTraverse, memo.getOrDefault(postTraverse, 0) + 1);
        return postTraverse;
    }
    public String helper3(TreeNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append(node.val);
        sb.append(',');
        if (node.left != null) {
            sb.append(helper(node.left));
        } else {
            sb.append("#");
        }
        sb.append(',');
        if (node.right != null) {
            sb.append(helper(node.right));
        } else {
            sb.append("#");
        }
        String postTraverse = sb.toString();
        if (memo.getOrDefault(postTraverse, 0) == 1) {
            ans.add(node);
        }
        memo.put(postTraverse, memo.getOrDefault(postTraverse, 0) + 1);
        return postTraverse;
    }
}