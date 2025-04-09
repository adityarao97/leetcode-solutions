class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] course: prerequisites){
            adj.get(course[1]).add(course[0]);
            indegree[course[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses; i++){
            if(indegree[i]==0) queue.add(i);
        }
        int i=0;
        int[] topo = new int[numCourses];
        while(!queue.isEmpty()){
            int node = queue.poll();
            topo[i++] = node;
            for(int elem: adj.get(node)){
                indegree[elem]--;
                if(indegree[elem]==0) queue.add(elem);
            }
        }
        if(i!=numCourses) return new int[0];
        return topo;
    }
}