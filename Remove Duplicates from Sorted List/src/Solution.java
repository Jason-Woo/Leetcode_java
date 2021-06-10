class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode slow = dummy;
        ListNode fast = head;
        while (fast != null) {
            while (fast.next != null && fast.next.val == fast.val) {
                fast = fast.next;
            }
            slow.next = fast;
            fast = fast.next;
            slow = slow.next;
        }
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(1, a);
        ListNode c = new ListNode(1, b);
        Solution s = new Solution();
        ListNode ss = s.deleteDuplicates(c);
        while (ss != null) {
            System.out.println(ss.val);
            ss = ss.next;
        }
    }
}