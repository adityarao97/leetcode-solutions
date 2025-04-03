class Node{
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    } 
}

class LRUCache {
    
    HashMap<Integer, Node> map;
    Node first;
    Node last;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.first = new Node(0, 0);
        this.last = new Node(0,0);
        this.first.next = this.last;
        this.last.prev = this.first;
    }

    public void insert(Node node) {
        Node prev = last.prev;
        prev.next = node;
        node.prev = prev;
        node.next = last;
        last.prev = node;
    }

    public void remove(Node node){
        Node before = node.prev;
        Node after = node.next;
        before.next = after;
        after.prev = before;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        //if map already has the key remove it from position and append it to end of list
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        insert(newNode);
        //if capacity is reached remove last element from list and then from map
        if(map.size()>capacity){
            Node node = this.first.next;
            remove(node);
            map.remove(node.key);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */