package io.github.xinfra.lab.code.linkedlist;

public class GetIntersectionNode {

    // https://leetcode.cn/problems/intersection-of-two-linked-lists/description/
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {

        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode posA = headA;
            ListNode posB= headB;

            while (posA != posB){
                posA = posA == null? headB : posA.next;
                posB = posB == null? headA : posB.next;
            }
            return posA;
        }

    }
}
