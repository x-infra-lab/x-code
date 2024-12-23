package io.github.xinfra.lab.code.arraylist;

public class LongestPalindrome {

    //https://leetcode.cn/problems/longest-palindromic-substring/


    class Solution {
        public String longestPalindrome(String s) {
            char[] chars = s.toCharArray();
            int[] dp = new int[chars.length];

            for (int i = 1; i < chars.length; i++) {
                dp[i] = 1;
            }

            int maxLength = 1;
            int startIdx = 0;
            for (int i = 1; i < chars.length; i++) {
                int prvIdx;
                if (dp[i - 1] == 1) {
                    prvIdx = i - 1;
                    if (prvIdx >= 0) {
                        if (chars[i] == chars[prvIdx]) {
                            dp[i] = dp[i - 1] + 1;
                        }
                    }
                } else {
                    prvIdx = i - dp[i - 1] - 1;
                    if (prvIdx >= 0) {
                        if (chars[i] == chars[prvIdx]) {
                            dp[i] = dp[i - 1] + 2;
                        }
                    }
                }

                if (dp[i] > maxLength) {
                    maxLength = dp[i];
                    startIdx = prvIdx;
                }
            }

            return s.substring(startIdx, maxLength);
        }
    }
}
