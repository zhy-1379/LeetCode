package com.learn.leetcode._486_predict_the_winner;

/**
 * ClassName: Solution
 * Description:
 * https://leetcode-cn.com/problems/predict-the-winner/
 * <p>
 * date: 2020/9/1 20:30
 *
 * @author seaxll
 * @since JDK 1.8
 */
public class Solution {
    int[] nums;

    public boolean predictTheWinner(int[] nums) {
        this.nums = nums;
        int i = maxGrade(0, nums.length - 1, 1);
        System.out.println(i);
        return i >= 0;
    }

    /**
     *
     * @param start 剩余分数的开始索引
     * @param end   神域分数的借宿索引
     * @param reversal  系数  先手 为 1；后手为 -1
     * @return  在 start 和 end 区间 先手 能获得的最大分数
     */
    public int maxGrade(int start, int end, int reversal) {
        if (start == end) {
            return nums[start] * reversal;
        }
        int gradeChooseStart = nums[start] * reversal + maxGrade(start + 1, end, -reversal);
        int gradeChooseEnd = nums[end] * reversal + maxGrade(start, end - 1, -reversal);
        if (reversal == 1) {
            return Math.max(gradeChooseStart, gradeChooseEnd);
        } else {
            return Math.min(gradeChooseStart, gradeChooseEnd);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.predictTheWinner(new int[]{1, 5, 233, 7}));
        System.out.println(solution.predictTheWinner(new int[]{1, 5, 2}));
    }

}
