package com.leetecode.week1.q7_tree_sum;

import java.util.*;

/**
 * @author zhaodaming
 * @description:
 * @date 2020/5/24
 */
class Solution {
    class Node {
        public Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (x != node.x) return false;
            if (y != node.y) return false;
            return z == node.z;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            result = 31 * result + z;
            return result;
        }

        int x , y , z;
    }
    public List<List<Integer>> threeSum(int[] nums) {
        ArrayList<List<Integer>> result = new ArrayList<>();

        Set<Node> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if (nums[i] + nums[j] +nums[k] == 0){
                        Integer[] r = {nums[i], nums[j], nums[k]};
                        Arrays.sort(r);
                        List<Integer> e = Arrays.asList(r);
                        Node node = new Node(e.get(0), e.get(1), e.get(2));
                        if (!set.contains(node)){
                            set.add(node);
                            result.add(e);
                        }

                    }
                }
            }
        }
        return result;
    }
}
