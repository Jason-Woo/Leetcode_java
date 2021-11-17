import java.util.*;

class Solution {
    public int numMatchingSubseq(String S, String[] words) {
        int ans = 0;
        ArrayList<Node>[] heads = new ArrayList[26];
        for (int i = 0; i < 26; ++i)
            heads[i] = new ArrayList<Node>();

        for (String word: words)
            heads[word.charAt(0) - 'a'].add(new Node(word, 0));

        for (char c: S.toCharArray()) {
            System.out.println(Arrays.toString(heads));
            ArrayList<Node> old_bucket = heads[c - 'a'];
            heads[c - 'a'] = new ArrayList<Node>();

            for (Node node: old_bucket) {
                node.index++;
                if (node.index == node.word.length()) {
                    ans++;
                } else {
                    heads[node.word.charAt(node.index) - 'a'].add(node);
                }
            }
            old_bucket.clear();
        }
        return ans;
    }

    public int numMatchingSubseq2(String S, String[] words) {
        int ans = 0;
        Map<Character, List<String>> memo = new HashMap<>();

        for (String s : words) {
            char c = s.charAt(0);
            if (memo.containsKey(c)) {
                if (s.length() > 1) memo.get(c).add(s.substring(1));
                else ans++;
            } else {
                List<String> list = new ArrayList<>();
                if (s.length() > 1) list.add(s.substring(1));
                else ans++;
                memo.put(c, list);
            }
        }
        int i = 0;
        while (ans < words.length && i < S.length()) {
//            System.out.println(memo);
            char c = S.charAt(i);
            if (memo.containsKey(c)) {
                List<String> newList = new ArrayList<>(memo.get(c));
                memo.get(c).clear();
                for (String str : newList) {
                    if (str.equals("")) ans++;
                    else {
                        char newC = str.charAt(0);
                        if (memo.containsKey(newC)) {
                            if (str.length() > 1) memo.get(str.charAt(0)).add(str.substring(1));
                            else memo.get(str.charAt(0)).add("");
                        } else {
                            List<String> list = new ArrayList<>();
                            if (str.length() > 1) list.add(str.substring(1));
                            else list.add("");
                            memo.put(newC, list);
                        }

                    }
                }
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numMatchingSubseq("abcde", new String[]{"a","bb","acd","ace"}));
    }
}

class Node {
    String word;
    int index;
    public Node(String w, int i) {
        word = w;
        index = i;
    }

    @Override
    public String toString() {
        return word + " " + index;
    }
}