package io.github.xinfra.lab.code.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    //https://leetcode.cn/problems/merge-k-sorted-lists/description/

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
//        public ListNode mergeKLists(ListNode[] lists) {
//            ListNode pos = new ListNode();
//            ListNode resHead = pos;
//            while (true) {
//                int notNullSize = 0;
//                boolean allNull = true;
//                int minIdx = -1;
//                for (int i = 0; i < lists.length; i++) {
//                    if (lists[i] != null) {
//                        notNullSize++;
//                        allNull = false;
//                        if (minIdx < 0 || lists[i].val < lists[minIdx].val) {
//                            minIdx = i;
//                        }
//                    }
//                }
//                if (allNull) {
//                    return resHead.next;
//                }
//
//                pos.next = lists[minIdx];
//                if (notNullSize == 1) {
//                    return resHead.next;
//                }
//                lists[minIdx] = lists[minIdx].next;
//                pos = pos.next;
//            }
//        }
//    }


    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
                @Override
                public int compare(ListNode o1, ListNode o2) {
                    return o1.val - o2.val;
                }
            });
            ListNode pos = new ListNode();
            ListNode resHead = pos;
            for (ListNode node : lists) {
                if (node != null) {
                    queue.offer(node);
                }
            }

            while (!queue.isEmpty()) {
                ListNode pollNode = queue.poll();
                pos.next = pollNode;

                pos = pos.next;
                if (pollNode.next != null) {
                    queue.offer(pollNode.next);
                }
            }

            return resHead.next;
        }
    }
}
