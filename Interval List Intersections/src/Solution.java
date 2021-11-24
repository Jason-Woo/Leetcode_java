class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {

        List<int[]> ans = new ArrayList<>();
        int pos1 = 0;
        int pos2 = 0;
        while(pos1 < firstList.length && pos2 < secondList.length) {
            int[] tmp = helper(firstList[pos1], secondList[pos2]);
            if (tmp[0] != -1) {
                ans.add(tmp);
            }
            if (firstList[pos1][1] < secondList[pos2][1]) pos1++;
            else pos2++;
        }

        int[][] result = new int[ans.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i][0] = ans.get(i)[0];
            result[i][1] = ans.get(i)[1];
        }
        return result;

    }

    int[] helper(int[] l1, int[] l2) {
        int start = Math.max(l1[0], l2[0]);
        int end = Math.min(l1[1], l2[1]);
        if (start <= end) return new int[]{start, end};
        else return new int[]{-1, -1};
    }

}