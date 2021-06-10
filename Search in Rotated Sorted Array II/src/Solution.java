public class Solution {
    public boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
//            System.out.println(start);
//            System.out.println(end);
//            System.out.println(mid);
            if (nums[mid] == target || nums[start] == target || nums[end] == target) {
                return true;
            } else if (nums[mid] < target) {
                if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                    if (target < nums[end]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                } else if (nums[mid] > nums[end] || nums[mid] > nums[start]){
                    start = mid + 1;
                } else {
                    end --;
                }
            } else {
                if (nums[mid] < nums[end] || nums[mid] < nums[start]) {
                    end = mid - 1;
                } else if (nums[mid] > nums[end] || nums[mid] > nums[start]){
                    if (target < nums[end]) {
                        start = mid + 1;
                    } else {
                        end = mid - 1;
                    }
                } else {
                    end --;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {2,5,6,0,0,1,2};
        int[] arr2 = {2,5,6,0,0,1,2};
        int[] arr3 = {1,0,1,1,1};
        int[] arr4 = {1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1};
        int[] arr5 = {1,3};
        Solution s = new Solution();
//        System.out.println(s.search(arr, 0));
//        System.out.println(s.search(arr2, 3));
//        System.out.println(s.search(arr3, 0));
//        System.out.println(s.search(arr4, 2));
        System.out.println(s.search(arr5, 3));
    }
}
