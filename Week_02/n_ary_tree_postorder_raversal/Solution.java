package com.leetecode.week2.n_ary_tree_postorder_raversal;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaodaming
 * @description:
 * @date 2020/5/31
 */
class Solution {
    private List<Integer> result = new ArrayList();
    public List<Integer> postorder(Node root) {
        travelNode(root);
        return result;
    }

    private void travelNode(Node root){
        if (root == null){
            return;
        }
        for (Node child : root.children) {
            postorder(child);
        }
        result.add(root.val);
    }
}
