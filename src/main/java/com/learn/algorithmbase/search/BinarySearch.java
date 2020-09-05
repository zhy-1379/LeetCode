package com.learn.algorithmbase.search;

/**
 * ClassName: BinarySearch
 * Description:
 * date: 2020/7/30 23:00
 *
 * @author seaxll
 * @since JDK 1.8
 */
public class BinarySearch {

    public static int binarySearch(int[] numbers, int input) {
        int low = 0;
        int high = numbers.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (input == numbers[middle]) {
                return middle;
            } else if (input > numbers[middle]) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

}
