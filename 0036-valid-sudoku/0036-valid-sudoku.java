class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> colSet = new HashSet<Character>();
        HashSet<Character> rowSet = new HashSet<Character>();
        HashMap<String, HashSet<Character>> gridMap = new HashMap<>();
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                char chRow = board[row][col];
                char chCol = board[col][row];
                if(chRow!='.' && rowSet.contains(chRow)){
                    return false;
                }
                else{
                    rowSet.add(chRow);
                }
                if(chCol!='.' && colSet.contains(chCol)){
                    return false;
                }
                else{
                    colSet.add(chCol);
                }
                String gridStr = row/3 + "." + col/3;
                if(gridMap.containsKey(gridStr)){
                    HashSet<Character> gridSet = gridMap.get(gridStr);
                    if(chRow!='.' && gridSet.contains(chRow)){
                        return false;
                    }
                    else{
                        gridSet.add(chRow);
                        gridMap.put(gridStr, gridSet);
                    }
                }
                else{
                    if(chRow!='.'){
                        gridMap.put(gridStr, new HashSet<Character>(Collections.singleton(chRow)));
                    }
                }
            }
            colSet.clear();
            rowSet.clear();
        }
        return true;
    }
}