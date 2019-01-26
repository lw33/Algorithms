package lw.learning.utils;

/**
 * @Author lw
 * @Date 2019-01-25 21:13:43
 **/
public class TimeHelper {

    public static <T> long process() {
        long start = System.currentTimeMillis();

        long end = System.currentTimeMillis();
        return end - start;
    }
}
