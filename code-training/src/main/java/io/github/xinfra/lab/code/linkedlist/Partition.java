package io.github.xinfra.lab.code.linkedlist;

public class Partition {

    /**
     * https://leetcode.cn/problems/partition-list/description/
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


    class Solution {
        public ListNode partition(ListNode head, int x) {
            ListNode left = new ListNode();
            ListNode right = new ListNode();
            ListNode res1 = left;
            ListNode res2 = right;
            while (head != null) {
                if (head.val < x) {
                    left.next = head;
                    left = left.next;
                } else {
                    right.next = head;
                    right = right.next;
                }
                head = head.next;
            }

            right.next = null;
            left.next = res2.next;
            return res1.next;
        }
    }
}
