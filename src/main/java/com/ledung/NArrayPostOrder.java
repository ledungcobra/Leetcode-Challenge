package com.ledung;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class NArrayBuilder {
    public static Node buildArray(List<Integer> values) {
        var root = new Node(values.get(0));
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        var index = 2;
        while (!queue.isEmpty() && index < values.size()) {
            var currNode = queue.remove();
            currNode.children = new ArrayList<>();
            while (index < values.size() && values.get(index) != null) {
                var node = new Node(values.get(index));
                currNode.children.add(node);
                queue.add(node);
                index++;
            }
            index++;
        }
        return root;
    }
}

public class NArrayPostOrder {
    public List<Integer> postorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        var result = new ArrayList<Integer>();
        if (root.children != null) {
            for (Node child : root.children) {
                result.addAll(postorder(child));
            }
        }

        result.add(root.val);
        return result;
    }

    public static void main(String[] args) {
        var arr = new ArrayList<Integer>();
        arr.add(1);
        arr.add(null);
        arr.add(3);
        arr.add(2);
        arr.add(4);
        arr.add(null);
        arr.add(5);
        arr.add(6);

        Node root = NArrayBuilder.buildArray(arr);
        System.out.println(root);

        System.out.println(new NArrayPostOrder().postorder(root));
    }
}
