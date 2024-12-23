package io.github.xinfra.lab.code.arraylist;

public class LongestPalindrome {

    //https://leetcode.cn/problems/longest-palindromic-substring/


    // dp
//    class Solution {
//        public String longestPalindrome(String s) {
//            // todo
//            return null;
//        }
//    }

 class Solution {
        public String longestPalindrome(String s) {
            char[] charArray = s.toCharArray();
            int maxLen = 1;
            int startIdx = 0;
            for (int i = 0; i < charArray.length; i++) {
                int l1 = longestPalindrome(charArray, i, i);
                int l2 = longestPalindrome(charArray, i, i + 1);
                int l = Math.max(l1, l2);
                if (l > maxLen) {
                    maxLen = l;
                    if (l % 2 == 0) {
                        startIdx = i - l / 2 + 1;
                    } else {
                        startIdx = i - l / 2;
                    }
                }
            }

            return s.substring(startIdx, startIdx + maxLen);
        }

        private int longestPalindrome(char[] charArray, int l, int r) {
            int len = 0;
            while (l >= 0 && r < charArray.length) {
                if (charArray[l] != charArray[r]) {
                    break;
                }
                len = r - l + 1;
                l--;
                r++;
            }
            return len;
        }
    }
}
