
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int tmp = 0;
        ListNode head = new ListNode();
        ListNode prev = head;
        while (l1 != null || l2 != null || tmp != 0) {
            int curr_val = tmp;
            if (l1 != null) {
                curr_val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                curr_val += l2.val;
                l2 = l2.next;
            }
            if (curr_val >= 10) {
                tmp = 1;
                curr_val -= 10;
            } else {
                tmp = 0;
            }
            ListNode curr = new ListNode(curr_val);
            prev.next = curr;
            prev = curr;
        }
        return head.next;
    }
}