package io.github.xinfra.lab.code.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;

public class OpenLock {

    // https://leetcode.cn/problems/open-the-lock/

     class Solution {
        public int openLock(String[] deadends, String target) {
            String start = "0000";
            Set<String> deadendSet = new HashSet<>();
            for (String deadend : deadends){
                deadendSet.add(deadend);
            }
            if (deadendSet.contains(start)) {
                return -1;
            }
            Queue<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            queue.offer(start);
            int step = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                List<String> list = new ArrayList<>();
                for (int i = 0; i < size; i++) {
                    String value = queue.poll();
                    if (Objects.equals(value, target)) {
                        return step;
                    }
                    visited.add(value);
                    list.add(value);
                }

                // maybe repeat
                Set<String> nexts = new HashSet<>();
                for (String value: list) {
                    nexts.addAll(nextStep(value, visited, deadendSet));
                }
                queue.addAll(nexts);
                step++;
            }
            return -1;
        }

        private Set<String> nextStep(String value, Set<String> visited, Set<String> deadendSet) {
            Set<String> nexts = new HashSet<>();

            char[] charArray = value.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];

                charArray[i] = c == '9' ? '0' : (char) (c + 1);
                String s = String.valueOf(charArray);
                if (!visited.contains(s) && !deadendSet.contains(s)) {
                    nexts.add(s);
                }

                charArray[i] = c == '0' ? '9' : (char) (c - 1);
                s = String.valueOf(charArray);
                if (!visited.contains(s) && !deadendSet.contains(s)) {
                    nexts.add(s);
                }
                charArray[i] = c;
            }
            return nexts;
        }
    }

}
