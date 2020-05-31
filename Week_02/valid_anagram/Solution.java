package com.leetecode.week2.valid_anagram;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author zhaodaming
 * @description:
 * @date 2020/5/30
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        return solution3(s, t);
    }

    private boolean solution1(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> cMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            cMap.put(s.charAt(i), cMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        if (cMap.keySet().size() != tMap.keySet().size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : cMap.entrySet()) {
            Character key = entry.getKey();
            Integer tValue = tMap.get(key);
            if (!Objects.equals(tValue, entry.getValue())) {
                return false;
            }
        }
        return true;
    }

    private boolean solution2(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        char[] carr = s.toCharArray();
        char[] tarr = t.toCharArray();
        Arrays.sort(carr);
        Arrays.sort(tarr);
        return Arrays.equals(carr, tarr);
    }
    private boolean solution3(String s, String t) {
        char BEGIN = 'a';
        if (s == null || t == null){
            return false;
        }
        if (s.length() != t.length()){
            return false;
        }
        int[] counter = new int[26];
        //26个字母,不用生成俩个后对比,可一个加一个减
        for (int i = 0; i < s.length(); i++) {
            counter[s.charAt(i) - BEGIN] ++;
            counter[t.charAt(i) - BEGIN] -- ;
        }
        for (int i : counter) {
            if (i!=0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(new Solution().isAnagram(s, t));
    }
}
