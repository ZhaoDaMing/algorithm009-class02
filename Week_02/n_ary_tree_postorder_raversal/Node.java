package com.leetecode.week2.n_ary_tree_postorder_raversal;

import java.util.List;

/**
 * @author zhaodaming
 * @description:
 * @date 2020/5/31
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};