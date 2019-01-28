package lw.learning.utils;

import lw.learning.ds.Map;
import lw.learning.ds.Queue;
import lw.learning.ds.Set;
import lw.learning.ds.Stack;

import java.lang.reflect.Constructor;
import java.util.*;
import java.util.function.Consumer;

/**
 * @Author lw
 * @Date 2019-01-25 21:29:58
 **/
public class TestHelper {


    public static void testSort(Consumer<int[]> consumer) {
        testSort(10, 100, 100, consumer);
    }

    public static void testSort(int times, int size, int range, Consumer<int[]> consumer) {
        for (int i = 0; i < times; i++) {
            int[] ints = ArrayHelper.genPositiveRandomArray(size, range);
            System.out.println(Arrays.toString(ints));
            System.out.println("is order: " + SortUtils.isOrder(ints));
            consumer.accept(ints);
            System.out.println("start order...");
            System.out.println(Arrays.toString(ints));
            System.out.println("is order: " + SortUtils.isOrder(ints));
            System.out.println("\n=========================================================\n");
        }
    }

    public static void testSortTime(String[] sortNames, Consumer<int[]>[] consumers, int[] arr) {

        for (int i = 0; i < sortNames.length; i++) {
            long duration = TimeHelper.process(consumers[i], arr);
            System.out.println(sortNames[i] + ": " + duration);
        }
    }

    public static void testSortTime(String sortName, Consumer<int[]> consumer, int[] arr) {
        int[] sortArray = Arrays.copyOf(arr, arr.length);
        long duration = TimeHelper.process(consumer, sortArray);
        System.out.println(sortName + ": " + duration + " ms");
    }

    public static void testQueueTime(String queueName, Queue<Integer> queue, int[] arr) {
        long duration = TimeHelper.process(() -> {
            for (int i : arr) {
                queue.add(i);
            }
            for (int i = 0; i < arr.length; i++) {
                queue.poll();
            }
        });
        System.out.println(queueName + ": " + duration + " ms");
    }

    public static void testStackTime(String stackName, Stack<Integer> stack, int[] arr) {
        long duration = TimeHelper.process(() -> {
            for (int i : arr) {
                stack.push(i);
            }
            for (int i = 0; i < arr.length; i++) {
                stack.pop();
            }
        });
        System.out.println(stackName + ": " + duration + " ms");
    }


    public static void testDSTime(DSType type, Class<?> clazz, Object testData) {
        testDSTime(type, clazz, 0, testData);
    }

    /**
     * 测试集合
     * @param type
     * @param clazz
     * @param initCapacity
     * @param book
     */
    public static void testDSTime(DSType type, Class<?> clazz,int initCapacity, Object testData) {
        try {

            switch (type) {
                case MAP:
                    testMapTime(clazz, initCapacity, (List<String>)testData);
                    break;
                case SET:
                    testSetTime(clazz,initCapacity, (List<String>)testData);
                    break;
                case QUEUE:
                    testQueueTime(clazz, initCapacity, (int[])testData);
                    break;
                case STACkT:
                    break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testSetTime(Class<?> clazz,int initCapacity, List<String> book) throws Exception {
        Object o = null;
        if (initCapacity != 0) {
            Constructor<?> constructor = clazz.getConstructor(int.class);
            o = constructor.newInstance(initCapacity);
        } else {
            o = clazz.newInstance();
        }

        if (o instanceof java.util.Set) {
            java.util.Set<String> set = (java.util.Set<String>) o;
            long duration = TimeHelper.process(() -> {
                for (String s : book) {
                    set.add(s);
                }
                for (String s : book) {
                    set.contains(s);
                }
            });

            printInfo(set.getClass().getSimpleName(), duration, book.size(), set.size());
        } else if (o instanceof Set) {
            Set<String> set = (Set<String>) o;
            long duration = TimeHelper.process(() -> {
                for (String s : book) {
                    set.add(s);
                }
                for (String s : book) {
                    set.contains(s);
                }
            });
            printInfo(set.getClass().getSimpleName(), duration, book.size(), set.size());
        }
    }

    public static void testMapTime(Class<?> clazz,int initCapacity, List<String> book) throws Exception {
        Object o = null;
        if (initCapacity != 0) {
            Constructor<?> constructor = clazz.getConstructor(int.class);
            o = constructor.newInstance(initCapacity);
        } else {
            o = clazz.newInstance();
        }

        if (o instanceof java.util.Map) {
            java.util.Map<String, Integer> map = (java.util.Map<String, Integer>) o;
            long duration = TimeHelper.process(() -> {
                for (String s : book) {
                    Integer times = map.get(s);
                    map.put(s, times == null ? 1 : times + 1);
                }
            });

            printInfo(clazz.getSimpleName(), duration, book.size(), map.size());
        } else if (o instanceof Map) {
            Map<String, Integer> map = (Map<String, Integer>) o;
            long duration = TimeHelper.process(() -> {
                for (String s : book) {
                    Integer times = map.get(s);
                    map.put(s, times == null ? 1 : times + 1);
                }
            });
            printInfo(clazz.getSimpleName(), duration, book.size(), map.size());
        }
    }
    public static void testQueueTime(Class<?> clazz,int initCapacity, int[] arr) throws Exception{
        Object o = null;
        if (initCapacity != 0) {
            Constructor<?> constructor = clazz.getConstructor(int.class);
            o = constructor.newInstance(initCapacity);
        } else {
            o = clazz.newInstance();
        }
        long duration = 0;
        if (o instanceof Queue) {
            Queue<Integer> queue = (Queue<Integer>) o;
            duration = TimeHelper.process(() -> {
                for (int i : arr) {
                    queue.add(i);
                }
                for (int i = 0; i < arr.length; i++) {
                    queue.poll();
                }
            });

        } else if (o instanceof java.util.Queue) {

            java.util.Queue<Integer> queue = (java.util.Queue<Integer>) o;
            duration = TimeHelper.process(() -> {
                for (int i : arr) {
                    queue.add(i);
                }
                for (int i = 0; i < arr.length; i++) {
                    queue.poll();
                }
            });
        }
        System.out.println(clazz.getSimpleName() + ": " + duration + " ms");
    }
    public static void testSetTime(Set<String> set, List<String> book) {
        long duration = TimeHelper.process(() -> {
            for (String s : book) {
                set.add(s);
            }
        });

        printInfo(set.getClass().getSimpleName(), duration, book.size(), set.size());
    }

    public static void testMapTime(Map<String, Integer> map, List<String> book) {
        long duration = TimeHelper.process(() -> {
            for (String s : book) {
                Integer times = map.get(s);
                map.put(s, times == null ? 1 : times + 1);
            }
        });
        printInfo(map.getClass().getSimpleName(), duration, book.size(), map.size());
    }

    private static void printInfo(String name, long duration, int totalWords, int uniqueWords) {
        System.out.println(name + ": " + duration + " ms");
        System.out.println("total words: " + totalWords);
        System.out.println("unique words: " + uniqueWords);
        System.out.println();
    }
}
