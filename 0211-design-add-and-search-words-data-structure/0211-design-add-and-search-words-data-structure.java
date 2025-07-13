class TrieNode {
    HashMap<Character ,TrieNode> children = new HashMap<>();
    boolean isWord = false;
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current = root;
        for(char ch: word.toCharArray()){
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.isWord = true;
    }

    public boolean dfs(String word, int j, TrieNode root){
        TrieNode current = root;
        for(int i=j; i<word.length();i++){
            char ch = word.charAt(i);
            if(ch=='.'){
                for(TrieNode child: current.children.values()){
                    if (dfs(word, i+1, child)) return true;
                }
                return false;
            }
            else{
                if(!current.children.containsKey(ch)){
                    return false;
                }
                current = current.children.get(ch);
            }
        }
        return current.isWord;
    }
    
    public boolean search(String word) {
        return dfs(word, 0, root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */