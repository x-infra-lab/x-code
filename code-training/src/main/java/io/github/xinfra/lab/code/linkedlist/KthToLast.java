package io.github.xinfra.lab.code.linkedlist;

public class KthToLast {
    // https://leetcode.cn/problems/kth-node-from-end-of-list-lcci/

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
//
//        public int kthToLast(ListNode head, int k) {
//            this.k = k;
//            kthToLast(head);
//
//            return res.val;
//        }
//
//        ListNode res ;
//        int k ;
//        public int kthToLast(ListNode head){
//            if (head==null) {
//                return 0;
//            }
//            int v = kthToLast(head.next) + 1;
//            if (v == k){
//                res = head;
//            }
//            return v;
//        }
//    }

    class Solution {

        public int kthToLast(ListNode head, int k) {
            ListNode pos = head;
            int i = 1;
            while (i<k){
                head = head.next;
                i++;
            }

            while (head.next!=null){
                head = head.next;
                pos = pos.next;
            }

            return pos.val;
        }

    }
}
