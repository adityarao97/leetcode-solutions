class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //create an adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        //create an indegree array
        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] course: prerequisites){
            //for doing course 0 we should take 1 before so mapping in adj is 1 -> {0,...}
            adj.get(course[1]).add(course[0]);
            //no of incoming nodes will be course[0] as we are visiting to 0 from 1 we increase for course[0]
            indegree[course[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses; i++){
            //add those elements to queue where indegree is 0
            if(indegree[i]==0) queue.add(i);
        }
        int i=0;
        //array to find the elements in topological order
        int[] topo = new int[numCourses];
        while(!queue.isEmpty()){
            //poll the element from queue
            int node = queue.poll();
            //append it to array
            topo[i++] = node;
            for(int elem: adj.get(node)){
                //for their corresponding elements in adj list reduce indegree as the given node is removed 
                indegree[elem]--;
                //if the new indegree is 0 add it back to queue
                if(indegree[elem]==0) queue.add(elem);
            }
        }
        //if numCourses is not equal to total elements in array return empty array
        if(i!=numCourses) return new int[0];
        return topo;
    }
}