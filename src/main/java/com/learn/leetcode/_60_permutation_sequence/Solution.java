package com.learn.leetcode._60_permutation_sequence;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: Solution
 * Description:
 *      https://leetcode-cn.com/problems/permutation-sequence/
 *
 * date: 2020/9/5 21:07
 *
 * @author seaxll
 * @since JDK 1.8
 */
public class Solution {

    private List<Integer> nums = new ArrayList<>();

    /**
     * 数学 + 递归 思维
     * 结果是 n 位字符串，根据数学特性计算每一位的值。
     * 共有 n! 种排列，按照大小顺序排列后 =>
     *  1）先将 n 个数字分为 第一位数字为 1、2、3...n 的 n 组
     *  2）每一组再把剩下的数字排列成 (n - 1)!个排列
     *
     *  如：n = 3：
     *  123
     *  132
     *  213
     *  231
     *  312
     *  321
     *
     *  因此，计算问题答案时，可以同样将排列分组，总数为 total；共 total! 个排列，n = total， k = k -1；（排列从 第 0 个开始）
     *  计算第 1 位数字时，前面的 1 - 1 位已经确定，将剩余的数字按大小排列为一个列表，供选择的排列有 n! 个，按照首位分为 n 个分组，每组 (n - 1)!个排列，且前面1位相同。
     *      则第 k 个排列在第 k / (n - 1)! 个分组，值为列表的第 k / (n - 1)! 个数字。余下的位数在 n - 1 个数字 中查找第k % (n - 1)!个排列，更新n 为 n -1 k 为 k % (n - 1)!
     *  ......
     *  计算第 i 位数字时，前面的 i-1 位已经确定，将剩余的数字按照大小排列为一个列表，供选择的排列有 n! 个，按照首位分为 n 个分组，每组 (n - 1)!个排列，且前面1位相同。
     *      则第 k 个排列在第 k / (n - 1)! 个分组，值为列表的第 k / (n - 1)! 个数字。余下的位数在 n - 1 个数字 中查找第k % (n - 1)!个排列，更新n 为 n -1 k 为 k % (n - 1)!
     *  ......
     *  计算第 total 位数字时，只有一位数字可选，直接加入。
     */
    public String getPermutation(int n, int k) {
        for (int i = 1; i <= n; i ++) {
            nums.add(i);
        }

        return find("", n ,k - 1);
    }

    private String find(String s, int n, int k) {
        if (n == 1) {
            s = s + nums.get(0);
        } else if (n > 1) {
            int stratum = stratum(n - 1);
            Integer integer = nums.get(k / stratum);
            nums.remove(k / stratum);
            s =  find(s + integer, n - 1 , k % stratum);
        }
        return s;
    }

    /**
     * 计算阶层
     * @param n 输入整数
     * @return n 的阶层
     */
    private int stratum(int n) {
        int stratum = 1;
        while (n > 0) {
            stratum *= n--;
        }
        return stratum;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.stratum(4));
        System.out.println(solution.getPermutation(3, 3));

    }

}
