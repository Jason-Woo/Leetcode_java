import java.util.Arrays;

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int curr = nums1.length - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 >= 0 && p2 >= 0) {
                if (nums1[p1] >= nums2[p2]) {
                    nums1[curr] = nums1[p1];
                    p1--;
                } else {
                    nums1[curr] = nums2[p2];
                    p2--;
                }
            } else if (p1 >= 0 && p2 < 0) {
                nums1[curr] = nums1[p1];
                p1--;
            } else if (p1 < 0 && p2 >= 0) {
                nums1[curr] = nums2[p2];
                p2--;
            }
            curr--;
        }
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        s.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }
}