package com.leetecode.week1.q2_valid_palindrome;

/**
 * @author zhaodaming
 * @description:
 * @date 2020/5/24
 */
public class Solution {
    public boolean isPalindrome(String s) {
       return solution2(s);
    }

    public boolean solution2(String s){
        String filterdS = filterNoNumberStr(s);
        char[] chars = filterdS.toCharArray();
        for (int i = 0; i < chars.length/2 ; i++) {
            if (Character.toUpperCase(chars[i]) != Character.toUpperCase(chars[chars.length - i -1]) ){
                return false;
            }
        }
        return true;
    }

    /**
     * Top-Down 的方式,like newspaper,先写出主干,在逐个写细节
     * @param s
     * @return
     */
    public boolean solution1(String s){
        String filterdS = filterNoNumberStr(s);
        String reversedStr  = reverseStr(filterdS);
        return filterdS.equalsIgnoreCase(reversedStr);
    }

    private String reverseStr(String filterdS) {
        return new StringBuilder(filterdS).reverse().toString();
    }

    private String filterNoNumberStr(String s) {
        char[] chars = s.toCharArray();
        StringBuilder result = new StringBuilder();
        for (char c : chars) {
            if (Character.isLetterOrDigit(c)){
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String input = "a21,2A ";
        System.out.println(new Solution().isPalindrome(input));
    }
}
