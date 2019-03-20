package HashMap;

class MyHashMap {

    /** Initialize your data structure here. */
    Entry[] map;
    public MyHashMap() {
        map = new Entry[1000];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = Integer.hashCode(key) % map.length;
        if(map[index] == null) map[index] = new Entry(0, 0);
        Entry curr = map[index];
        Entry prev = null;
        while(curr != null && curr.key != key) {
            prev = curr;
            curr = curr.next;
        }
        if(curr == null) prev.next = new Entry(key, value);
        else curr.val = value;
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int index = Integer.hashCode(key) % map.length;
        Entry curr = map[index];
        while(curr != null && curr.key != key) curr = curr.next;
        if(curr == null) return -1;
        else return curr.val;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = Integer.hashCode(key) % map.length;
        Entry curr = map[index];
        Entry prev = null;
        while(curr != null && curr.key != key){
            prev = curr;
            curr = curr.next;
        }
        if(curr != null) prev.next = curr.next; 
    }
    class Entry {
        int key, val;
        Entry next;
        public Entry(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
}
