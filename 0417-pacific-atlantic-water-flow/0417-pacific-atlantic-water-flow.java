class Solution {    
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        
    private void dfs(int r, int c, boolean[][] ocean, int[][] heights){
            ocean[r][c] = true;
            for(int[] dir: directions){
                int nr = r + dir[0];
                int nc = c + dir[1];
                if((nr >= 0 && nr < heights.length)
                    && (nc >= 0 && nc < heights[0].length)
                    && !ocean[nr][nc] && heights[nr][nc] >= heights[r][c]){
                        dfs(nr, nc, ocean, heights);
                    }
            }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int rows = heights.length;
        int cols = heights[0].length;
        boolean[][] visitedP = new boolean[rows][cols];
        boolean[][] visitedA = new boolean[rows][cols];

        for(int r = 0; r < rows; r++){
            dfs(r, 0, visitedP, heights);
            dfs(r, cols - 1, visitedA, heights);
        }

        for(int c = 0; c < cols; c++){
            dfs(0, c, visitedP, heights);
            dfs(rows - 1, c, visitedA, heights);
        }
        for(int r = 0; r < rows; r++)
            for(int c = 0; c < cols; c++)
                if(visitedP[r][c] && visitedA[r][c])
                    result.add(Arrays.asList(r, c));
        return result;
    }
}
