package com.ledung;

public class MergeTwoSortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        var head1 = list1;
        var head2 = list2;
        ListNode beforeHead = new ListNode();
        ListNode tmpHead = beforeHead;

        do {
            if (head1.val < head2.val) {
                beforeHead.next = new ListNode(head1.val);
                head1 = head1.next;
            } else {
                beforeHead.next = new ListNode(head2.val);
                head2 = head2.next;
            }
            beforeHead = beforeHead.next;
        } while (head1 != null && head2 != null);

        while (head1 != null) {
            beforeHead.next = new ListNode(head1.val);
            beforeHead = beforeHead.next;
            head1 = head1.next;
        }

        while (head2 != null) {
            beforeHead.next = new ListNode(head2.val);
            beforeHead = beforeHead.next;
            head2 = head2.next;
        }

        return tmpHead.next;
    }
}
