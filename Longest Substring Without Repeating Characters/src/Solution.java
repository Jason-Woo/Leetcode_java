import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int p1 = 0;
        int p2 = 0;
//        ArrayList<Character> curr = new ArrayList<Character>();
        HashMap<Character, Integer> curr = new HashMap<Character, Integer>();
        int max_len = 0;
        while (p2 < s.length()) {
            char curr_s = s.charAt(p2);
            if (curr.containsKey(curr_s)) {
                int curr_len = p2 - p1;
                max_len = Math.max(curr_len, max_len);
                p1 = curr.get(curr_s) + 1;
                p2 = p1;
                curr.clear();
            } else {
                curr.put(curr_s, p2);
                p2 += 1;
            }
        }
        int curr_len = p2 - p1;
        max_len = Math.max(curr_len, max_len);
        return max_len;
    }
    public static void main(String[] args) {
        String ss = "dvdf";
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstring(ss));
    }
}