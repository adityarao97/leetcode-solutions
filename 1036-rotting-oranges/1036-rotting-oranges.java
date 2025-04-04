class Solution {

    private static final int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    private int bfs(int[][] grid, List<int[]> list,int[][] visited){
        Queue<int[]> queue = new LinkedList<>();
        for(int[] it: list){
            queue.offer(it);
        }
        int time = 0;
        while(!queue.isEmpty()){
            time =  queue.peek()[2];
            for(int i = 0; i < queue.size(); i++){                
                int[] node = queue.poll();
                int row = node[0];
                int col = node[1];
                time++;
                for(int[] direction : directions){
                    if(row + direction[0] >= 0 && row + direction[0] < grid.length && col + direction[1] >= 0 && col + direction[1] < grid[0].length){
                        if(visited[row + direction[0]][col + direction[1]] == 0 && grid[row + direction[0]][col + direction[1]] == 1){
                            grid[row + direction[0]][col + direction[1]] = 2;
                            queue.offer(new int[]{row + direction[0], col + direction[1], time});
                            visited[row + direction[0]][col + direction[1]] = 1;
                        }
                    }
                }
            }
        }
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 1){
                    return -1;
                }
            }
        }
        return time;
    }

    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;
        int time = 0;
        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == 2){
                    queue.offer(new int[]{row, col});
                }
                if(grid[row][col] == 1){
                    fresh++;
                }
            }
        }
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while(!queue.isEmpty() && fresh>0){
            int length = queue.size();
            for(int i=0; i < length; i++){
                int[] node = queue.poll();
                int row = node[0];
                int col = node[1];
                for(int[] direction: directions){
                    int nextRowCell = row + direction[0];
                    int nextColCell = col + direction[1];
                    if(nextRowCell >= 0 && nextRowCell < grid.length && nextColCell >= 0 && nextColCell < grid[0].length && grid[nextRowCell][nextColCell] == 1){
                        grid[nextRowCell][nextColCell] = 2;
                        queue.offer(new int[]{nextRowCell, nextColCell});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh!=0 ? -1 : time;
    }
}