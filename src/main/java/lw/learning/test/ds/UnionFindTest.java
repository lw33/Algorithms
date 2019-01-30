package lw.learning.test.ds;

import lw.learning.ds.UnionFind3;
import lw.learning.ds.UnionFind4;
import lw.learning.ds.UnionFind5;
import lw.learning.ds.UnionFind6;
import lw.learning.utils.ArrayHelper;
import lw.learning.utils.DSType;
import lw.learning.utils.TestHelper;
import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-01-29 08:50:09
 **/
public class UnionFindTest {


    @Test
    public void benchmark() {
        // union find size
        int size = 10000000;
        // union 次数 isConnection 次数
        int times = 10000000;
        int[] tests = ArrayHelper.getRandomSizFixedArray(times * 4, size - 1);
        //TestHelper.testDSTime(DSType.UF, UnionFind1.class, size, tests);
        //TestHelper.testDSTime(DSType.UF, UnionFind2.class, size, tests);
        TestHelper.testDSTime(DSType.UF, UnionFind3.class, size, tests);
        TestHelper.testDSTime(DSType.UF, UnionFind4.class, size, tests);
        TestHelper.testDSTime(DSType.UF, UnionFind5.class, size, tests);
        TestHelper.testDSTime(DSType.UF, UnionFind6.class, size, tests);
    }
}
