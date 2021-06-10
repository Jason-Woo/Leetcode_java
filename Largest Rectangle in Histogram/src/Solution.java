class Solution {
    public int largestRectangleArea(int[] heights) {
        int arr_size = heights.length;
        int[] border_left = new int[arr_size];
        int[] border_right = new int[arr_size];
        border_left[0] = -1;
        border_right[arr_size - 1] = arr_size;

        for (int i = 1; i < arr_size; i++) {
            int p = i - 1;
            while (p >= 0 && heights[p] >= heights[i]) {
                p = border_left[p];
            }
            border_left[i] = p;
        }
        for (int i = arr_size - 2; i >= 0; i--) {
            int p = i + 1;
            while (p <= arr_size - 1 && heights[p] >= heights[i]) {
                p = border_right[p];
            }
            border_right[i] = p;
        }
        int max_area = -1;
        for (int i = 0; i < arr_size; i ++) {
            int curr_area = (border_right[i] - border_left[i] - 1) * heights[i];
            max_area = Math.max(max_area, curr_area);
        }
        return max_area;
    }
    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        Solution s = new Solution();
        System.out.println(s.largestRectangleArea(arr));
    }
}