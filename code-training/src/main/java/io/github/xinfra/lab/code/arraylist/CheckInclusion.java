package io.github.xinfra.lab.code.arraylist;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CheckInclusion {


    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            if (s1.length() > s2.length()) {
                return false;
            }
            Map<Character, Integer> targetMap = new HashMap<>();
            for (char c : s1.toCharArray()) {
                targetMap.compute(c, (k, v) -> v == null ? 1 : v + 1);
            }
            Map<Character, Integer> map = new HashMap<>();
            int valid = 0;
            int left = 0;
            int  right = 0;
            while (right < s2.length()) {
                char rChar = s2.charAt(right);
                if (!targetMap.containsKey(rChar)) {
                    left = right + 1;
                    map.clear();
                    valid = 0;
                } else {
                    Integer value = map.compute(rChar, (k, v) -> v == null ? 1 : v + 1);
                    if (Objects.equals(targetMap.get(rChar), value)) {
                        valid++;
                        if (valid == targetMap.keySet().size()) {
                            return true;
                        }
                    }
                    while (map.get(rChar) > targetMap.get(rChar)){
                        char lChar = s2.charAt(left);
                        if (Objects.equals(map.get(lChar), targetMap.get(lChar))) {
                            valid--;
                        }
                        map.put(lChar, map.get(lChar)-1);
                        left++;
                    }
                }
                right++;
            }

            return false;
        }
    }


}
