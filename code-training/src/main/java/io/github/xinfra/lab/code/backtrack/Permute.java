package io.github.xinfra.lab.code.backtrack;

import java.util.ArrayList;
import java.util.List;

public class Permute {

    class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> permute(int[] nums) {
            boolean[] visit = new boolean[nums.length];
            List<Integer> list = new ArrayList<>(nums.length);
            permute(nums, visit, list);
            return res;
        }

        private void permute(int[] nums, boolean[] visit, List<Integer> list) {
            if (list.size() == nums.length) {
                res.add(new ArrayList<>(list));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (visit[i] == false) {
                    int value = nums[i];
                    list.add(value);
                    visit[i] = true;
                    permute(nums, visit, list);
                    visit[i] = false;
                    list.remove(Integer.valueOf(value));
                }
            }
        }
    }

}
