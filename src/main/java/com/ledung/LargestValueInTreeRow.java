package com.ledung;

import java.util.ArrayList;
import java.util.List;

public class LargestValueInTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        helper(root, output, 0);
        return output;
    }

    private void helper(TreeNode root, List<Integer> output, int level) {
        if (root == null) return;
        if (level == output.size()) {
            output.add(root.val);
        } else {
            output.set(level, Math.max(root.val, output.get(level)));
        }
        helper(root.left, output, level + 1);
        helper(root.right, output, level + 1);
    }
}
