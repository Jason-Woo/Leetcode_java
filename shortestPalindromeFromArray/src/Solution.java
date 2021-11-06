import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int shortestPalindromeFromArray(String[] A) {
        Map<String, Integer> map = new HashMap<>();
        int[] map2 = new int[26];
        int ans = 0;
        for (String a : A) {
            String reverse = reverse(a);
            if (map.getOrDefault(reverse, 0) != 0) {
                map.put(reverse, map.get(reverse) - 1);
                ans += 4;
                if (a.charAt(0) == a.charAt(1)) map2[a.charAt(0) - 'a']--;
            } else {
                map.put(a, map.getOrDefault(a, 0) + 1);
                if (a.charAt(0) == a.charAt(1)) map2[a.charAt(0) - 'a']++;
            }
        }
        for (int val : map2) {
            if (val != 0) return ans + 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().shortestPalindromeFromArray(new String[]{"ck", "kc", "ho", "kc"}));
        System.out.println(new Solution().shortestPalindromeFromArray(new String[]{"ab", "hu", "ba", "nn"}));
        System.out.println(new Solution().shortestPalindromeFromArray(new String[]{"so", "oo", "kk", "od"}));
        System.out.println(new Solution().shortestPalindromeFromArray(new String[]{"do", "go", "ok"}));
    }

    public String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        return sb.toString();
    }
}
