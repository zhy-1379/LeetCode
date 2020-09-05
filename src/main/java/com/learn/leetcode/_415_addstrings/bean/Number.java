package com.learn.leetcode._415_addstrings.bean;

/**
 * ClassName: Number
 * Description:
 * date: 2020/8/3 9:16
 *
 * @author seaxll
 * @since JDK 1.8
 */
public class Number {
    private final int intValue;
    private final String strValue;

    public static Number ZERO = new Number(0, "0");
    public static Number ONE = new Number(1, "1");
    public static Number TWO = new Number(2, "2");
    public static Number THREE = new Number(3, "3");
    public static Number FOUR = new Number(4, "4");
    public static Number FIVE = new Number(5, "5");
    public static Number SIX = new Number(6, "6");
    public static Number SEVEN = new Number(7, "7");
    public static Number EIGHT = new Number(8, "8");
    public static Number NINE = new Number(9, "9");

    private Number(int intValue, String strValue) {
        this.intValue = intValue;
        this.strValue = strValue;
    }

    public int getIntValue() {
        return intValue;
    }

    public String getStrValue() {
        return strValue;
    }

    public static Number[] getNumbers() {
        return new Number[]{ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE};
    }

    public Number fromString(String strValue) {
        for (Number number : getNumbers()) {
            if (number.getStrValue().equals(strValue)) {
                return number;
            }
        }
        return null;
    }

}
