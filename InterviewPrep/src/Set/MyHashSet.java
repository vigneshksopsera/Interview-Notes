package Set;

class MyHashSet {

    /** Initialize your data structure here. */
    private int capacity; 
    private int[] array;
    boolean[] visited;
    
    public MyHashSet() {
        this.capacity = 1000000;
        array = new int[this.capacity];
        visited = new boolean[this.capacity];
    }
    
    public void add(int key) {
        int idx = hashingFunction(key);
        if(visited[idx]) return;
        else {
            array[idx] = key;
            visited[idx] = true;
        }
    }
    
    public void remove(int key) {
        int idx = hashingFunction(key);
        visited[idx] = false;
        return;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int idx = hashingFunction(key);
        return visited[idx];
    }
    
    protected int hashingFunction(int key) {
        return key % this.capacity;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
