import java.util.HashMap;

class Solution {
    public int numSplits(String s) {
        HashMap<Character, Integer> leftMap = new HashMap<>();
        HashMap<Character, Integer> rightMap = new HashMap<>();

        char[] charArray = s.toCharArray();

        for (Character c : charArray) {
            rightMap.put(c, rightMap.getOrDefault(c, 0) + 1);
        }

        int ans = 0;

        for (Character c : charArray) {
            if (leftMap.keySet().size() == rightMap.keySet().size()) ans++;
            leftMap.put(c, leftMap.getOrDefault(c, 0) + 1);
            rightMap.put(c, rightMap.get(c) - 1);
            if (rightMap.get(c) <= 0) rightMap.remove(c);
        }
        return ans;
    }
}