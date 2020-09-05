package com.learn.algorithmbase.utils;

import org.junit.Test;

/**
 * ClassName: StringUtilsUTest
 * Description:
 * date: 2020/9/1 17:09
 *
 * @author seaxll
 * @since JDK 1.8
 */
public class StringUtilsUTest {

    @Test
    public void isMatchWithWildCardUTest() {
        String str = "zhanghaiyang.zhang";
        String wildCard = "*.zhan?";
        System.out.println(StringUtils.wildcardMatch(str, wildCard));


    }
}
