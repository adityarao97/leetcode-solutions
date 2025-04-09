class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        //create an indegree array which tracks count of incoming nodes
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses; i++){
            adj.add(new ArrayList<Integer>());
        }
        for(int[] course: prerequisites){
            indegree[course[1]]++;
            adj.get(course[0]).add(course[1]);
        }

        Queue<Integer> queue = new LinkedList<>();
        //add all elements to queue where indegree is 0
        for(int i=0; i<numCourses; i++){
            if(indegree[i]==0) queue.add(i);
        }

        int finish = 0;
        while(!queue.isEmpty()){
            //remove nodes from queue, where indegree becomes 0
            int node = queue.poll();
            //pointer to track total elements removed
            finish++;
            for(int it: adj.get(node)){
                //for the removed node we want to check in their adjacency list and reduce their indegree as it has been removed
                indegree[it]--;
                //if their new indegree becomes 0 remove it
                if(indegree[it]==0) queue.add(it);
            }
        }
        return (finish == numCourses);
    }
}