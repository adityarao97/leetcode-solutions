class Solution {
    public int numMagicSquaresInside(int[][] grid) {
int sizeRow = grid.length;
        int sizeCol = grid[0].length;
        if (sizeRow < 3 || sizeCol < 3) {
            return 0;
        }
        int totalCount = 0;
        for (int i = 0; i < sizeRow; i++) {
            if (i + 2 >= sizeRow) {
                break;
            }
            for (int j = 0; j < sizeCol; j++) {
                if (j + 2 >= sizeCol) {
                    break;
                }
                int[][] newGrid = new int[3][3];
                for (int row = 0; row < 3; row++) {
                    for (int col = 0; col < 3; col++) {
                        newGrid[row][col] = grid[row+i][col+j];
                    }
                }
                if (isMagicSquare(newGrid)) {
                    totalCount++;
                }
            }
        }
        return totalCount;
    }

    public static boolean isMagicSquare(int[][] grid){
        int sum = 0;
        for (int x = 0; x < 3; x++) {
            sum += grid[0][x];
        }
        boolean isRepeat = false;
        int prev = grid[0][0];
        for (int row = 0; row < 3; row++) {
            int rSum = 0;
            int cSum = 0;
            for (int col = 0; col < 3; col++) {
                if(row !=0 && col!=0 && grid[row][col] == prev){
                        return false;
                }
                if(grid[row][col]>9 || grid[row][col]<1){
                    return false;
                }
                rSum += grid[row][col];
                cSum += grid[col][row];
            }
            if (rSum != sum || cSum != sum) {
                return false;
            }
        }
        int dSum = 0;
        int adSum = 0;
        for (int col = 0; col < 3; col++) {
            dSum += grid[col][col];
            adSum += grid[col][3 - col - 1];
        }
        if (dSum != sum || adSum != sum) {
            return false;
        }
        return true;
    }
}