package com.learn.leetcode._632_smallestrange;

import com.learn.algorithmbase.sort.QuickSort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * ClassName: SmallestRange
 * Description:
 * 最小区间
 *  有 k 个升序排列的整数数组。找到一个最小区间，使得 k 个列表中的每个列表至少有一个数包含在其中。
 *  我们定义如果 b-a < d-c 或者在 b-a == d-c 时 a < c，则区间 [a,b] 比 [c,d] 小。
 *
 * 示例：
 *  输入:[[4,10,15,24,26], [0,9,12,20], [5,18,22,30]]
 *  输出: [20,24]
 *  解释:
 *  列表 1：[4, 10, 15, 24, 26]，24 在区间 [20,24] 中。
 *  列表 2：[0, 9, 12, 20]，20 在区间 [20,24] 中。
 *  列表 3：[5, 18, 22, 30]，22 在区间 [20,24] 中。
 *
 * date: 2020/8/1 10:51
 *
 * @author seaxll
 * @since JDK 1.8
 */
public class SmallestRange {
    private static Logger logger = LoggerFactory.getLogger(SmallestRange.class);

    public static void main(String[] args) {
        Random random = new SecureRandom();
        List<List<Integer>> nums = new ArrayList<>();
        for (int i = 0; i < random.nextInt(20) + 1; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < random.nextInt(20) + 1; j++) {
                list.add(random.nextInt(100));
            }
            QuickSort.quickSort(list);
            nums.add(list);
            logger.info("第{}个列表为：{}", i + 1, list);
        }

        Solution solution = new Solution();
        int[] results = solution.smallestRange(nums);
        logger.info("计算出的最小区间为：[{},{}]", results[0], results[1]);
    }
}
