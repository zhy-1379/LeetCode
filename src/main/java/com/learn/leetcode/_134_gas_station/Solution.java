package com.learn.leetcode._134_gas_station;

import java.util.stream.IntStream;

/**
 * ClassName: Solution
 * Description:
 * data: 2020/11/18 20:23
 *
 * @author zhy
 * @version 1.0
 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (IntStream.of(gas).sum() < IntStream.of(cost).sum()) {
            return -1;
        }

        int len = gas.length;
        for (int startIdx = 0; startIdx < len; startIdx++) {
            boolean successful = true;
            int gasHad = 0;
            for (int i = 0; i < len; i++) {
                // 加油
                gasHad += gas[(startIdx + i) % len];
                // 向前走,耗油
                gasHad -= cost[(startIdx + i) % len];
                // 油不够
                if (gasHad < 0) {
                    successful = false;
                    break;
                }
            }
            if (successful) {
                return startIdx;
            }

            gasHad = 0;
            successful = true;
            for (int i = 0; i < len; i++) {
                // 加油
                gasHad += gas[(startIdx - i + len) % len];
                // 向后走,耗油
                gasHad -= cost[(startIdx - i - 1 + len) % len];
                // 油不够
                if (gasHad < 0) {
                    successful = false;
                    break;
                }
            }
            if (successful) {
                return startIdx;
            }

        }
        return -1;
    }
}
