import java.util.Stack;

//2[a2[abc]3[cd]ef]
class Solution {
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        boolean isFounded = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '[') {
                stack.push(i);
                isFounded = true;
            } else if (s.charAt(i) == ']') {
                int idx = stack.pop();
                if (stack.empty()) {
                    String newStr = decodeString(s.substring(idx + 1, i));
                    sb.append(String.valueOf(newStr).repeat(num));
                    num = 0;
                    isFounded = false;
                }
            } else if (Character.isDigit(s.charAt(i))) {
                if (! isFounded) num = num * 10 + (int) (s.charAt(i) - '0');
            } else {
                if (stack.empty()) sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("2[abc]3[cd]ef"));
    }
}