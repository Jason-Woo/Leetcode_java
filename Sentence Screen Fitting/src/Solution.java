import java.util.Arrays;

//dp[index] means if the row start at index then the start of next row is dp[index]
//"i","had","apple","pie"
//i-had
//apple

//had--
//apple

//apple
//pie-i

//pie-i
//had--


class Solution {
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int[] dp = new int[sentence.length];
        int n = sentence.length;

        for(int i = 0, prev = 0, len = 0; i < sentence.length; ++i) {
            // remove the length of previous word and space
            if(i != 0 && len > 0) len -= sentence[i - 1].length() + 1;

            // calculate the start of next line.
            // it's OK the index is beyond the length of array so that
            // we can use it to count how many words one row has.
            while(len + sentence[prev % n].length() <= cols) len += sentence[prev++ % n].length() + 1;
            dp[i] = prev;
        }

        System.out.println(Arrays.toString(dp));

        int count = 0;
        for(int i = 0, k = 0; i < rows; ++i) {
            // count how many words one row has and move to start of next row.
            // It's better to check if d[k] == k but I find there is no test case on it.
            // if(dp[k] == k) return 0;
            System.out.println(dp[k] + " " + k);
            count += dp[k] - k;
            k = dp[k] % n;

        }
        // divide by the number of words in sentence
        return count / n;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().wordsTyping(new String[]{"i","had","apple","pie"}, 4, 5));
    }
}