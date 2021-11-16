package com.ilovealt.leetcode.valid_anagram_242;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 *  数据范围、前提条件和边界条件：s和t仅包含小写字母；两个字符串都不为空或null
 *  总结：
 */
public class Solution {

    /**
     *  排序
     *  解题思路：对s和t进行排序，再比对；
     *  时间复杂度：O(n*logn + n) 最终等于 O(n*logn)
     *  空间复杂度: 排序是需要O(logn)
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        //排序 时间复杂度 n*logn
        Arrays.sort(chars);
        Arrays.sort(chart);
        //对比 时间复杂度 n
        return Arrays.equals(chars, chart);
    }

    /**
     *  使用数组，使用26字母的字符, 重复个数 = 数组[字符-‘a’],
     *  解题思路：把s字符重复次数保存到数组中，然后使用t再进行比对
     *  时间复杂度：O(n) n为s的长度
     *  空间复杂度: O(S),其中 SS 为字符集大小，此处 S=26;
     */
    public boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        //
        int[] table = new int[26];
        for (int i = 0; i < s.length(); i++) {
            table[s.charAt(i)-'a']++;
        }
        //
        for (int i = 0; i < t.length(); i++) {
            table[t.charAt(i)-'a']--;
            if (table[t.charAt(i)-'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     *   Map，保存 字符和对应的出现次数
     *  解题思路：s中字符出现次数，t进行比对
     *  时间复杂度： O(n) s的长度
     *  空间复杂度: O(n) s的长度
     */
    public boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        //
        Map<Character, Integer> map = new HashMap<>(s.length());
        //s
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            map.put(c,  map.getOrDefault(c, 0) + 1);
        }
        //t
        for (int i = 0; i < t.length(); i++) {
            Character c = t.charAt(i);
            map.put(c, map.getOrDefault(c, 0) - 1);
            if (map.get(c) < 0) {
                return false;
            }
        }
        return true;
    }


}
