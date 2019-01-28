package lw.learning.utils;

import java.util.function.Consumer;

/**
 * @Author lw
 * @Date 2019-01-25 21:13:43
 **/
public class TimeHelper {

    public static <T> long process(Consumer<T> consumer, T t) {
        return process(() -> consumer.accept(t));
    }

    public static long process(Process process) {
        long start = System.currentTimeMillis();
        process.process();
        long end = System.currentTimeMillis();
        return end - start;
    }

}
