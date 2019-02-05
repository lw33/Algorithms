package lw.learning.algorithms.dp;

import org.junit.Test;

/**
 * @Author lw
 * @Date 2019-02-04 16:49:40
 **/
public class Knapsack01 {


    public int knapsack01I(int[] w, int[] v, int c) {

        memo = new int[w.length][c + 1];
        for (int i = 0; i < w.length; i++) {
            for (int j = 0; j < c + 1; j++) {
                memo[i][j] = -1;
            }
        }

        //return knapsack01I(w, v, w.length - 1, c);
        return knapsack01II(w, v, w.length - 1, c);
    }

    // 从 [0..index] 的物品 填充 c 容量的背包
    public int knapsack01I(int[] w, int[] v, int index, int c) {

        if (index < 0 || c <= 0) {
            return 0;
        }

        return Math.max(knapsack01I(w, v, index - 1, c),
                w[index] > c ? 0 : v[index] + knapsack01I(w, v, index - 1, c - w[index]));

    }

    private int[][] memo;

    // 从 [0..index] 的物品 填充 c 容量的背包
    public int knapsack01II(int[] w, int[] v, int index, int c) {

        if (index < 0 || c <= 0) {
            return 0;
        }
        if (memo[index][c] != -1) {
            return memo[index][c];
        }

        int res = Math.max(knapsack01II(w, v, index - 1, c),
                w[index] > c ? 0 : v[index] + knapsack01II(w, v, index - 1, c - w[index]));
        memo[index][c] = res;
        return res;
    }

    public int knapsack01III(int[] w, int[] v, int c) {

        if (w.length == 0 || c == 0) {
            return 0;
        }

        int[][] dp = new int[w.length][c + 1];
        for (int i = 0; i <= c; i++) {
            dp[0][i] = i >= w[0] ? v[0] : 0;
        }

        for (int i = 1; i < w.length; i++) {
            for (int j = 0; j <= c; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= w[i]) {
                    dp[i][j] = Math.max(dp[i][j], v[i] + dp[i - 1][j - w[i]]);
                }
            }
        }


        return dp[w.length - 1][c];
    }

    public int knapsack01IV(int[] w, int[] v, int c) {

        if (w.length == 0 || c == 0) {
            return 0;
        }

        int[][] dp = new int[2][c + 1];

        for (int i = 0; i <= c; i++) {
            dp[0][i] = i >= w[0] ? v[0] : 0;
        }

        for (int i = 1; i < w.length; i++) {
            for (int j = 0; j <= c; j++) {
                dp[i % 2][j] = dp[(i - 1) % 2][j];
                if (j >= w[i]) {
                    dp[i % 2][j] = Math.max(dp[i % 2][j], v[i] + dp[(i - 1) % 2][j - w[i]]);
                }
            }
        }

        return dp[(w.length - 1) % 2][c];
    }

    public int knapsack01V(int[] w, int[] v, int c) {

        if (w.length == 0 || c == 0) {
            return 0;
        }

        int[] dp = new int[c + 1];

        for (int i = 0; i <= c; i++) {
            dp[i] = i >= w[0] ? v[0] : 0;
        }

        for (int i = 1; i < w.length; i++) {
            for (int j = c; j >= w[i]; j--) {
                dp[j] = Math.max(dp[j], v[i] + dp[j - w[i]]);
            }
        }

        return dp[c];
    }

    @Test
    public void test() {
        int[] w = {1, 2, 3, 4, 5, 9};
        int[] v = {6, 10, 12, 234, 6, 1222};
        System.out.println(this.knapsack01I(w, v, 9));
        System.out.println(this.knapsack01III(w, v, 9));
        System.out.println(this.knapsack01IV(w, v, 9));
        System.out.println(this.knapsack01V(w, v, 9));
    }
}
