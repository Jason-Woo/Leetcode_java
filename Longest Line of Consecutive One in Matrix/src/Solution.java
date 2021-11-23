// 0 horizontal
// 1 vertical
// 2 principal diagonal
// 3 secondary Diagonal

import java.util.Arrays;

class Solution {
    public int longestLine(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] dp = new int[m][n];
        int ans = mat[0][0];

        //horizontal
        for (int i = 0; i < m; i++) dp[i][0] = mat[i][0];
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = mat[i][j] == 0 ? 0 : dp[i][j - 1] + 1;
                ans = Math.max(ans, dp[i][j]);
            }
        }
//        System.out.println(Arrays.deepToString(dp));

        //vertical
        for (int j = 0; j < n; j++) dp[0][j] = mat[0][j];
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = mat[i][j] == 0 ? 0 : dp[i - 1][j] + 1;
                ans = Math.max(ans, dp[i][j]);
            }
        }
//        System.out.println(Arrays.deepToString(dp));

        //principle diagonal
        for (int i = 0; i < m; i++) dp[i][0] = mat[i][0];
        for (int j = 0; j < n; j++) dp[0][j] = mat[0][j];
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = mat[i][j] == 0 ? 0 : dp[i - 1][j - 1] + 1;
                ans = Math.max(ans, dp[i][j]);
            }
        }
//        System.out.println(Arrays.deepToString(dp));

        //secondary diagonal
        for (int i = 0; i < m; i++) dp[i][0] = mat[i][0];
        for (int j = 0; j < n; j++) dp[m - 1][j] = mat[m - 1][j];
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = mat[i][j] == 0 ? 0 : dp[i + 1][j - 1] + 1;
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().longestLine(new int[][]{
                {1,1,0,0,1,0,0,1,1,0},
        {1,0,0,1,0,1,1,1,1,1},
        {1,1,1,0,0,1,1,1,1,0},
        {0,1,1,1,0,1,1,1,1,1},
        {0,0,1,1,1,1,1,1,1,0},
        {1,1,1,1,1,1,0,1,1,1},
        {0,1,1,1,1,1,1,0,0,1},
        {1,1,1,1,1,0,0,1,1,1},
        {0,1,0,1,1,0,1,1,1,1},
        {1,1,1,0,1,0,1,1,1,1}
        }));
    }
}