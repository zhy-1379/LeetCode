package com.learn.leetcode._18_4sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/10/5 9:43
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    @SuppressWarnings("java:S135")
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return quadruplets;
        }
        // 排序, 以便更方便的去重
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 3; i++) {
            // 处理重复值：已经选取过这个数作为第一个数
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // region 剪枝
            // 从 i 开始选择的四个最小数的和已经大于 target
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                // 因为 nums 是递增的, 第一个数选择 i 或者 i + 1 都不可能满足条件; 故使用 break
                break;
            }
            // 从 i 开始选择的四个最大的数的和小于 target
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                // 因为 nums 是递增的, 第一个数选择 i 不能满足条件, 但是第一个数选择比 i 大的数可能满足条件; 故使用 continue
                continue;
            }
            // endregion

            for (int j = i + 1; j < length - 2; j++) {
                // 处理重复值：前一个数已经选取过这个数作为第二个数
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                // region 剪枝
                // 已经选择的数加上之后能选择的最小的数的和大于 target
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                // 已经选择的数加上之后能选择的最大的数的和小于 target
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                // endregion

                // region 四层循环
                // for (int k = j + 1; k < length - 1; k++) {
                //     if (k > j + 1 && nums[k] == nums[k - 1]) {
                //         continue;
                //     }
                //
                //     if (nums[i] + nums[j] + nums[k] + nums[k + 1] > target) {
                //         break;
                //     }
                //
                //     if (nums[i] + nums[j] + nums[k] + nums[length - 1] < target) {
                //         continue;
                //     }
                //
                //     for (int l = k + 1; l < length; l++) {
                //         if (l > k + 1 && nums[l] == nums[l - 1]) {
                //             continue;
                //         }
                //
                //         if (nums[i] + nums[j] + nums[k] + nums[l] == target) {
                //             quadruplets.add(Arrays.asList(nums[i], nums[j], nums[k], nums[l]));
                //         }
                //
                //     }
                // }
                // endregion

                // region 双指针去掉一层循环
                // 已经选择了两个数, 使用双指针减少一层循环, nums[left] + nums[right] = target - nums[i] + nums[j] = 定值
                int left = j + 1;       // 左值（小值）
                int right = length - 1; // 右值（大值）
                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        // 遇到重复的左值, 通通跳过
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // 更新左指针, 同时之后也需要更新右指针, 因为 nums[left] + nums[right] = 定值
                        left++;
                        // 遇到重复的右值, 通通跳过
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        // 更新右指针, 因为 nums[left] + nums[right] = 定值
                        right--;
                    } else if (sum < target) {
                        // 和小于 target, 左指针右移, 换个大点的数
                        left++;
                    } else {
                        // 和大于 target, 右指针左移, 换个小点的数
                        right--;
                    }
                }
                // endregion

            }
        }
        return quadruplets;
    }
}
