package com.leetecode.week1.q4_move_zeroes;

/**
 * @author 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * @description:
 * @date 2020/5/24
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        //solution1(nums);
        solution2(nums);
    }

    private void solution1(int[] nums){
        if(nums == null || nums.length < 0){
            return;
        }
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[j] = nums[i];
                if (i != j){
                    //画图丽姐
                    nums[i] = 0;
                }
                j++;
            }
            //num[i] == 0,拿后面非0元素跟其替换,j记录
        }
    }

    //第一反应想到的
    private void solution2(int[] nums){
        if(nums == null || nums.length < 0){
            return;
        }

        int insertPos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[insertPos ++] = nums[i];
            }
        }

        for (int i = insertPos; i < nums.length; i++) {
            nums[i] = 0;
        }

    }
}
