class Solution {

//    [-3,2,-3,4,2]
//    [-3, -1, -4, 0, 2]
    public int minStartValue(int[] nums) {
        int ans = 1;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum <= 0) {
                ans = Math.max(ans, sum * (-1) + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minStartValue(new int[] {-3,2,-3,4,2}));
    }
}