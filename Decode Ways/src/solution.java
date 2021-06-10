import java.util.Arrays;

class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for (int i = 1; i < s.length(); i ++) {
            if (s.charAt(i) != '0') {
                dp[i + 1] += dp[i];
            }
            int num = Integer.parseInt(s.substring(i - 1 , i + 1));
            if (num >= 10 && num <= 26) {
                dp[i + 1] += dp[i - 1];
            }
//            System.out.println(Arrays.toString(dp));
        }
        return dp[s.length()];
    }
    public static void main(String[] args) {
        String s1 = "226";
        String s2 = "0";
        String s3 = "06";
        Solution s = new Solution();
        System.out.println(s.numDecodings(s1));
        System.out.println(s.numDecodings(s2));
        System.out.println(s.numDecodings(s3));
    }
}