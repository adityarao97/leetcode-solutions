class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        //create a 2d array with position and speed
        int[][] pair = new int[position.length][2];
        for(int i = 0; i<position.length; i++){
            pair[i][0] = position[i];
            pair[i][1] = speed[i];
        }
        
        //sort this pair in decreasing order of position
        Arrays.sort(pair, (a,b) -> Integer.compare(b[0], a[0]));

        //create a stack of double data type which will contain the time unit for each car to reach target -> time = (distance)/speed : distance -> target - currentPosition
        Stack<Double> stack = new Stack<>();

        //loop through each pair
        for(int[] p : pair){
            stack.push((double) (target - p[0])/p[1]);
            //pop elements from stack if the time to reach target of current car is less than that of the previous car
            if(stack.size() >= 2 && stack.peek() <= stack.get(stack.size()-2)){
                stack.pop();
            }
        }

        //the total elements in the stack are the possible number of fleets
        return stack.size();
    }
}