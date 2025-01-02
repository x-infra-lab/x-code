package io.github.xinfra.lab.code.dp;

public class ClimbStairs {

    // https://leetcode.cn/problems/climbing-stairs/
    class Solution {
        public int climbStairs(int n) {
            if (n < 3) {
                return n;
            }
            int dp_1 = 2;
            int dp_2 = 1;

            int dp_i = 0;
            for (int i = 3; i <= n; i++) {
                dp_i = (dp_1) + (dp_2);


                dp_2 = dp_1;
                dp_1 = dp_i;

            }

            return dp_i;
        }
    }
}
