package io.github.xinfra.lab.code.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;


public class LadderLength {

    // https://leetcode.cn/problems/word-ladder/
    class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            Set<String> wordSet = new HashSet<>(wordList);
            if (!wordSet.contains(endWord)){
                return 0;
            }
            Queue<String> queue = new LinkedList<>();
            queue.add(beginWord);
            Set<String> visited = new HashSet<>();
            int step = 1; // ps: result contains beginWord
            while (!queue.isEmpty()){
                int size = queue.size();
                List<String> list = new ArrayList<>();
                for (int i = 0 ; i < size ; i++){
                    String str = queue.poll();
                    if (str.equals(endWord)){
                        return step;
                    }
                    visited.add(str);
                    list.add(str);
                }
                Set<String> nextSet = new HashSet<>();
                for (String s: list){
                    nextSet.addAll(next(s, visited, wordSet));
                }
                queue.addAll(nextSet);
                step++;
            }

            return 0;
        }

        private Set<String> next(String s, Set<String> visited, Set<String> wordSet) {
            Set<String> set = new HashSet<>();
            char[] charArray = s.toCharArray();
            for (int i = 0 ; i < charArray.length; i++){
                char originChar = charArray[i];
                for (int ci = 'a' ; ci <= 'z'; ci++){
                    char c = (char) ci;
                    if (c == charArray[i]){
                        continue;
                    }
                    charArray[i] = c;
                    String str = String.valueOf(charArray);
                    if (!visited.contains(str) && wordSet.contains(str)){
                        set.add(str);
                    }
                }
                charArray[i] = originChar;
            }
            return set;
        }
    }
}
