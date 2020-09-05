package com.learn.algorithmbase.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * ClassName: SelectSort
 * Description:
 * date: 2020/8/2 22:05
 *
 * @author seaxll
 * @since JDK 1.8
 */
public class SelectSort {

    public static int[] quickSort(int[] nums) {
        int smallestIndex;
        int smallest;
        for (int i = 0; i < nums.length; i++) {
            smallestIndex = i;
            smallest = nums[i];
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < smallest) {
                    smallestIndex = j;
                    smallest = nums[j];
                }
            }
            if (smallestIndex != i) {
                int temp = nums[i];
                nums[i] = nums[smallestIndex];
                nums[smallestIndex] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Random random = new Random();
        int[] nums = new int[random.nextInt(20)];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(50);
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(quickSort(nums)));
    }

}
