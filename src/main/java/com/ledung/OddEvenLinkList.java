package com.ledung;

public class OddEvenLinkList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return null;
        }
        var odd = head;
        var even = head.next;
        var tmp = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = tmp;
        return head;
    }

}
