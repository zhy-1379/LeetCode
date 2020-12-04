package com.learn.leetcode._347_top_k_frequent_elements;

import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;

/**
 * ClassName: Solution
 * Description:
 *      https://leetcode-cn.com/problems/top-k-frequent-elements/solution/qian-k-ge-gao-pin-yuan-su-by-leetcode-solution/
 *
 * date: 2020/9/7 21:25
 *
 * @author zhy
 * @since JDK 1.8
 */
public class Solution {
    private Random random = new SecureRandom();


    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        Map<Integer, Integer> numMap = new HashMap<>();
        Arrays.stream(nums).forEach(num -> numMap.put(num, numMap.getOrDefault(num, 0) + 1));
        List<Map.Entry<Integer, Integer>> collect = numMap.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .collect(Collectors.toList());
        for (int i = 0; i < k; i++) {
            res[i] = collect.get(i).getKey();
        }
        return res;
    }


    // region 快速排序
    public int[] topKFrequentBasedQuickSort(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }

        List<int[]> values = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            values.add(new int[]{num, count});
        }
        int[] ret = new int[k];
        quickSort(values, 0, values.size() - 1, ret, 0, k);
        return ret;
    }

    public void quickSort(List<int[]> values, int start, int end, int[] ret, int retIndex, int k) {
        int picked = (random.nextInt() * (end - start + 1)) + start;
        Collections.swap(values, picked, start);

        int pivot = values.get(start)[1];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (values.get(i)[1] >= pivot) {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, start, index);

        if (k <= index - start) {
            quickSort(values, start, index - 1, ret, retIndex, k);
        } else {
            for (int i = start; i <= index; i++) {
                ret[retIndex++] = values.get(i)[0];
            }
            if (k > index - start + 1) {
                quickSort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
            }
        }
    }
    // endregion



    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println(Arrays.toString(ints));
    }

}
