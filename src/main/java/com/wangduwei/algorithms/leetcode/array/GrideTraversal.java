package com.wangduwei.algorithms.leetcode.array;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 广度优先遍历网格
 *
 * @author : wangduwei
 * @date : 2020/4/27
 * @description :
 */
public class GrideTraversal {

    // 网格结构的层序遍历
    // 从格子 (p, q) 开始遍历
    void bfs(int[][] grid, int p, int q) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{p, q});

        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] node = queue.poll();
                int r = node[0], c = node[1];
                //左边
                if (r - 1 >= 0 && grid[r - 1][c] == 0) {
                    grid[r - 1][c] = 2;
                    queue.add(new int[]{r - 1, c});
                }
                //右边
                if (r + 1 < n && grid[r + 1][c] == 0) {
                    grid[r + 1][c] = 2;
                    queue.add(new int[]{r + 1, c});
                }
                //下边
                if (c - 1 >= 0 && grid[r][c - 1] == 0) {
                    grid[r][c - 1] = 2;
                    queue.add(new int[]{r, c - 1});
                }
                //上边
                if (c + 1 < n && grid[r][c + 1] == 0) {
                    grid[r][c + 1] = 2;
                    queue.add(new int[]{r, c + 1});
                }
            }
        }
    }

}
