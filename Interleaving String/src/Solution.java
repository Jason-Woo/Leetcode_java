import java.util.Arrays;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= s1.length(); i++) {
            if (dp[i - 1][0] == 1 && s1.charAt(i - 1) == s3.charAt(i - 1)) {
                dp[i][0] = 1;
            }
        }
        for (int j = 1; j <= s2.length(); j++) {
            if (dp[0][j - 1] == 1 && s2.charAt(j - 1) == s3.charAt(j - 1)) {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                if (dp[i - 1][j] == 1 && s1.charAt(i - 1) == s3.charAt(i + j - 1)){
                    dp[i][j] = 1;
                } else if (dp[i][j - 1] == 1 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        return dp[s1.length()][s2.length()] == 1;
    }
    public static void main(String[] agrs) {
        String s1="aabcc";
        String s2="dbbca";
        String s3="aadbbcbcac";
        Solution s = new Solution();
        System.out.println(s.isInterleave(s1, s2, s3));
    }
}