class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> map = new HashMap<>();

        int ans = 0;

        for (int ele : arr) {
            map.put(ele, map.getOrDefault(ele - difference, 0) + 1);
            ans = Math.max(ans, map.get(ele));
        }
        return ans;
    }
}