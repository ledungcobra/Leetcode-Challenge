package com.ledung;

public class ReverseLinkList {
    public ListNode reverseList(ListNode head) {
        ListNode output = null;
        var curNode = head;
        while (curNode != null) {
            var next = curNode.next;
            curNode.next = output;
            output = curNode;
            curNode = next;
        }
        return output;
    }
}
