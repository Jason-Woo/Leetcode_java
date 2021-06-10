
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int cnt = -1;
        left--;
        right--;
        ListNode dummy = new ListNode(-1, head);
        ListNode curr = dummy;
        ListNode start = new ListNode();
        ListNode end = new ListNode();
        ListNode prev = new ListNode();
        ListNode next = new ListNode();

        while (curr != null) {
            if (cnt > left && cnt <= right) {
                next = curr.next;
                curr.next = prev;
//                System.out.println(curr.val + "->" + prev.val);
                prev = curr;
                curr = next;
                if (curr == null) {
                    start.next = prev;
                    end.next = null;
                }
            } else {
                if (cnt == left - 1) {
//                    System.out.println("st" + curr.val);
                    start = curr;
                } else if (cnt == left) {
//                    System.out.println("end, prev" + curr.val);
                    end = curr;
                    prev = curr;
                } else if(cnt == right + 1) {
//                    System.out.println(start.val + "->" + prev.val);
                    start.next = prev;
                    end.next = curr;
                }
                curr = curr.next;
            }
            cnt += 1;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(4, a);
        ListNode c = new ListNode(3, b);
        ListNode d = new ListNode(2, c);
        ListNode e = new ListNode(1, d);
        Solution s = new Solution();
        ListNode ss = s.reverseBetween(e, 2, 5);
        while (ss != null) {
            System.out.println(ss.val);
            ss = ss.next;
        }
    }
}