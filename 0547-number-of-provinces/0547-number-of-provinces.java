class Solution {

    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> dfs, int node){
        visited[node] = true;
        dfs.add(node);
        for(int it: adj.get(node)){
            if(visited[it] == false){
                dfs(adj, visited, dfs, it);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        //make an adjacency matrix out of the 2d matrix
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int maxSize = Math.max(isConnected.length, isConnected[0].length);
        for(int i=0; i < maxSize+1; i++){
            adj.add(new ArrayList<>());
        } 
        for(int row = 0; row < isConnected.length; row++){
            for(int col = 0; col < isConnected[row].length; col++){
                if(isConnected[row][col]==1){
                    adj.get(row).add(col);
                    adj.get(col).add(row);  
                }
            }
        }
        //create a visited boolean array
        boolean[] visited = new boolean[adj.size()];
        int noOfProvince = 0;
        ArrayList<Integer> dfs = new ArrayList<>();
        //run dfs algorithm for each element in adjaceny matrix
            for(int i=0; i < adj.size(); i++){
                //if it is not visited call the dfs algo and increase counter
                if(adj.get(i).size()>0 && visited[i] == false){
                    noOfProvince++;
                    dfs(adj, visited, dfs, i);
                }
            }
        //return counter
        return noOfProvince; 
    }
}