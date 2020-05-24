package com.leetecode.week1.q5_container_with_most_water;

/**
 * @author zhaodaming
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * @date 2020/5/24
 */
public class Solution {
    public int maxArea(int[] height) {
        // return solution1(height);
        return solution2(height);
    }

    /**
     * 俩边夹逼的方法,wide * hight ,先让宽最大,面积大的话 高必须大才行
     * @param height
     * @return
     */
    private int solution2(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = getArea(height,l,r);
        //左，右边界 向中间靠近,寻找所有最大可能,小边界向里靠近
        while (l < r){
            if (height[l] < height[r]){
                l++;
                maxArea = Math.max(maxArea,getArea(height,l,r));
            }else if (height[l] >= height[r]){
                r--;
                maxArea = Math.max(maxArea,getArea(height,l,r));
            }
        }
        return maxArea;
    }

    public int getArea(int[] nums, int l ,int r){
        return Math.min(nums[l], nums[r]) * (r - l);
    }
    //暴力枚举,注意边界,时间复杂度为O(n^2)
    private int solution1(int[] height) {
        int maxArea = 0;
        //i代表左边界
        for (int i = 0; i < height.length - 1; i++) {
            //右边界大于左边
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i] , height[j]) * (j - i);
                maxArea = Math.max(area,maxArea);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] input = {1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution().maxArea(input));

    }
}
