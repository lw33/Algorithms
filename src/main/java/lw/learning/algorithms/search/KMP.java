package lw.learning.algorithms.search;

/**
 * @Author lw
 * @Date 2019-02-25 14:13:18
 **/
public class KMP {

    public static int indexOf(String str, String target) {
        if (str.length() < target.length()) {
            return -1;
        }
        char[] str1 = str.toCharArray();
        char[] str2 = target.toCharArray();
        int[] next = next(str2);
        int i1 = 0;
        int i2 = 0;
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                i1++;
            } else {
                i2 = next[i2];
            }
        }
        return i2 == str2.length ? i1 - i2 : -1;
    }

    private static int[] next(char[] str) {
        if (str.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[str.length];
        next[0] = -1;
        next[1] = 0;
        int i = 2;
        int pre = 0;
        while (i < str.length) {
            if (str[i - 1] == str[pre]) {
                next[i++] = ++pre;
            } else if (pre > 0) {
                pre = next[pre];
            } else {
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(KMP.indexOf("java", "va"));
    }
}
