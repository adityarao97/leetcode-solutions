class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        //hashMap with key as username and value as treemap of timestamp and website
        Map<String, TreeMap<Integer, String>> map = new HashMap<>();
        for(int i=0; i<username.length; i++){
            if(!map.containsKey(username[i])){
                map.put(username[i], new TreeMap<>());
            }
            TreeMap<Integer, String> timeMap = map.get(username[i]);
            timeMap.put(timestamp[i], website[i]);
            map.put(username[i], timeMap);
        }
        //Create a map of all possible sequences of 3 websites and map it with count of different users
        Map<String, Integer> seqMap = new HashMap<>();
        for(String user: map.keySet()){
            TreeMap<Integer, String> timeMap = map.get(user);
            if(timeMap.size()<3){
                continue;
            }
            List<Integer> times = new ArrayList<>();
            for(int time: timeMap.keySet()){
                times.add(time);
            }
            //form all possible sequences with this set of available websites
            List<String> sequenceList = formAllSequence(times, timeMap);
            HashSet<String> visited = new HashSet<>();
            for(String sequence: sequenceList){
                if(visited.add(sequence)){
                    seqMap.put(sequence, seqMap.getOrDefault(sequence, 0) + 1);
                }
            }
        }
        int count = 0;
        String result = "";
        for(String seq: seqMap.keySet()){
            if(seqMap.get(seq) > count){
                count = Math.max(count, seqMap.get(seq));
                result = seq;
            }
            else if(seqMap.get(seq) == count){
                if(seq.compareTo(result) < 0){
                    result = seq;
                }
            }
        }
        List<String> resultList = new ArrayList<>();
        for(String s: result.split("->")){
            resultList.add(s);
        }
        return resultList;
    }

    private List<String> formAllSequence(List<Integer> times, TreeMap<Integer, String> timeMap){
        List<String> sequenceList = new ArrayList<>();
        for(int i=0; i<times.size()-2; i++){
            for(int j=i+1; j<times.size()-1; j++){
                for(int k=j+1; k<times.size(); k++){
                    sequenceList.add(timeMap.get(times.get(i)) + "->" + timeMap.get(times.get(j)) + "->" + timeMap.get(times.get(k)));
                }
            }
        }
        return sequenceList;
    }
}