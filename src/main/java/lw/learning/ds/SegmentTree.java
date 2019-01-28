package lw.learning.ds;

import java.util.Arrays;
import java.util.function.BinaryOperator;

/**
 * @Author lw
 * @Date 2019-01-28 15:45:30
 **/
public class SegmentTree<E> {

    private Object[] data;
    private Object[] tree;
    private BinaryOperator<E> combiner;

    public SegmentTree(E[] arr, BinaryOperator<E> combiner) {

        data = new Object[arr.length];
        tree = new Object[arr.length * 4];
        this.combiner = combiner;
        System.arraycopy(arr, 0, data, 0, arr.length);

        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 在 treeIndex 位置创建表示区间为 [l..r] 的线段树
     *
     * @param treeIndex 在数中的位置
     * @param l         数据范围
     * @param r
     */
    @SuppressWarnings("unchecked")
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }

        int mid = l + ((r - l) >> 1);
        int leftTree = left(treeIndex);
        int rightTree = right(treeIndex);

        buildSegmentTree(leftTree, l, mid);
        buildSegmentTree(rightTree, mid + 1, r);

        tree[treeIndex] = combiner.apply((E) tree[leftTree], (E) tree[rightTree]);
    }

    public int size() {

        return data.length;
    }

    public E get(int index) {

        return elementData(index);
    }

    public E query(int queryL, int queryR) {
        if (queryR >= queryL) {

            return query(0, 0, data.length - 1, queryL, queryR);

        } else {
            return null;
        }
    }

    // 在 l..r 中查找 queryL..queryR
    private E query(int treeIndex, int l, int r, int queryL, int queryR) {

        if (l == queryL && r == queryR)
            return elementTreeData(treeIndex);

        int mid = l + ((r - l) >> 1);
        int left = left(treeIndex);
        int right = right(treeIndex);

        if (queryL >= mid + 1) {
            return query(right, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            return query(left, l, mid, queryL, queryR);
        } else {
            E leftValue = query(left, l, mid, queryL, mid);
            E rightValue = query(right, mid + 1, r, mid + 1, queryR);
            return combiner.apply(leftValue, rightValue);
        }
    }

    public void set(int index, E e) {

        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    /**
     * @param treeIndex 代表节点 l..r 的位置
     * @param l         treeIndex 区间开始
     * @param r         treeIndex 区间结束
     * @param index     向要更新的位置
     * @param e         更新的元素
     */
    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }
        int mid = l + ((r - l) >> 1);
        int leftIndex = left(treeIndex);
        int rightIndex = right(treeIndex);

        if (index >= mid + 1) {
            set(rightIndex, mid + 1, r, index, e);
        } else /* if (index <= mid) */ {
            set(leftIndex, l, mid, index, e);
        }
        E leftValue = elementTreeData(leftIndex);
        E rightValue = elementTreeData(rightIndex);
        tree[treeIndex] = combiner.apply(leftValue, rightValue);
    }


    @Override
    public String toString() {
        return Arrays.toString(tree);
    }

    @SuppressWarnings("unchecked")
    E elementData(int index) {

        return (E) data[index];
    }

    @SuppressWarnings("unchecked")
    E elementTreeData(int index) {
        return (E) tree[index];
    }

    private int left(int index) {

        return (index << 1) + 1;
    }

    private int right(int index) {

        return (index << 1) + 2;
    }
}
