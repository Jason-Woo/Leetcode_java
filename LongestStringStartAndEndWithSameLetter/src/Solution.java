public class Solution {
    public String LongestStringStartAndEndWithSameLetter(String s) {
        int[] map = new int[26];
        for (int i = 0 ; i < s.length(); i++) {
            map[s.charAt(i) - 'a'] = i;
        }
        String ans = Character.toString(s.charAt(0));
        int maxLen = 1;
        for (int i = 0; i < s.length(); i++) {
            int endIndex = map[s.charAt(i) - 'a'];
            if (endIndex - i > maxLen) {
                ans = s.substring(i, endIndex + 1);
                maxLen = endIndex - i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().LongestStringStartAndEndWithSameLetter("cbaabaab"));
        System.out.println(new Solution().LongestStringStartAndEndWithSameLetter("performance"));
        System.out.println(new Solution().LongestStringStartAndEndWithSameLetter("cat"));
    }
}
