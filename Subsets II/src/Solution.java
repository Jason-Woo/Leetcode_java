import java.util.*;

public class Solution {
    public List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>();
        helper(curr, nums, 0);
        return res;
    }
    public void helper(List<Integer> curr, int[] nums, int pos) {
        res.add(new ArrayList<>(curr));

        for (int i = pos; i < nums.length; i++) {
            if (!(i > pos && nums[i] == nums[i - 1])) {
                curr.add(nums[i]);
                helper(curr, nums, i + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }
    public static void main(String[] args) {
        int[] ss = {1, 2, 2};
        Solution s = new Solution();
        List<List<Integer>>res = s.subsetsWithDup(ss);
        System.out.println(res);
    }
}