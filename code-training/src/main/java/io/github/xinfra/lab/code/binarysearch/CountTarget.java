package io.github.xinfra.lab.code.binarysearch;

public class CountTarget {

//    class Solution {
//        public int countTarget(int[] scores, int target) {
//            int count = 0;
//            int left = 0;
//            int right = scores.length - 1;
//
//            while (left<=right){
//                int mid = (right-left)/ 2 + left;
//                if (scores[mid] == target){
//                    count++;
//                    int idx = mid;
//                    while (--idx >= 0 && scores[idx] == target){
//                        count++;
//                    }
//                    idx = mid;
//                    while (++idx < scores.length && scores[idx] == target){
//                        count++;
//                    }
//                    break;
//                }else if (scores[mid] > target){
//                    right=mid-1;
//                }else {
//                    left = mid+1;
//                }
//            }
//
//            return count;
//        }
//    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int value = solution.countTarget(
                new int[]{2, 2, 3, 4, 4, 4, 5, 6, 6, 8}, 4
        );
        System.out.println(value);
    }


   static class Solution {

        public int countTarget(int[] scores, int target) {
            int left = countTargetLeft(scores, target);
            if (left >= scores.length || scores[left]!= target){
                return 0;
            }
            int right = countTargetRight(scores, target);
            return right-left+1;
        }

        public int countTargetLeft(int[] scores, int target) {
            int left = 0;
            int right = scores.length - 1;

            while (left<=right){
                int mid = (right-left)/ 2 + left;
                if (scores[mid] == target){
                        right = mid - 1;
                }else if (scores[mid] > target){
                    right=mid-1;
                }else {
                    left = mid+1;
                }
            }
            return left;
        }

        public int countTargetRight(int[] scores, int target) {
            int left = 0;
            int right = scores.length - 1;

            while (left<=right){
                int mid = (right-left)/ 2 + left;
                if (scores[mid] == target){
                        left = mid + 1;
                }else if (scores[mid] > target){
                    right=mid-1;
                }else {
                    left = mid+1;
                }
            }
            return right;
        }
    }

}
