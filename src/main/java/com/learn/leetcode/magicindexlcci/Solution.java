package com.learn.leetcode.magicindexlcci;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/7/31 22:24
 *
 * @author seaxll
 * @since JDK 1.8
 */
public class Solution {
    // region 暴力破解
    public int findMagicIndex1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == i) {
                return i;
            }
        }
        return -1;
    }
    // endregion

    // region 二分查找
    public int findMagicIndex2(int[] nums) {
        return getAnswer(nums, 0, nums.length - 1);
    }

    private int getAnswer(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (right - left) / 2 + left;
        int leftAnswer = getAnswer(nums, left, mid - 1);
        if (leftAnswer != -1) {
            return leftAnswer;
        } else if (nums[mid] == mid) {
            return mid;
        }
        return getAnswer(nums, mid + 1, right);
    }
    // endregion

}
