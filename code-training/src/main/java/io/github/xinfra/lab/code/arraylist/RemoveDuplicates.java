package io.github.xinfra.lab.code.arraylist;

public class RemoveDuplicates {

    //https://leetcode.cn/problems/remove-duplicates-from-sorted-array/

    class Solution {
        public int removeDuplicates(int[] nums) {
            if (nums.length == 1) {
                return 1;
            }
            int slow = 0;
            int fast = 1;
            while (fast < nums.length) {
                if (nums[slow] != nums[fast]) {
                    slow++;
                    if (slow != fast) {
                        nums[slow] = nums[fast];
                    }
                }
                fast++;
            }
            return slow + 1;
        }
    }
}
