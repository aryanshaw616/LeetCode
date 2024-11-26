class MyHashMap {
    private static final int CAPACITY = 1009; // A prime number for better distribution

    private List<Entry>[] buckets;

    // Entry class to store key-value pairs
    private class Entry {
        int key;
        int value;
        Entry next;

        Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        buckets = new List[CAPACITY];
    }

    private int hash(int key) {
        return key % CAPACITY;
    }

    public void put(int key, int value) {
        int index = hash(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }
        
        // Check if the key already exists, and update the value if it does.
        for (Entry entry : buckets[index]) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }
        
        // If the key doesn't exist, add it to the list.
        buckets[index].add(new Entry(key, value));
    }

    public int get(int key) {
        int index = hash(key);
        if (buckets[index] == null) {
            return -1;
        }
        
        // Search for the key in the list and return its value if found.
        for (Entry entry : buckets[index]) {
            if (entry.key == key) {
                return entry.value;
            }
        }
        
        return -1; // Key not found.
    }

    public void remove(int key) {
        int index = hash(key);
        if (buckets[index] == null) {
            return;
        }
        
        // Search for the key in the list and remove it if found.
        Iterator<Entry> iterator = buckets[index].iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            if (entry.key == key) {
                iterator.remove();
                return;
            }
        }
    }
}