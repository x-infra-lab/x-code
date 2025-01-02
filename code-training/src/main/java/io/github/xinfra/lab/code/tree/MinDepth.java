package io.github.xinfra.lab.code.tree;

import java.util.ArrayList;
import java.util.List;

public class MinDepth {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            List<TreeNode> list = new ArrayList<>();
            list.add(root);
            int depth = 1;
            while (!list.isEmpty()) {
                List<TreeNode> l = new ArrayList<>(list);
                list.clear();

                for (TreeNode node : l) {
                    if (node.left == null && node.right == null) {
                        return depth;
                    }
                    if (node.left != null) {
                        list.add(node.left);
                    }
                    if (node.right != null) {
                        list.add(node.right);
                    }
                }
                depth++;

            }
            return -1;
        }
    }

}
