package io.github.xinfra.lab.code.graph;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class OpenLock {

    // https://leetcode.cn/problems/open-the-lock/

    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.openLock(new String[]{
                "8887","8889","8878","8898","8788","8988","7888","9888"
        }, "8888");
        System.out.println(i);
    }

    static class Solution {
        public int openLock(String[] deadends, String target) {
            Queue<String> queue = new LinkedList<>();
            Set<String> visited = new HashSet<>();
            Set<String> deadendSet = Arrays.stream(deadends).collect(Collectors.toSet());
            queue.add("0000");
            int step = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    String value = queue.poll();
                    if (Objects.equals(value, target)) {
                        return step;
                    }
                    visited.add(value);
                    if (deadendSet.contains(value)) {
                        continue;
                    }
                    Set<String> nextSet = nextStep(value, visited);
                    nextSet.forEach(queue::add);
                }
                step++;
            }
            return -1;
        }

        private Set<String> nextStep(String value, Set<String> visited) {
            Set<String> nextSet = new HashSet<>();

            char[] charArray = value.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                char c = charArray[i];

                charArray[i] = c == '9' ? '0' : (char) (c + 1);
                String s = String.valueOf(charArray);
                if (!visited.contains(s)) {
                    nextSet.add(s);
                }
                charArray[i] = c;

                charArray[i] = c == '0' ? '9' : (char) (c - 1);
                s = String.valueOf(charArray);
                if (!visited.contains(s)) {
                    nextSet.add(s);
                }
                charArray[i] = c;
            }
            return nextSet;
        }
    }

}
