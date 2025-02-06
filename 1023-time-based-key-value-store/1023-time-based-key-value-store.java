class TimeMap {
    HashMap<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        Pair pair = new Pair(value, timestamp);
        List<Pair> list = map.getOrDefault(key, new ArrayList<>());
        list.add(pair);
        map.put(key, list);
    }
    
    public String get(String key, int timestamp) {
        List<Pair> values = map.getOrDefault(key, new ArrayList<>());
        int left = 0, right = values.size()-1, mid = 0;
        String result = "";
        while(left <= right){
            mid = (left + right) / 2;
            Pair pair = values.get(mid);
            if(pair.getTimestamp() <= timestamp){
                result = pair.getValue();
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return result;
    }

    private static class Pair{
        private String value;
        private int timestamp;

        public Pair(String value, int timestamp){
            this.timestamp = timestamp;
            this.value = value;
        }

        public String getValue(){
            return value;
        }

        public int getTimestamp(){
            return timestamp;
        }
    }
}


/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */