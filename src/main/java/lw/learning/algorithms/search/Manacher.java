package lw.learning.algorithms.search;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-03-06 15:55:15
 **/
public class Manacher {

    public static char[] manacherStr(char[] str) {
        char[] manacherStr = new char[str.length * 2 + 1];
        for (int i = 0; i < manacherStr.length; i++) {
            if (i % 2 == 0) {
                manacherStr[i] = '#';
            } else {
                manacherStr[i] = str[i >> 1];
            }
        }
        return manacherStr;
    }

    public int maxPalindrome(String str) {
        char[] chars = str.toCharArray();
        char[] manacherStr = manacherStr(chars);
        int max = 0;
        int index = 0; // 最右边界中心
        int r = 0; //  最右边界

        int[] ir = new int[manacherStr.length]; // i位置最长回文半径

        for (int i = 0; i < manacherStr.length; i++) {

            ir[i] = i < r ? Math.min(ir[index * 2 - i], r - i) : 1;

            while (i + ir[i] >= r &&
                    i + ir[i] < manacherStr.length &&
                    i - ir[i] > -1 &&
                    manacherStr[i + ir[i]] == manacherStr[i - ir[i]]) {

                ir[i]++;
            }

            if (i + ir[i] > r) {
                index = i;
                r = i + ir[i];
            }
            if (max < ir[i]) {
                max = ir[i];
            }
        }

        return max - 1;
    }

    @Test
    public void test() {
        System.out.println(maxPalindrome("abacaba"));
    }

}
