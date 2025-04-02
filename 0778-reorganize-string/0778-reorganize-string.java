class Solution {
    public String reorganizeString(String s) {
        //create a character to integer frequency map
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        //create a maxHeap and add all characters from map in decreasing order
        Queue<Character> maxHeap = new PriorityQueue<>((a,b) -> map.get(b) - map.get(a));
        maxHeap.addAll(map.keySet());
        
        //create a string builder to append characters
        StringBuilder sb = new StringBuilder();

        //loop until maxHeap has more than 1 elements
        while(maxHeap.size()>1){
            //extract the highest occuring character
            char first = maxHeap.poll();
            //reduce the map count value for this character
            map.put(first, map.get(first) - 1);
            //append to string
            sb.append(first);

            //do the same with next most frequent character
            char second = maxHeap.poll();
            map.put(second, map.get(second) - 1);
            sb.append(second);

            //check if map still has a frequency more than 1 for these characters if so add it back to heap
            if(map.get(first)>0){
                maxHeap.add(first);
            } 
            if(map.get(second)>0){
                maxHeap.add(second);
            }
        }

        //check if maxHeap is still not empty
        if(!maxHeap.isEmpty()){
            if(map.get(maxHeap.peek())>1){
                return "";
            }
            else{
                sb.append(maxHeap.peek());
            }
        }
        return sb.toString();
    }
}