class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for(char ch: s.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);
        }
        Queue<Character> maxHeap = new PriorityQueue<>((a, b) -> freqMap.get(b) - freqMap.get(a));
        maxHeap.addAll(freqMap.keySet());
        StringBuilder sb = new StringBuilder();
        while(maxHeap.size()>1){
            //append first most frequent character
            char firstCharacter = maxHeap.poll();
            freqMap.put(firstCharacter, freqMap.get(firstCharacter) - 1);
            sb.append(firstCharacter);
            //append second most frequent character
            char secondCharacter = maxHeap.poll();
            freqMap.put(secondCharacter, freqMap.get(secondCharacter) - 1);
            sb.append(secondCharacter);
            //add characters back to the heap if they're more than 0
            if(freqMap.get(firstCharacter)>0){
                maxHeap.add(firstCharacter);
            }
            if(freqMap.get(secondCharacter)>0){
                maxHeap.add(secondCharacter);
            }
        }
        if(!maxHeap.isEmpty()){
            //if maxHeap has more than 1 characters it means that we need to append cannot create required string
            if(freqMap.get(maxHeap.peek())>1){
                return "";
            }
            //maxHeap has only one character which we append
            else{
                sb.append(maxHeap.peek());
            }
        }
        return sb.toString();
    }
}