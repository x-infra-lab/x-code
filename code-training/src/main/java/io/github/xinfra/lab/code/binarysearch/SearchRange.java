package io.github.xinfra.lab.code.binarysearch;

public class SearchRange {

    // https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/description/

    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = searchRangeLeft(nums, target);
            if (left >= nums.length || nums[left] != target) {
                return new int[]{-1, -1};
            }
            int right = searchRangeRight(nums, target);
            return new int[]{left, right};
        }

        public int searchRangeLeft(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    right = mid - 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
            return left;
        }

        public int searchRangeRight(int[] nums, int target) {
            int left = 0;
            int right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid - 1;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
            return right;
        }
    }


}
