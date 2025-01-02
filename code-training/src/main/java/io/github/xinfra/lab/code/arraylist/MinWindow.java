package io.github.xinfra.lab.code.arraylist;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinWindow {

    class Solution {
        public String minWindow(String s, String t) {
            if (s.length() < t.length()) {
                return "";
            }
            Map<Character, Integer> targetMap = new HashMap<>();
            for (char c : t.toCharArray()) {
                targetMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
            }
            int invalid = targetMap.keySet().size();
            int minLen = -1;
            int statIdx = -1;
            Map<Character, Integer> map = new HashMap<>();
            int l = 0, r = 0;
            while (r < s.length()) {
                char c = s.charAt(r);
                Integer value = targetMap.get(c);
                if (value != null) {
                    if (Objects.equals(map.compute(c, (k, v) -> v == null ? 1 : v + 1), value)) {
                        invalid--;
                    }

                    while (l <= r && invalid == 0) {
                        if (statIdx == -1) {
                            statIdx = l;
                            minLen = r - l + 1;
                        }
                        if (r - l + 1 < minLen) {
                            statIdx = l;
                            minLen = r - l + 1;
                        }

                        c = s.charAt(l);
                        value = targetMap.get(c);
                        if (value != null) {
                            if (Objects.equals(value, map.get(c))) {
                                invalid++;
                            }
                            map.put(c, map.get(c) - 1);
                        }
                        l++;
                    }
                }
                r++;
            }

            return statIdx == -1 ? "" : s.substring(statIdx, statIdx + minLen);
        }
    }
}
