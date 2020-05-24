package com.leetecode.week1.q1_fibonacci;

import java.util.HashMap;
import java.util.Map;

/**
 * The Tribonacci sequence Tn is defined as follows:
 *
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 *
 * Given n, return the value of Tn.
 */
public class Solution {
    /**
     * Solution2 用到的缓存
     */
    private HashMap<Integer, Integer> cache = new HashMap<>();

    public int tribonacci(int n) {
        //return solution1(n);
        return solution2(n);
    }

    /**
     * 去除数组的n空间,单纯变量保存前三个数
     * @param n
     * @return
     */
    public int solution4(int n) {
        int[] pre = {0,1,1};
        if (n < 3) {
            return pre[n];
        }

        for (int i = 3; i <= n; i++) {
            int newV = pre[0] + pre[1] + pre[2];
            pre[0] = pre[1];
            pre[1] = pre[2];
            pre[2] = newV;
        }
        return pre[2];
    }
    /**
     * 3.动态规划?暂时不清楚这个为何叫动态规划.数据方式,空间复杂度n ,时间复杂度n
     * @param n
     * @return
     */
    public int solution3(int n) {
        int[] cache = new int[n + 1];
        if (n < 3){
            cache = new int[3];
        }else {
           cache  = new int[n + 1];
        }
        cache[0] = 0;
        cache[1] = 1;
        cache[2] = 1;
        if (n < 3) {
            return cache[n];
        }
        for (int i = 3; i <= n; i++) {
            cache[i] = cache[i - 1] + cache[i - 2] + cache[i - 3];
        }
        return cache[n];

    }
    
    /**
     * 2.递归优化,去除递归中重复运算,缓存计算结果,map的方式比数组占用空间大,且递归方法调用,时间复杂度为n
     * @param n
     * @return
     */
    public int solution2(int n){
        if (n < 1){
            return 0;
        }else if (n == 1){
            return 1;
        }else if( n == 2){
            return 1;
        }else {
            Integer v = cache.get(n);
            if (v != null){
                return v;
            }
            int r = solution2(n - 1) + solution2(n - 2) + solution2(n - 3);
            cache.put(n,r);
            return r;
        }
    }

    /**
     * 1.基本递归,时间复杂度为指数,因为递归树
     * @param n
     * @return
     */
    public int solution1(int n){
        if (n < 1){
            return 0;
        }else if (n == 1){
            return 1;
        }else if( n == 2){
            return 1;
        }else {
            return tribonacci(n -1 ) + tribonacci(n-2) + tribonacci(n - 3);
        }
    }


    public static void main(String[] args) {
        Solution q = new Solution();
        System.out.println(q.tribonacci(25));
    }
}
