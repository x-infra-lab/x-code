package io.github.xinfra.lab.code.dp;

import java.util.Arrays;

public class CoinChange {
    // https://leetcode.cn/problems/coin-change/


    class Solution {
        public int coinChange(int[] coins, int amount) {
            int dp[] = new int[amount + 1];
            Arrays.fill(dp, -1);
            dp[0] = 0;

            for (int i = 1; i <= amount; i++) {
                int min = -1;
                for (int coin : coins) {
                    if (i - coin >= 0 && dp[i - coin] != -1) {
                        if (min == -1) {
                            min = dp[i - coin];
                        } else {
                            min = Math.min(min, dp[i - coin]);
                        }
                        dp[i] = min + 1;
                    }
                }
            }

            return dp[amount];
        }
    }
}
