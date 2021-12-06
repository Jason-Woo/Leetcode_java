class Solution {

    String str;
    List<String> list;

    public int expressiveWords(String s, String[] words) {
        int ans = 0;

        list = new ArrayList<>();
        char prev = s.charAt(0);
        int startPos = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == prev) {
                continue;
            } else {
                list.add(s.substring(startPos, i));
                startPos = i;
            }
            prev = s.charAt(i);
        }
        list.add(s.substring(startPos, s.length()));

        for (String ele : words) {
            if (helper(ele)) ans++;
        }
        return ans;
    }

    // check one by one
    boolean helper(String target) {

        char prev = target.charAt(0);
        int startPos = 0;
        int listPos = 0;

        for (int i = 1; i < target.length(); i++) {
            if (target.charAt(i) != prev) {
                String currS = target.substring(startPos, i);
//                System.out.println(currS + " " + list.get(listPos));
                if (currS.charAt(0) == list.get(listPos).charAt(0)) {
                    if (currS.length() > list.get(listPos).length() || (currS.length() < list.get(listPos).length() && list.get(listPos).length() < 3)) return false;
                    listPos++;
                    if (listPos >= list.size()) return false;
                } else {
                    return false;
                }
                startPos = i;
                prev = target.charAt(i);
            }
        }

        String currS = target.substring(startPos, target.length());
        if (listPos == list.size() - 1 && currS.charAt(0) == list.get(listPos).charAt(0)) {
            return (currS.length() < list.get(listPos).length() && list.get(listPos).length() >= 3 || currS.length() == list.get(listPos).length());
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().expressiveWords("heeellooooooo", new String[]{"hello", "hi", "helo"}));
        System.out.println(new Solution().expressiveWords("aaa", new String[]{"aaaa"}));
    }

}