import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode tail = new ListNode(3);
        ListNode linkedList = new ListNode(1, new ListNode(2, tail));
        tail.next = linkedList;
        assert s.hasCycle(linkedList);

        linkedList = new ListNode(1, new ListNode(2));
        assert !s.hasCycle(linkedList);
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }

        return false;
    }
}
