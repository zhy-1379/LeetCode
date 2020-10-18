package com.learn.data.bean;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        builder.append(val);

        ListNode node = next;
        while (node != null) {
            builder.append(", ").append(node.val);
            node = node.next;
        }
        builder.append("]");

        return builder.toString();
    }
}