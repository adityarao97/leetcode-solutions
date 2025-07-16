import java.util.*;
class TrieNode{
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isWord;

    public void insert(String word){
        TrieNode current = this;
        for(Character ch: word.toCharArray()){
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.isWord = true;
    }
}

class Solution {
    HashSet<String> result;
    boolean[][] visited;
    int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void dfs(char[][] board, TrieNode node, int row, int col, String word){
        if(row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col] || !node.children.containsKey(board[row][col]))
            return;
        visited[row][col] = true;
        word += board[row][col];
        char ch = board[row][col];
        node = node.children.get(ch);
        if(node.isWord)
            result.add(word);
        for(int[] direction: directions)
            dfs(board, node, row + direction[0], col + direction[1], word);
        visited[row][col] = false;
    } 

    public List<String> findWords(char[][] board, String[] words) {
        int rows = board.length;
        int cols = board[0].length;
        result = new HashSet<>();
        visited = new boolean[rows][cols];
        TrieNode root = new TrieNode();
        for(String word: words)
            root.insert(word);
        for(int row=0; row<rows; row++)
            for(int col=0; col<cols; col++)
                dfs(board, root, row, col, "");
        return result.stream().collect(Collectors.toList());
    }
}