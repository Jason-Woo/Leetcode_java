import java.util.*;

class Solution {
    public int[] findOriginalArray(int[] changed) {

        List<Integer> list = new ArrayList<>();

        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : changed) map.put(i, map.getOrDefault(i, 0) + 1);
        for (int ele : map.keySet()) {
            while (map.get(ele) > 0) {
                map.put(ele, map.get(ele) - 1);
                if (!map.containsKey(ele * 2) || map.get(ele * 2) <= 0) return new int[]{};
                else {
                    list.add(ele);
                    map.put(ele * 2, map.get(ele * 2) - 1);
                }
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i++) ans[i] = list.get(i);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findOriginalArray(new int[]{1, 3, 4, 2, 6, 8})));
    }
}