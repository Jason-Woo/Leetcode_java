import java.util.HashMap;

class Solution {
    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;

        HashMap<Character, Integer> dict1 = new HashMap<>();
        HashMap<Character, Integer> dict2 = new HashMap<>();

        for (int i = 0; i < secret.length(); i++) {
            char c1 = secret.charAt(i);
            char c2 = guess.charAt(i);
            if (c1 == c2) {
                a++;
            } else {
                if (dict1.containsKey(c2) && dict1.get(c2) != 0) {
                    b++;
                    dict1.put(c2, dict1.get(c2) - 1);
                } else {
                    if (dict2.containsKey(c2)) {
                        dict2.put(c2, dict2.get(c2) + 1);
                    } else {
                        dict2.put(c2, 1);
                    }

                }
                if (dict2.containsKey(c1) && dict2.get(c1) != 0) {
                    b++;
                    dict2.put(c1, dict2.get(c1) - 1);
                } else {
                    if (dict1.containsKey(c1)) {
                        dict1.put(c1, dict1.get(c1) + 1);
                    } else {
                        dict1.put(c1, 1);
                    }
                }
            }
        }
        return a + "A" + b + "B";

    }
}
