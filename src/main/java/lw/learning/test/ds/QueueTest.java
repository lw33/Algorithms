package lw.learning.test.ds;

import lw.learning.ds.ArrayQueue;
import lw.learning.ds.LinkedListQueue;
import lw.learning.ds.LoopQueue;
import lw.learning.ds.PriorityQueue;
import lw.learning.utils.ArrayHelper;
import lw.learning.utils.DSType;
import lw.learning.utils.TestHelper;
import org.junit.Test;

import java.util.stream.IntStream;

/**
 * @Author lw
 * @Date 2019-01-27 09:57:10
 **/
public class QueueTest {


    @Test
    public void benchmark() {
        int[] arr = ArrayHelper.getRandomSizFixedArray(1000000, 1000000);

        TestHelper.testDSTime(DSType.QUEUE, java.util.LinkedList.class, arr);

        TestHelper.testDSTime(DSType.QUEUE, LoopQueue.class, arr);
        TestHelper.testDSTime(DSType.QUEUE, LinkedListQueue.class, arr);
        TestHelper.testDSTime(DSType.QUEUE, PriorityQueue.class, arr);

        TestHelper.testDSTime(DSType.QUEUE, java.util.PriorityQueue.class, arr);

        TestHelper.testDSTime(DSType.QUEUE, ArrayQueue.class, arr);
    }

    @Test
    public void test1() {
        ArrayQueue<Integer> queue = new ArrayQueue<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.poll();
        queue.poll();
        queue.peek();
        System.out.println(queue);
    }

    @Test
    public void test2() {
        LoopQueue<Integer> queue = IntStream.rangeClosed(1, 10)
                .collect(LoopQueue::new, LoopQueue::add, (q1, q2) -> {});
        queue.add(23);
        System.out.println(queue.peek());
        queue.poll();
        queue.add(32);
        queue.poll();
        queue.poll();
        queue.poll();
        queue.add(33);
        queue.add(33);
        System.out.println(queue);
    }

    @Test
    public void test3() {
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        int[] arr = ArrayHelper.getRandomSizFixedArray(1000000, 1000000);

        TestHelper.testQueueTime(loopQueue.getClass().getSimpleName(), loopQueue, arr);
        TestHelper.testQueueTime(linkedListQueue.getClass().getSimpleName(), linkedListQueue, arr);
        TestHelper.testQueueTime(arrayQueue.getClass().getSimpleName(), arrayQueue, arr);

    }


}
