class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int matches = 0, index = 0, left = 0;
        //s1Matches will contain frequence value of each character in s1 on the ascii index 
        int[] s1Matches = new int[26];
        //s2Matches will contain frequence value of each character in s2 on the ascii index 
        int[] s2Matches = new int[26];
        //store the frequency of characters of s1 and s2 in s1Matches and s2Matches for the 1st window
        for(int i=0; i<s1.length(); i++){
            s1Matches[s1.charAt(i) - 'a']++;
            s2Matches[s2.charAt(i) - 'a']++;
        }
        //calculate matches for this first window
        for(int i=0; i<26; i++){
            if(s1Matches[i] == s2Matches[i]){
                matches++;
            }
        }
        //sliding window: for each window add a character to s2 in right pointer and remove a character in left pointer and update matches if matches == 26 return true
        for(int right = s1.length(); right<s2.length(); right++){
            if(matches==26){
                return true;
            }
            //character added on the right
            index = s2.charAt(right) - 'a';
            s2Matches[index]++;
            if(s2Matches[index] == s1Matches[index]){
                matches++;
            }
            //if a common character was added
            else if(s2Matches[index] == s1Matches[index]+1){
                matches--;
            }
            //character removed from the left
            index = s2.charAt(left) - 'a';
            s2Matches[index]--;
            if(s2Matches[index] == s1Matches[index]){
                matches++;
            }
            //if a common character was removed
            else if(s2Matches[index] == s1Matches[index]-1){
                matches--;
            }
            left++;
        }
        return matches == 26;
    }
}