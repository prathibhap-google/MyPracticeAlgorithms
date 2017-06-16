package com.practice.examples.graphs;

/* A group of connected 1s forms an island. Given a 2D array find the number of islands.

Input: {1, 1, 0, 0, 0},
       {0, 1, 0, 0, 1},
       {1, 0, 0, 1, 1},
       {0, 0, 1, 0, 0},
       {1, 0, 1, 0, 1}

Output: 4

Time Complexity: O(V+E)
 */

public class NumberOfGroups {

    public int findNumberOfClusters(int[][] M) {
        int row = M.length;
        int col = M[0].length;
        boolean[][] visited = new boolean[row][col];
        int count = 0;
        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                if(M[i][j] == 1 && !visited[i][j]){
                    performDFS(M, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public static void performDFS(int[][] M, boolean[][] visited, int i, int j) {

        int[] offset = {-1,0,1};
        int x, y;
        visited[i][j] = true;
        for(int k=0;k<offset.length; k++) {
            x = offset[k];
            for(int l=0;l<offset.length; l++) {
                y = offset[l];
                if(x == 0 && y == 0)
                    continue;
                if(isSafe(M, visited, x+i, y+j)) {
                    if(M[x+i][y+j] == 1 & !visited[x+i][y+j]) {
                        performDFS(M, visited, x+i, y+j);
                    }
                }
            }
        }

    }

    private static boolean isSafe(int[][] m, boolean[][] visited, int i, int j) {
        if(i >= 0 && j >= 0 && i < m.length && j < m[0].length) {
            if(m[i][j] == 1 && !visited[i][j])
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int M[][]=  new int[][] {{1, 1, 0, 0, 0},
                                 {0, 1, 0, 0, 1},
                                 {1, 0, 0, 1, 1},
                                 {0, 0, 1, 0, 0},
                                 {1, 0, 1, 0, 1}
        };

        NumberOfGroups g = new NumberOfGroups();
        int groupCnt = g.findNumberOfClusters(M);
        System.out.println(groupCnt);
    }
}
