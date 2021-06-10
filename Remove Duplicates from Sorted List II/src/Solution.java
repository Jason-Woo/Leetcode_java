class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        //use two pointers, slow - track the node before the dup nodes,
        // fast - to find the last node of dups.
        ListNode dummy = new ListNode(0), fast = head, slow = dummy;
        slow.next = fast;
        while(fast != null) {
            while (fast.next != null && fast.val == fast.next.val) {
                fast = fast.next;    //while loop to find the last node of the dups.
            }
            if (slow.next != fast) { //duplicates detected.
                slow.next = fast.next; //remove the dups.
                fast = slow.next;     //reposition the fast pointer.
            } else { //no dup, move down both pointer.
                slow = slow.next;
                fast = fast.next;
            }

        }
        return dummy.next;
    }
    public static void main(String[] args) {
        ListNode g = new ListNode(5);
        ListNode f = new ListNode(4, g);
        ListNode e = new ListNode(4, f);
        ListNode d = new ListNode(3, e);
        ListNode c = new ListNode(3, d);
        ListNode b = new ListNode(2, c);
        ListNode a = new ListNode(1, b);
        Solution s = new Solution();
        ListNode ss = s.deleteDuplicates(a);
        while (ss != null) {
            System.out.println(ss.val);
            ss = ss.next;
        }
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

