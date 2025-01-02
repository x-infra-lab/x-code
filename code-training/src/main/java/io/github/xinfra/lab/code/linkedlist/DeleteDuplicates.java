package io.github.xinfra.lab.code.linkedlist;

public class DeleteDuplicates {

    // https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null) {
                if (slow.val != fast.val) {
                    slow.next = fast;
                    slow = slow.next;
                }
                fast = fast.next;
            }

            slow.next = null;

            return head;
        }
    }
}
