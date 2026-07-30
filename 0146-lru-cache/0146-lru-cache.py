class Node:
    def __init__(self, key = None, value = None):
        self.key, self.value = key, value
        self.before, self.after = None, None 

class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.cache = {}
        self.first, self.last = Node(), Node()
        self.first.after, self.last.before = self.last, self.first

    def insert(self, node):
        cur = self.last.before
        cur.after = node
        node.before = cur
        node.after = self.last
        self.last.before = node

    def delete(self, node):
        before, after = node.before, node.after
        before.after, after.before = after, before

    def get(self, key: int) -> int:
        if key in self.cache:
            node = self.cache[key]
            self.delete(node)
            self.insert(node)
            return node.value
        return -1   
        
    def put(self, key: int, value: int) -> None:
        if key in self.cache:
            node = self.cache[key]
            self.delete(node)
        node = Node(key, value)
        self.insert(node)
        self.cache[key] = node
        if len(self.cache) > self.capacity:
            lru_node = self.first.after
            del self.cache[lru_node.key]
            self.delete(lru_node)

# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)