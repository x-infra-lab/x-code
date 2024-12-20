package io.github.xinfra.lab.code.linkedlist;

public class LC21 {
    // https://leetcode.cn/problems/merge-two-sorted-lists/description/

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
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list2 == null) {
                return list1;
            }
            if (list1 == null) {
                return list2;
            }

            ListNode pos;
            if (list1.val <= list2.val) {
                pos = list1;
                list1 = list1.next;
            } else {
                pos = list2;
                list2 = list2.next;
            }
            ListNode head = pos;
            while (list1 != null || list2 != null) {
                if (list1 == null) {
                    pos.next = list2;
                    return head;
                }
                if (list2 == null) {
                    pos.next = list1;
                    return head;
                }
                if (list1.val <= list2.val) {
                    pos.next = list1;
                    list1 = list1.next;
                } else {
                    pos.next = list2;
                    list2 = list2.next;
                }
                pos = pos.next;
            }

            return head;
        }
    }
}
