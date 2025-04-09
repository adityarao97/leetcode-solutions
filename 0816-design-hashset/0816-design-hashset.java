class Node{
    int key; 
    Node next;
    Node(int key, Node next){
        this.key = key;
        this.next = next;
    }
    Node(){
        this(-1, null);
    }
}

class MyHashSet {

    private static Node[] set;

    private static int hash(int key){
        return key % set.length;
    }

    public MyHashSet() {
        set = new Node[1000];
        for(int i=0;i<1000;i++)
            set[i] = new Node();
    }
    
    public void add(int key) {
        Node cur = set[hash(key)];
        while(cur.next!=null){
            if(cur.next.key == key) return;
            cur = cur.next;
        }
        cur.next = new Node(key, null);
    }
    
    public void remove(int key) {
        Node cur = set[hash(key)];
        while(cur.next!=null){
            if(cur.next.key==key){
                cur.next = cur.next.next;
                return;
            }
            cur = cur.next;
        }
    }
    
    public boolean contains(int key) {
        Node cur = set[hash(key)];
        while(cur!=null){
            if(cur.key==key) return true;
            cur = cur.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */