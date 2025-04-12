class Solution {

    private static int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    private boolean dfs(char[][] board, String word, int row, int col, int index){
        if(index==word.length())
            return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || word.charAt(index)!=board[row][col])
            return false;
        char temp = board[row][col];
        board[row][col] = '#';
        for(int[] dir: directions){
            int r = row + dir[0];
            int c = col + dir[1];
            if(dfs(board, word, r, c, index + 1))
                return true;
        }
        board[row][col] = temp;
        return false;
    } 

    public boolean exist(char[][] board, String word) {
        for (int row = 0; row<board.length; row++)
            for(int col = 0; col<board[0].length; col++)
                if(dfs(board, word, row, col, 0))
                    return true;
        return false;
    }
}