package io.github.xinfra.lab.code.linkedlist;

public class HasCycle {
    // https://leetcode.cn/problems/linked-list-cycle/

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {
            ListNode slow = head , fast = head;

            while (fast!=null && fast.next!=null){
                fast = fast.next.next;
                slow = slow.next;
                if (fast== slow){
                    return true;
                }
            }

            return false;
        }
    }
}
