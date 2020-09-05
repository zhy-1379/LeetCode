package com.learn.leetcode._415_addstrings;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * ClassName: AddStrings
 * Description:
 *  给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 *
 *  注意：
 *  1.num1 和num2 的长度都小于 5100.
 *  2.num1 和num2 都只包含数字 0-9.
 *  3.num1 和num2 都不包含任何前导零。
 *  4.你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *
 *  来源：力扣（LeetCode）
 *  链接：https://leetcode-cn.com/problems/add-strings
 *  著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * date: 2020/8/3 8:58
 *
 * @author seaxll
 * @since JDK 1.8
 */
public class AddStrings {
    private static Logger logger = LoggerFactory.getLogger(AddStrings.class);

    public static void main(String[] args) {
        Random random = new Random();
        String num1 = String.valueOf(random.nextInt(1000));
        String num2 = String.valueOf(random.nextInt(1000));
        Solution solution = new Solution();
        String sum = solution.addStrings(num1, num2);
        logger.info("{} + {} = {}", num1, num2, sum);
    }

}
