package com.learn.leetcode._765_couples_holding_hands;

/**
 * ClassName: SolutionByGreedy
 * Description:
 * date: 2021/2/14 18:26
 *
 * @author zhy
 * @since JDK 1.8
 */
public class SolutionByGreedy {

    public int minSwapsCouples(int[] row) {
        int num = 0;
        for (int i = 0; i < row.length; i += 2) {
            int x = row[i] / 2;
            int y = row[i + 1] / 2;
            if (x != y) {
                for (int j = i + 2; j < row.length; j++) { // NOSONAR
                    int z = row[j] / 2;
                    if (z == x) {
                        changeArrayNum(row, i + 1, j);
                        num++;
                        break;
                    }
                    if (z == y) {
                        changeArrayNum(row, i, j);
                        num++;
                        break;
                    }
                }
            }
        }
        return num;
    }

    private void changeArrayNum(int[] row, int i, int j) {
        int temp = row[i];
        row[i] = row[j];
        row[j] = temp;
    }


    public static void main(String[] args) {
        SolutionByGreedy solution = new SolutionByGreedy();
        int[] row = {0, 2, 4, 6, 7, 1, 3, 5};
        System.out.println(solution.minSwapsCouples(row));
    }


}
