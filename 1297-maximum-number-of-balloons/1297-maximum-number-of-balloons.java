class Solution {
    public int maxNumberOfBalloons(String text) {
        if(text.length()<7){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        for(char ch: text.toCharArray()){
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        String pattern = "balloon";
        if(map.containsKey('b') && map.containsKey('a') && map.containsKey('l') && map.get('l')>=2 && map.containsKey('o') && map.get('o')>=2 && map.containsKey('n')){
            int min = Math.min(map.get('l')/2,map.get('o')/2);
            for(char ch: pattern.toCharArray()){
                min = Math.min(min, map.get(ch));
            }
            return min;
        }
        return 0;
    }
}