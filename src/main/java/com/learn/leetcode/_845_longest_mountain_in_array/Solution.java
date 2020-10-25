package com.learn.leetcode._845_longest_mountain_in_array;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/10/25 8:47
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {

    public int longestMountain(int[] A) {
        int maxHeight = 0;
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
                int left = 2;
                while (i - left >= 0 && A[i - left] < A[i - left + 1]) {
                    left ++;
                }
                int right = 2;
                while (i + right < A.length && A[i + right - 1] > A[i + right]) {
                    right++;
                }
                // left 和 right 比实际多1; 加上中间一个数, 减去 2, 故减一
                maxHeight = Math.max(maxHeight, left + right - 1);
            }
        }
        return maxHeight;
    }

    // region 左右相等解法
    // public int longestMountain(int[] A) {
    //     int maxHeight = 0;
    //     for (int i = 2; i < A.length - 1; i++) {
    //         if (A[i - 1] < A[i] && A[i] > A[i + 1]) {
    //             int height = 2;
    //             while (i - height >= 0 && i + height < A.length
    //                     && A[i - height] < A[i - height + 1]
    //                     && A[i + height - 1] > A[i + height]) {
    //                 height ++;
    //             }
    //             maxHeight = Math.max(maxHeight, height);
    //         }
    //     }
    //     return maxHeight != 0 ? (2 * maxHeight - 1) : 0;
    //     // return maxHeight != 0 ? (2 * (maxHeight - 1) + 1) : 0;
    // }
    // endregion

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
        System.out.println(solution.longestMountain(new int[]{0,1,0}));
    }

}
