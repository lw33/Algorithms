package lw.learning.ds;

/**
 * @Author lw
 * @Date 2019-01-28 22:02:32
 **/
public interface UF {

    boolean isConnected(int p, int q);

    void union(int p, int q);

    int size();

}
