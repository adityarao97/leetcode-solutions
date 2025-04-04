class Solution {
    public int orangesRotting(int[][] grid) {
        //define a queue which will contain an array of integer each storing grid position where oranges are rotten 
        Queue<int[]> queue = new LinkedList<>();
        //define a fresh pointer to track total number of fresh oranges
        int fresh = 0;
        // define a time pointer to identity total time taken
        int time = 0;
        //loop through the grid, if an orange is rotten push it onto the queue and if it is fresh increase counter for fresh
        int m = grid.length;
        int n = grid[0].length;
        for(int row=0; row<m;row++){
            for(int col=0;col<n;col++){
                int cell = grid[row][col];
                if(cell==1){
                    fresh++;
                }
                if(cell==2){
                    queue.offer(new int[]{row, col});
                }
            }
        }
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        //until no fresh oranges are left or until queue is empty do bfs where oranges are rotten
        while(fresh>0 && !queue.isEmpty()){
            int length = queue.size();
            for(int i=0; i<length; i++){
                int[] cell = queue.poll();
                int row = cell[0];
                int col = cell[1]; 
                //loop through each direction to get adjacent cells if they are fresh make them rotten and add it to queue
                for(int[] direction: directions){
                    int r = row + direction[0];
                    int c = col + direction[1];
                    if(r>=0 && r<m && c>=0 && c<n && grid[r][c]==1){
                        grid[r][c] = 2;
                        fresh--;
                        queue.offer(new int[]{r,c});
                    }
                }
            }
            //increase time pointer after each cycle
            time++;
        }
        //if fresh pointer is not zero return -1 else return time value
        return fresh>0 ? -1 : time;
    }
}