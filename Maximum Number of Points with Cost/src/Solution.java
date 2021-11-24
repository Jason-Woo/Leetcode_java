import java.util.Arrays;

class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length, n = points[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < n; i++) dp[0][i] = points[0][i];
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int maxPt = 0;
                for (int k = 0; k < n; k++) {
                    maxPt = Math.max(maxPt, dp[i - 1][k] - Math.abs(j - k));
                }
                dp[i][j] = maxPt + points[i][j];
            }
        }

//        System.out.println(Arrays.deepToString(dp));

        int ans = 0;
        for (int i = 0; i < n; i++) ans = Math.max(ans, dp[m - 1][i]);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxPoints(new int[][]{{1,2,3},{1,5,1},{3,1,1}}));
    }
}