package io.github.xinfra.lab.code.arraylist;

public class MoveZeroes {
    // https://leetcode.cn/problems/move-zeroes/

    class Solution {
        public void moveZeroes(int[] nums) {

            int slow = 0, fast = 0;
            while (fast < nums.length) {
                if (nums[fast] != 0) {
                    nums[slow] = nums[fast];
                    slow++;
                }
                fast++;
            }
            for (int i = slow; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }

}
