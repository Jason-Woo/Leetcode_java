
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode();
        ListNode right = new ListNode();

        ListNode left_curr = left;
        ListNode right_curr = right;
        while (head != null) {
            if (head.val < x) {
                left_curr.next = head;
                left_curr = left_curr.next;
            } else {
                right_curr.next = head;
                right_curr = right_curr.next;
            }
            head = head.next;
        }
        right_curr.next = null;
        left_curr.next = right.next;
        return left.next;
    }
    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(5, a);
        ListNode c = new ListNode(2, b);
        ListNode d = new ListNode(3, c);
        ListNode e = new ListNode(4, d);
        ListNode f = new ListNode(1, e);
        Solution s = new Solution();
        ListNode ss = s.partition(f, 3);
        while (ss != null) {
            System.out.println(ss.val);
            ss = ss.next;
        }
    }
}