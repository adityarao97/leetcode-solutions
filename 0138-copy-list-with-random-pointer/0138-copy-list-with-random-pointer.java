/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        //hashmap which maps node from original to a copy
        Map<Node, Node> map = new HashMap<>();
        map.put(null, null);
        Node cur = head;
        //first pass to do a deep copy of individual nodes without any link and map it to original node in hashmap
        while(cur!=null){
            Node copy = new Node(cur.val);
            map.put(cur, copy);
            cur = cur.next;
        }
        cur = head;
        //second pass to copy the links based out of original nodes
        while(cur!=null){
            Node copy = map.get(cur);
            copy.next = map.get(cur.next);
            copy.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }
}