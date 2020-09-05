package com.learn.leetcode._17_letter_ombinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description:
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * date: 2020/8/26 20:23
 *
 * @author seaxll
 * @since JDK 1.8
 */

class Solution {

    String[] phoneMap = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }
        iterStr(digits, "", 0);
        return res;
    }

    // 最终输出结果的list
    List<String> res = new ArrayList<>();

    /**
     * 递归函数：构造输入的 numStr 的第 numIndex 个数字字符对应的 resItem，其数量由 numStr 的长度决定
     *          每调用一次递归函数，resItem 添加一个字符
     * @param numStr    输入的数字串
     * @param resItem   结果的一项
     * @param numIndex  str中索引
     */
    void iterStr(String numStr, String resItem, int numIndex) {
        // 遍历到 numStr 的最后一个字符，终止递归
        if (numIndex == numStr.length()) {
            res.add(resItem);
            return;
        }
        // 获取 numStr 的第 numIndex 个数字字符
        char c = numStr.charAt(numIndex);
        // phoneMap 的下表是从0开始一直到9， c-'0' 就可以取到相对的数组下标位置
        // 比如 c = 2 时候，2 - '0'，获取下标为 2, phoneMap[2] 就是 "abc"
        int pos = c - '0';
        String phoneItem = phoneMap[pos];
        // 遍历 phoneItem 字符串中的每一个字符，完善 resItem 的构造
        for (int i = 0; i < phoneItem.length(); i++) {
            // 调用下一层递归
            iterStr(numStr, resItem + phoneItem.charAt(i), numIndex + 1);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<String> strings = solution.letterCombinations("24");
        System.out.println(strings);
    }

}
