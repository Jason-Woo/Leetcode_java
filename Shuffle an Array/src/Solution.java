class Solution {

    private int[] origin;
    private int[] curr;
    private int len;

    public Solution(int[] nums) {
        len = nums.length;
        origin = nums.clone();
        curr = nums;
    }

    public int[] reset() {
        curr = origin.clone();
        return origin;
    }

    public int[] shuffle() {
        for (int i = 0; i < len; i++) {
            int rand = (int) (Math.random() * len);
            int temp = curr[i];
            curr[i] = curr[rand];
            curr[rand] = temp;
        }
        return curr;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */