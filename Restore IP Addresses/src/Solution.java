import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) {
            return ans;
        }
        helper("", 0, s, 0);
        return ans;
    }

    boolean valid(String ss) {
        if (ss.equals("")) return false;
        int ssToInt = Integer.parseInt(ss);
        if (!Integer.toString(ssToInt).equals(ss)) return false;
        return ssToInt >= 0 && ssToInt <= 255;
    }

    void helper(String curr, int pos, String s, int depth) {
//        System.out.println(curr+" "+depth);
        if (depth == 3) {
//            System.out.println(s.length() - pos);
            if (s.length() - pos <= 3) {
                String subStr = s.substring(pos);
                if (valid(subStr)) {
                    curr += subStr;
//                    System.out.println("curr" + curr);
                    ans.add(curr);
                }
            }
        } else if(depth < 3){
            int max_len = Math.min(3, s.length() - pos);
            for (int i = 1; i <= max_len; i++) {
                String subStr = s.substring(pos, pos+i);
                if (valid(subStr)) {
                    helper(curr + subStr + ".", pos + i, s, depth + 1);
                }
            }
        }

    }
    public static void main(String[] args) {
        Solution s = new Solution();
        String ss = "101023";
        System.out.println(s.restoreIpAddresses(ss));
    }
}