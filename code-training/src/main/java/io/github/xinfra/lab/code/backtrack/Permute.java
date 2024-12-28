package io.github.xinfra.lab.code.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            boolean[] visit = new boolean[nums.length];
            List<Integer> list = new ArrayList<>(nums.length);
            permute(nums, visit, list, 0);
            return res;
        }

        private void permute(int[] nums, boolean[] visit, List<Integer> list, int len) {
            if (len == nums.length) {
                res.add(new ArrayList<>(list));
            }

            for (int i = 0; i < nums.length; i++) {
                if (visit[i] == false) {
                    int value = nums[i];
                    list.add(value);
                    visit[i] = true;
                    permute(nums, visit, list, len + 1);
                    visit[i] = false;
                    list.remove(Integer.valueOf(value));
                }
            }
        }
    }

}
