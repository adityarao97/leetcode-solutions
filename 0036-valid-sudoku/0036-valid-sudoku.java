class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character> setRow = new HashSet<Character>();
        HashSet<Character> setCol = new HashSet<Character>();
        HashMap<String,HashSet<Character>> squareMap = new HashMap<>();
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board.length;col++){
                char chRow = board[row][col];
                char chCol = board[col][row];
                String gridIndex = row/3 + "" + col/3;
                if(chRow!='.' && setRow.contains(chRow)){
                    return false;
                }
                else{
                    setRow.add(chRow);
                }
                if(chCol!='.' && setCol.contains(chCol)){
                    return false;
                }
                else{
                    setCol.add(chCol);
                }
                if(chRow!='.' && squareMap.getOrDefault(gridIndex, new HashSet<>()).contains(chRow)){
                    return false;
                }
                else{
                    HashSet<Character> squareSet = squareMap.getOrDefault(gridIndex, new HashSet<>());
                    squareSet.add(chRow);
                    squareMap.put(gridIndex,squareSet);
                }
            }
            setRow.clear();
            setCol.clear();
        }
        return true;
}
}