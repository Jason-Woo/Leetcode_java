import java.util.ArrayList;
import java.util.List;

public class Solution {
//    000
//    001
//    011
//    010
//    110
//    111
//    101
//    100
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList();
        res.add(0);
        for(int i = 1; i <= n; i++){
            int count = res.size() - 1;
            int add = (int)Math.pow(2, i - 1);
            while(count >= 0) {
//                System.out.println(res);
//                System.out.println(add +" " + res.get(count));
                res.add(add + res.get(count));
                count --;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int n = 3;
        Solution s = new Solution();

        System.out.println(s.grayCode(n));
    }
}
