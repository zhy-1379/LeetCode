package com.learn.leetcode.magicindexlcci;

import com.learn.algorithmbase.sort.QuickSort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;

/**
 * ClassName: MagicIndexLcci
 * Description:
 * 魔术索引
 * 在数组A[0...n-1]中，有所谓的魔术索引，满足条件A[i] = i。给定一个有序整数数组，编写一种方法找出魔术索引，
 * 若有的话，在数组A中找出一个魔术索引，如果没有，则返回-1。若有多个魔术索引，返回索引值最小的一个。
 *
 *
 * date: 2020/7/31 22:23
 *
 * @author seaxll
 * @since JDK 1.8
 */
public class MagicIndexLcci {
    private static Logger logger = LoggerFactory.getLogger(MagicIndexLcci.class);

    public static void main(String[] args) {
        Solution solution = new Solution();
        Random random = new Random();
        int[] nums = new int[random.nextInt(100)];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(100);
        }
        QuickSort.quickSort(nums);
        String nums_str = Arrays.toString(nums);
        logger.info("暴力算法得到数组 {}的魔术索引为 {}", nums_str, solution.findMagicIndex1(nums));
        logger.info("二分查找得到数组 {}的魔术索引为 {}", nums_str, solution.findMagicIndex2(nums));
    }
}
