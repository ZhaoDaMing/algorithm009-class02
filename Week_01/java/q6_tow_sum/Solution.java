package com.leetecode.week1.q6_tow_sum;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author zhaodaming
 * @description:
 * @date 2020/5/24
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        // return solution1(nums,target);
        return solution2(nums, target);
    }

    private int[] solution2(int[] nums, int target) {
        HashMap<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //如果cache中包含元素,则返回
            int v = target - nums[i];
            if (cache.containsKey(v)) {
                return new int[]{cache.get(v), i};
            }
            //map中记录数据,快速检索
            cache.put(nums[i], i);
        }
        return null;
    }

    /**
     * 外循环和内需换边界可优,组合时 内循环下标规则
     *
     * @param nums
     * @param target
     * @return
     */
    private int[] solution1(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return null;
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(new Solution().twoSum(nums, 9)));
    }
}
