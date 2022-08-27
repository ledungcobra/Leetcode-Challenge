package com.ledung;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        int length = lengthOf(head);
        var cur = head;
        int i = 0;
        while (i != length / 2) {
            cur = cur.next;
            i++;
        }
        if (length % 2 == 1) {
            cur = cur.next;
        }
        cur = reverseNode(cur);
        while (cur != null) {
            if (cur.val != head.val) {
                return false;
            }
            cur = cur.next;
            head = head.next;
        }
        return true;
    }

    private ListNode reverseNode(ListNode head) {
        ListNode output = null;
        while (head != null) {
            var next = head.next;
            head.next = output;
            output = head;
            head = next;
        }
        return output;
    }

    private int lengthOf(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
}
