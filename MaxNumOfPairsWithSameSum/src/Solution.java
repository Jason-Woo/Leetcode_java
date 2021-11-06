import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int maxNumOfPairsWithSameSum(int[] A) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int sum = A[i] + A[j];
                if (map.containsKey(sum)) {
                    if (!(map.get(sum).contains(i)) &&(!map.get(sum).contains(j)) ) {
                        map.get(sum).add(i);
                        map.get(sum).add(j);
                    }
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(i);
                    set.add(j);
                    map.put(sum, set);
                }
            }
        }
        int max = 1;
        for (int s : map.keySet()) {
            max = Math.max(map.get(s).size() / 2, max);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxNumOfPairsWithSameSum(new int[]{1, 9, 8, 100, 2}));
        System.out.println(new Solution().maxNumOfPairsWithSameSum(new int[]{2, 2, 2, 3}));
        System.out.println(new Solution().maxNumOfPairsWithSameSum(new int[]{5, 5}));
    }
}
