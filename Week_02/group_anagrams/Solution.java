package com.leetecode.week2.group_anagrams;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author zhaodaming
 * @description:
 * @date 2020/5/30
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        final Character BEGIN = 'a';
        HashMap<String, List<String>> strMap = new HashMap<>();
        for (String str : strs) {
            int length = str.length();
            int[] keyArr = new int[26];
            for (int i = 0; i < length; i++) {
                keyArr[str.charAt(i) - BEGIN]++;
            }
            String key = Arrays.toString(keyArr);
            List<String> value = strMap.getOrDefault(key, new ArrayList<String>());
            value.add(str);
            strMap.put(key,value);
        }
        return strMap.values().stream().collect(Collectors.toList());
    }
}
