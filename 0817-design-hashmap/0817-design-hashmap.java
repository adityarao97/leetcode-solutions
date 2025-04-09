class Node{
    int key;
    int val;
    Node next;
    Node(){
        this(-1, -1, null);
    }

    Node(int key, int val, Node next){
        this.key = key;
        this.val = val;
        this.next = next;
    }
}

class MyHashMap {

    private static Node[] map;

    private static int hash(int key){
        return key % map.length;
    }

    public MyHashMap() {
        map = new Node[1000];
        for(int i=0;i<1000;i++){
            map[i]=new Node();
        }
    }
    
    public void put(int key, int value) {
        Node cur = map[hash(key)];
        while(cur.next!=null){
           if(cur.next.key == key){
            cur.next.val = value;
            return;
           }
           cur = cur.next;
        }
        cur.next = new Node(key, value, null);
    }
    
    public int get(int key) {
        Node cur = map[hash(key)];
        while(cur!=null){
            if(cur.key == key) return cur.val;
            cur = cur.next;
        }
        return -1;
    }
    
    public void remove(int key) {
        Node cur = map[hash(key)];
        while(cur.next!=null){
            if(cur.next.key == key){
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */