import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode tail = new ListNode(3);
        ListNode linkedList = new ListNode(1, new ListNode(2, tail));
        tail.next = linkedList;
        assert s.hasCycle(linkedList);
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
        ListNode current = head;
        ListNode previous = null; // NOTE: we need the previous because we don't want to overwrite current.next
        while (current != null) {
            if (current == current.next) {
                return true;
            }
            if (previous != null) {
                previous.next = previous;
            }
            previous = current;
            current = current.next;
        }

        return false;
    }
}
