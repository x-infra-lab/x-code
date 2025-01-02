package io.github.xinfra.lab.code.linkedlist;

public class RemoveNthFromEnd {

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


//    class Solution {
//        public ListNode removeNthFromEnd(ListNode head, int n) {
//            ListNode res = head;
//            ListNode pos = head;
//            int i = 1;
//            while (i < n + 1) {
//                head = head.next;
//                i++;
//                if (head == null) {
//                    return pos.next;
//                }
//            }
//
//            while (head.next != null) {
//                head = head.next;
//                pos = pos.next;
//            }
//
//            pos.next = pos.next.next;
//            return res;
//        }
//    }

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            head = new ListNode(0, head);
            ListNode dummy = head;
            ListNode pos = head;
            int i = 1;
            while (i < n + 1) {
                head = head.next;
                i++;
            }

            while (head.next != null) {
                head = head.next;
                pos = pos.next;
            }

            pos.next = pos.next.next;
            return dummy.next;
        }
    }
}
