package com.learn.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhy
 */
public class Utils {

    private Utils() {
    }

    /**
     * 将 ["ab","ba","cd"] 形式的字符串转为一个列表
     *
     * @param str 字符串数组的字符串表示形式
     * @return 字符串列表
     */
    public static List<String> strToListStr(String str) {
        return Arrays.stream(unPacking(str).split(","))
                .map(String::trim)
                .map(Utils::unPacking)
                .collect(Collectors.toList());
    }

    /**
     * 去掉字符串前后的包装
     * e.g: "eto" -> eto
     *
     * @param source 字符串
     * @return 字符串内容
     */
    public static String unPacking(String source) {
        return unPacking(source, 1);
    }

    /**
     * 去掉字符串前后的包装
     * e.g: "eto" -> eto
     *
     * @param source 字符串
     * @param pakLen 包装长度
     * @return 字符串内容
     */
    public static String unPacking(String source, int pakLen) {
        if (source.length() < pakLen << 1) {
            return "";
        }
        return source.substring(pakLen, source.length() - pakLen);
    }

}
