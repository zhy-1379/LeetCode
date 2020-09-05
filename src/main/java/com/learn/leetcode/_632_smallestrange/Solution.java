package com.learn.leetcode._632_smallestrange;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * ClassName: Solution
 * Description:
 * date: 2020/8/1 10:54
 *
 * @author seaxll
 * @since JDK 1.8
 */
class Solution {

    public int[] smallestRange(List<List<Integer>> nums) {
        int rangeLeft = 0;
        int rangeRight = Integer.MAX_VALUE;
        int minRange = rangeRight - rangeLeft;
        int max = Integer.MIN_VALUE;
        int size = nums.size();
        int[] next = new int[size];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(index -> nums.get(index).get(next[index])));
        for (int i = 0; i < size; i++) {
            priorityQueue.offer(i);
            max = Math.max(max, nums.get(i).get(0));
        }
        while (true) {
            Integer integer = priorityQueue.poll();
            int minIndex = integer == null ? 0 : integer;
            int curRange = max - nums.get(minIndex).get(next[minIndex]);
            if (curRange < minRange) {
                minRange = curRange;
                rangeLeft = nums.get(minIndex).get(next[minIndex]);
                rangeRight = max;
            }
            next[minIndex]++;
            if (next[minIndex] == nums.get(minIndex).size()) {
                break;
            }
            priorityQueue.offer(minIndex);
            max = Math.max(max, nums.get(minIndex).get(next[minIndex]));
        }
        return new int[]{rangeLeft, rangeRight};
    }

    public int[] smallestRange2(List<List<Integer>> nums) {
        int k = nums.size();
        int[] res = new int[2];
        boolean hasEmpty = false;// 逻辑标志位，表示nums中是否有为空的list

        while (!hasEmpty) {// 当不存在非空list时，执行循环逻辑
            int min = nums.get(0).get(0);// 假定min为nums中第一个列表的第一个元素
            int max = nums.get(0).get(0);// 假定max为nums中第一个列表的第一个元素
            // 下面的逻辑比较重要，第一版代码中，我是使用一个int变量存储了nums中min首次出现的索引，这样当多个列表的第一个元素等于min时，会导致相同的逻辑多次执行，时间复杂度太高，最终提交的时候超出时间限制
            List<Integer> minidxs = new ArrayList();// 用于存储nums中第一个元素等于min的所有索引，这样每次会将第一个元素等于min的list都处理一遍

            for (int i = 0; i < k; i++) {
                if (nums.get(i).get(0) < min) {
                    // min值发生变更
                    min = nums.get(i).get(0);
                    // 需要清空原来的minidxs
                    minidxs.clear();
                    // 将索引加入到minidxs
                    minidxs.add(i);
                } else if (nums.get(i).get(0) == min) {
                    // min不是第一次出现，需要记录第一个元素是min的list在nums中的索引，方便后续处理，降低时间复杂度
                    minidxs.add(i);
                }
                // max的值无需特殊处理
                max = Math.max(max, nums.get(i).get(0));
            }

            // res[0] == res[1] == 0,表示是第一次处理，返回值res的值是默认值，直接赋值
            if ((res[0] == 0 && res[1] == 0)
                    || (max - min < res[1] - res[0] || (max - min == res[1] - res[0] && min < res[0]))) {
                res[0] = min;
                res[1] = max;
            }
            // 遍历minidxs，删除对应的list的第一个元素
            for (Integer minidx : minidxs) {
                // 首先确保对应索引下的list的size要大于0，防止空指针
                while (nums.get(minidx).size() > 0 && nums.get(minidx).get(0) == min) {
                    nums.get(minidx).remove(0);
                }
                // 当存在指定下标的list移除值为min之后为空集合，将标志位hasEmpty设置成true，终止循环
                if (nums.get(minidx).size() == 0) {
                    hasEmpty = true;
                    break;
                }
            }
        }
        return res;
    }

}
