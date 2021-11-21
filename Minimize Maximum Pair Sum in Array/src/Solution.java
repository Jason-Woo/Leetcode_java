import java.util.Arrays;

class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[nums.length - 1];
        for (int i = 1; i <= nums.length - 1 - i; i++) {
            ans = Math.max(ans, nums[i] + nums[nums.length - 1 - i]);
        }
        return ans;
    }
}
