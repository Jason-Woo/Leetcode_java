import java.util.Stack;

class Solution {
    public int lengthLongestPath(String input) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0); // "dummy" length
        int maxLen = 0;
        for(String s : input.split("\n")){
            System.out.println(s);
            int lev = s.lastIndexOf("\t") + 1; // number of "\t"
            while(lev + 1 < stack.size()) stack.pop(); // find parent
            System.out.println(stack);
            int len = stack.peek() + s.length() - lev + 1; // remove "/t", add"/"
            stack.push(len);
            // check if it is file
            System.out.println(stack);
            if(s.contains(".")) maxLen = Math.max(maxLen, len - 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
    }
}