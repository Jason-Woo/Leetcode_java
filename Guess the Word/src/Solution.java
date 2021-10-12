import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// This is the Master's API interface.
// You should not implement it, or speculate about its implementation
interface Master {
    public int guess(String word);
}
class Solution {
    public void findSecretWord(String[] wordlist, Master master) {
        boolean find = false;
        while (!find) {
            int len = wordlist.length;
            int[][] sim = new int[len][len];

            int[] sumSim = new int[len];
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    int currSim = 0;
                    for (int k = 0; k < 6; k++) currSim += wordlist[i].charAt(k) == wordlist[j].charAt(k) ? 1 : 0;
                    sim[i][j] = currSim;
                    sumSim[i] += currSim;
                    sumSim[j] += currSim;
                }
            }
            int maxPos = 0;
            int maxSim = 0;
            for (int i = 0; i < len; i++) {
                if (sumSim[i] > maxSim) {
                    maxSim = sumSim[i];
                    maxPos = i;
                }
            }

            int match = master.guess(wordlist[maxPos]);
            if (match == 6) find = true;
            List<String> newList = new ArrayList<>();
            for (int i = 0; i < maxPos; i++) {
                if (sim[i][maxPos] == match) newList.add(wordlist[i]);
            }
            for (int i = maxPos + 1; i < len; i++) {
                if (sim[maxPos][i] == match) newList.add(wordlist[i]);
            }
            wordlist = newList.toArray(new String[0]);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.findSecretWord(
                new String[]{"pzrooh", "aaakrw", "vgvkxb", "ilaumf", "snzsrz", "qymapx", "hhjgwz", "mymxyu", "jglmrs", "yycsvl", "fuyzco", "ivfyfx", "hzlhqt", "ansstc", "ujkfnr", "jrekmp", "himbkv", "tjztqw", "jmcapu", "gwwwmd", "ffpond", "ytzssw", "afyjnp", "ttrfzi", "xkwmsz", "oavtsf", "krwjwb", "bkgjcs", "vsigmc", "qhpxxt", "apzrtt", "posjnv", "zlatkz", "zynlqc", "czajmi", "smmbhm", "rvlxav", "wkytta", "dzkfer", "urajfh", "lsroct", "gihvuu", "qtnlhu", "ucjgio", "xyycvd", "fsssoo", "kdtmux", "bxnppe", "usucra", "hvsmau", "gstvvg", "ypueay", "qdlvod", "djfbgs", "mcufib", "prohkc", "dsqgms", "eoasya", "kzplbv", "rcuevr", "iwapqf", "ucqdac", "anqomr", "msztnf", "tppefv", "mplbgz", "xnskvo", "euhxrh", "xrqxzw", "wraxvn", "zjhlou", "xwdvvl", "dkbiys", "zbtnuv", "gxrhjh", "ctrczk", "iwylwn", "wefuhr", "enlcrg", "eimtep", "xzvntq", "zvygyf", "tbzmzk", "xjptby", "uxyacb", "mbalze", "bjosah", "ckojzr", "ihboso", "ogxylw", "cfnatk", "zijwnl", "eczmmc", "uazfyo", "apywnl", "jiraqa", "yjksyd", "mrpczo", "qqmhnb", "xxvsbx"},
                (a) -> {
                  int cnt = 0;
                  String str = "anqomr";
                  for (int i = 0; i < 6; i++) {
                      cnt += str.charAt(i) == a.charAt(i) ? 1: 0;
                  }
                  return cnt;
                });
    }
}