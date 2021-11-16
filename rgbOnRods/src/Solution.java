import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public int rgbOnRods(String s) {
        List<HashSet<Character>> rods = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            rods.add(new HashSet<>());
        }
        for (int i = 0; i < s.length() / 2; i++) {
            rods.get(s.charAt(i * 2 + 1) - '0').add(s.charAt(i * 2));
        }
        int score = 0;
        for (int  i = 0; i < 10; i++) {
            if (rods.get(i).size() == 3) score++;
        }
        return score;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().rgbOnRods("B2R5G2R2"));
        System.out.println(new Solution().rgbOnRods("R8R0B5G1B8G8"));
        System.out.println(new Solution().rgbOnRods("B2R5G2R2B5G5"));
    }
}
