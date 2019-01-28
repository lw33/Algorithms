package lw.learning.test.ds;

import lw.learning.ds.SegmentTree;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-28 16:18:26
 **/
public class SegmentTreeTest {
    
    @Test
    public void test() {
        Integer[] nums = {1,3,5};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, Integer::sum);
        System.out.println(segmentTree.query(0, 2));
        segmentTree.set(1, 2);
        System.out.println(segmentTree.query(0, 2));
        System.out.println(segmentTree);
    }
}
