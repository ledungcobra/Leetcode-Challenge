package com.ledung;

public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == '1') {
                    count++;
                    clear(grid, row, col);
                }
            }
        }
        return count;
    }

    private void clear(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length ||
                col < 0 || col >= grid[0].length ||
                grid[row][col] == '0') {
            return;
        }
        grid[row][col] = '0';
        clear(grid, row + 1, col);
        clear(grid, row - 1, col);
        clear(grid, row, col + 1);
        clear(grid, row, col - 1);
    }

    public static void main(String[] args) {
        var grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
        };
        System.out.println(new NumberOfIslands().numIslands(grid));
    }

}
