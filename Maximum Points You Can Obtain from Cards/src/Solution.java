class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int ans = 0;
        for (int i = 0; i < k; i++) ans += cardPoints[i];
        int tmp = ans;
        for (int i = 0; i < k; i++) {
            tmp = tmp - cardPoints[k - 1 - i] + cardPoints[cardPoints.length -1 - i];
            ans = Math.max(ans, tmp);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxScore(new int[]{1,2,3,4,5,6,1}, 3));
    }
}