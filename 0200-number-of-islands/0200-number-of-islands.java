class Solution {

    private static final int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; 

    private void dfs(char[][] grid, int row, int col){
        if(row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == '0') return;

        grid[row][col] = '0';
        for(int[] direction: directions){
            dfs(grid, row + direction[0], col + direction[1]);
        }
    }

    public int numIslands(char[][] grid) {
        int islandCount = 0;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == '1'){
                    islandCount++;
                    dfs(grid, row, col);
                }
            }
        }
        return islandCount;
    }
}