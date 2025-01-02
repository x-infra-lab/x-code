package io.github.xinfra.lab.code.backtrack;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class PermuteUnique {
   class Solution {
        private List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> permuteUnique(int[] nums) {
            LinkedList<Integer> list = new LinkedList<>();
            boolean[] visit = new boolean[nums.length];
            permuteUnique(nums, visit, list);
            return res;
        }

        private void permuteUnique(int[] nums, boolean[] visit, LinkedList<Integer> list) {
            if (list.size() == nums.length){
                res.add(new ArrayList<>(list));
                return;
            }

            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                int value = nums[i];
                if (visit[i] == false && !set.contains(value)){
                    list.add(value);
                    visit[i] = true;
                    set.add(value);
                    permuteUnique(nums, visit, list);
                    visit[i] = false;
                    // ps: remove last
                    list.removeLast();
                }
            }
        }
    }


}
