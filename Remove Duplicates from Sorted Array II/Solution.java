import java.util.Arrays;

class Solution {
    public int removeDuplicates(int[] nums) {
       if (nums.length == 0) {
           return 0;
       }
       int start = 1;
       int cnt = 1;
       for (int i = 1; i < nums.length; i++) {
           if (nums[i] == nums[i - 1]) {
               if (cnt < 2) {
                   nums[start] = nums[i];
                   start++;
               }
               cnt++;
           } else {
               cnt = 1;
               nums[start] = nums[i];
               start ++;
           }
       }
       return start;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,1,1,2,2,3};
        int[] nums2 = {0,0,1,1,1,1,2,3,3};
        Solution s = new Solution();
        System.out.println(s.removeDuplicates(nums1));
        System.out.println(s.removeDuplicates(nums2));
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));

    }
}