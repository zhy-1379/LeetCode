package com.learn.leetcode._416_partition_equal_subset_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/10/11 9:34
 *
 * @author zhy
 * @since JDK 1.8
 */
@SuppressWarnings("java:S3012")
public class Solution {
    // -1 失败
    // 0 继续 dsf
    // 1 成功
    private int statue = 0;

    // 超时
    public boolean canPartition1(int[] nums) {
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        dsf(0, new ArrayList<>(), sum / 2, nums);
        return statue == 1;
    }

    private void dsf(int curr, List<Integer> selected, int sum, int[] nums) {
        if (statue == 0) {
            if (sum == 0) {
                statue = 1;
                return;
            }

            if (curr == nums.length - 1) {
                return;
            }

            if (sum >= nums[curr]) {
                selected.add(nums[curr]);
                dsf(curr + 1, selected, sum - nums[curr], nums);
                selected.remove(selected.size() - 1);

                dsf(curr + 1, selected, sum, nums);
            }
        }
    }


    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return false;
        }
        int sum = 0;
        int maxNum = 0;
        for (int num : nums) {
            sum += num;
            maxNum = Math.max(maxNum, num);
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        if (maxNum > target) {
            return false;
        }
        // dp[i][j] 表示从数组的 [0,i] 下标范围内选取若干个正整数（可以是 0 个），是否存在一种选取方案使得被选取的正整数的和等于 j
        boolean[][] dp = new boolean[n][target + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        dp[0][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            for (int j = 1; j <= target; j++) {
                if (j >= num) {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - num];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n - 1][target];
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canPartition(new int[]{1,2,3,4,5,6,7}));
    }


}
