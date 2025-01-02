package io.github.xinfra.lab.code.arraylist;

public class TwoSum {

    // https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/

    class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int left = 0, right = numbers.length - 1;
            while (left < right) {
                int tmp = numbers[left] + numbers[right];
                if (tmp > target) {
                    right--;
                } else if (tmp < target) {
                    left++;
                } else {
                    return new int[]{left + 1, right + 1};
                }
            }

            return null;
        }
    }

}
