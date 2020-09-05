package com.learn.algorithmbase.utils;

/**
 * ClassName: StringUtils
 * Description:
 * date: 2020/9/1 17:07
 *
 * @author seaxll
 * @since JDK 1.8
 */
public class StringUtils {

    public static boolean wildcardMatch(String original, String wildCard) {
        int oIndex = 0, wIndex = 0;
        int i = -1, j = -1;

        while (oIndex < original.length()) {
            if (wIndex < wildCard.length() && wildCard.charAt(wIndex) == '*') {
                i = oIndex;
                j = wIndex;
                wIndex++;
            } else if (wIndex < wildCard.length() &&
                    (original.charAt(oIndex) == wildCard.charAt(wIndex) ||
                            wildCard.charAt(wIndex) == '?')) {
                oIndex++;
                wIndex++;
            } else {
                if (j == -1) return false;

                wIndex = j;
                oIndex = i + 1;
            }
        }

        while (wIndex < wildCard.length() && wildCard.charAt(wIndex) == '*') wIndex++;

        return wIndex == wildCard.length();
    }

}
