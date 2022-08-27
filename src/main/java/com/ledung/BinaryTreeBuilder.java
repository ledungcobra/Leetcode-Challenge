package com.ledung;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeBuilder {
    public static TreeNode buildTree(int[] data) {
        if (data == null || data.length == 0) {
            return null;
        }
        var root = new TreeNode(data[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        for (int i = 1; i < data.length; i++) {
            int curNumber = data[i];
            var curNode = queue.peek();
            if (curNode.left == null) {
                curNode.left = new TreeNode(curNumber);
                queue.add(curNode.left);
            } else if (curNode.right == null) {
                curNode.right = new TreeNode(curNumber);
                queue.add(curNode.right);
            } else {
                queue.remove();
                i--;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        var root = buildTree(new int[]{1, 2, 3, 4});
        inorderTraversal(root);
    }

    public static void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }
        inorderTraversal(node.left);
        System.out.println(node.val);
        inorderTraversal(node.right);
    }
}
