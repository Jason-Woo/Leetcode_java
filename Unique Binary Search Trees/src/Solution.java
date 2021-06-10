class Solution {
    public int numTrees(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else {
            int ans = 0;
            for (int i = 0; i < n; i ++) {
                ans += numTrees(i) * numTrees(n - 1 - i);
            }
            return ans;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numTrees(4));
    }
}