import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    List<TreeNode> res;
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        res = new ArrayList<>();
        TreeNode dummy = new TreeNode();
        dummy.left = root;
        delNodesHelper(root, to_delete, true, dummy, true);
        return res;
    }

    public boolean inArray(int[] to_delete, int num) {
        for (int i : to_delete) {
            if (num == i) return true;
        }
        return false;
    }

    public void delNodesHelper(TreeNode root, int[] to_delete, boolean del, TreeNode p, boolean l) {
        if (inArray(to_delete, root.val)) {
            if (root.left != null) {
                delNodesHelper(root.left, to_delete, true, root, true);
            }
            if (root.right != null) {
                delNodesHelper(root.right, to_delete, true, root, false);
            }
            if (l) {
                p.left = null;
            } else {
                p.right = null;
            }
        } else {
            if (del) {
                res.add(root);
            }
            if (root.left != null) {
                delNodesHelper(root.left, to_delete, false, root, true);
            }
            if (root.right != null) {
                delNodesHelper(root.right, to_delete, false, root, false);
            }
        }
    }
}
