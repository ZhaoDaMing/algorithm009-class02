package com.leetecode.week2.n_ary_tree_postorder_raversal;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution2 {
    private List<Integer> list = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        //travelNode(root);
        travelNodeWithIter(root);
        return list;
    }

    public List<Integer> postOrderTraversal(TreeNode root) {
        if (root == null){
            return list;
        }
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            while (cur != null){
                stack.push(cur);
                cur = cur.right;
            }
            cur = stack.pop();
            list.add(cur.val);
        }

        //后续遍历
        return list;
    }
    public void travelNodeWithIter(TreeNode root){
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur !=null || !stack.isEmpty()){
            //左节点主要存在就一直放到栈中
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }
    }



    /**
     * 递归
     * @param root
     */
    public void travelNode(TreeNode root){
        if (root == null){
            return ;
        }
        inorderTraversal(root.left);
        list.add(root.val);
        inorderTraversal(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        System.out.println(new Solution2().postOrderTraversal(root));
    }

}