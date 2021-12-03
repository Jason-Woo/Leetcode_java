import java.util.Map;
import java.util.TreeMap;

class Solution {
    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>();

        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        for (int i : map.keySet()) {
            while (map.get(i) > 0) {
                map.put(i, map.get(i) - 1);
                if (i < 0)  {
                    if (i % 2 == -1) return false;
                    if (!map.containsKey(i / 2) || map.get(i / 2) <= 0) return false;
                    else map.put(i / 2, map.get(i / 2) - 1);
                } else {
                    if (!map.containsKey(i * 2) || map.get(i * 2) <= 0) return false;
                    else map.put(i * 2, map.get(i * 2) - 1);
                }
            }
        }
        return true;
    }
}