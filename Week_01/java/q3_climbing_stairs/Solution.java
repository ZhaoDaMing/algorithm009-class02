package com.leetecode.week1.q3_climbing_stairs;

/**
 * @author zhaodaming
 * @description:
 * @date 2020/5/24
 */
class Solution {

    /**满足递归,爬到第n层楼梯的可能性为,n-1层的可能性+ n-2层的可能性.
     * f(n) = f(n - 1) + f(n - 2)
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (n < 4 ){
            return n;
        }
        int x = 1;
        int y = 2;
        for (int i = 2; i < n; i++) {
            int z = x + y;
            x = y;
            y = z;
        }
        return y;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }
}
