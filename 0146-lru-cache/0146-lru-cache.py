class Node:
    def __init__(self, key, val):
        self.key, self.val = key, val
        self.prev = self.next = None

class LRUCache:

    def __init__(self, capacity: int):
        self.capacity = capacity
        self.map = {} #map of key against nodes
        self.left, self.right = Node(0, 0), Node(0, 0) #left is least frequently used and right is most frequently used
        self.left.next, self.right.prev = self.right, self.left

    #remove node
    def remove(self, node):
        prev, after = node.prev, node.next
        prev.next, after.prev = after, prev

    #insert at the right
    def insert(self, node):
        prev, right = self.right.prev, self.right
        prev.next = right.prev = node
        node.prev, node.next = prev, right

    def get(self, key: int) -> int:
        if key in self.map:
            self.remove(self.map[key])
            self.insert(self.map[key])
            return self.map[key].val
        return -1

    def put(self, key: int, value: int) -> None:
        if key in self.map:
            self.remove(self.map[key])
        node = Node(key, value)
        self.insert(node)
        self.map[key] = node
        if len(self.map) > self.capacity:
            lru = self.left.next
            self.remove(lru)
            del self.map[lru.key]
# Your LRUCache object will be instantiated and called as such:
# obj = LRUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)