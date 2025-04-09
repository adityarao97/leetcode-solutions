/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Pair{
    int val;
    int row;
    Pair(int row, int val){
        this.row = row;
        this.val = val;
    }
}

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        Queue<Integer> rows = new LinkedList<>();
        //Map to store pairs against each level, each pair contains nodes row and value
        Map<Integer, ArrayList<Pair>> map = new HashMap<>();
        queue.offer(root);
        cols.offer(0);
        rows.offer(0);
        int max = 0, min = 0;
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            int col = cols.poll();
            int row = rows.poll();
            //initialize the map with empty array if no entry exist for a column value
            if(!map.containsKey(col)){
                map.put(col, new ArrayList<Pair>());
            }
            //insert the pair(row-val) object against the current col
            map.get(col).add(new Pair(row, node.val));
            if(node.left!=null) {
                queue.offer(node.left);
                cols.offer(col - 1);
                rows.offer(row + 1);
                min = Math.min(min, col - 1);
            }
            if(node.right!=null) {
                queue.offer(node.right);
                cols.offer(col + 1);
                rows.offer(row + 1);
                max = Math.max(max, col + 1);
            }
        }
        for(int i=min; i<=max; i++){
            ArrayList<Pair> tempList = map.get(i);
            //sort the pair list, if row is same sort on basis of value else on row
            Collections.sort(tempList, (a,b) -> (a.row==b.row) ? Integer.compare(a.val, b.val) : Integer.compare(a.row, b.row));
            list.add(tempList.stream().map(pair -> pair.val).collect(Collectors.toList()));
        }
        return list;
    }
}