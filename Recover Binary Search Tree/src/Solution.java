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

public class Solution {
    TreeNode first = null, second = null, pre = null;
    public void recoverTree(TreeNode root) {
        if(root == null) return;
        dfs(root);
        if(first != null && second != null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }

    }
    public void dfs(TreeNode root){
        if(root.left != null) dfs(root.left);
        if(pre != null && pre.val > root.val)
        {
            if(first == null) first = pre;
            if(first != null) second = root;
        }
        pre = root;
        if(root.right != null) dfs(root.right);
    }
}