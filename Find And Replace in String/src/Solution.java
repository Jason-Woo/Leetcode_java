import java.util.ArrayList;
import java.util.List;

class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        if (indices.length * sources.length * targets.length == 0) return s;
        List<Rep> list = new ArrayList<>();
        for (int i = 0; i < indices.length; i++) {
            Rep r = new Rep(indices[i], sources[i], targets[i]);
            list.add(r);
        }
        list.sort((a, b) -> {
            return a.pos - b.pos;
        });

        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        int nextPos = 0;
        int i = 0;

        while (i < charArray.length) {
            if (nextPos < list.size() && i == list.get(nextPos).pos) {
                boolean match = true;
                for (int j = 0; j < list.get(nextPos).source.length(); j++) {
                    if (charArray[i + j] != list.get(nextPos).source.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    sb.append(list.get(nextPos).target);
                    i += list.get(nextPos).source.length();
                }
                nextPos++;
            } else {
                sb.append(charArray[i++]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findReplaceString("abcd", new int[]{0, 2}, new String[]{"ab", "ec"}, new String[]{"eee", "fff"}));
    }

    class Rep {
        int pos;
        String source;
        String target;

        public Rep(int pos, String source, String target) {
            this.pos = pos;
            this.source = source;
            this.target = target;
        }
    }
}