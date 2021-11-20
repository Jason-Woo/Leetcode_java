import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutorService;

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Map<Double, Integer> map = new TreeMap<>();
        map.put(dis(p1, p2), map.getOrDefault(dis(p1, p2), 0) + 1);
        map.put(dis(p1, p3), map.getOrDefault(dis(p1, p3), 0) + 1);
        map.put(dis(p1, p4), map.getOrDefault(dis(p1, p4), 0) + 1);
        map.put(dis(p2, p3), map.getOrDefault(dis(p2, p3), 0) + 1);
        map.put(dis(p2, p4), map.getOrDefault(dis(p2, p4), 0) + 1);
        map.put(dis(p3, p4), map.getOrDefault(dis(p3, p4), 0) + 1);

        List<Double> list = new ArrayList<>(map.keySet());
        if (list.size() != 2) return false;
        if (list.get(0) * 2 != list.get(1)) return false;
        return true;
    }

    double dis(int[] p1, int p2[]) {
        return Math.pow((p1[0] - p2[0]), 2) + Math.pow((p1[1] - p2[1]), 2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validSquare(new int[]{0,0}, new int[]{1,1}, new int[]{1,0}, new int[]{0,1}));
    }
}