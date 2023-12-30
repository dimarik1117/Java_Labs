class Entry<K, V> {
    K entryK;
    V entryV;
    public Entry() {
        entryK = null;
        entryV = null;
    }
    public Entry(K key, V value) {
        entryK = key;
        entryV = value;
    }
    public K getKey() {
        return entryK;
    }

    public V getValue() {
        return entryV;
    }

    public void setValue(V value) {
        entryV = value;
    }
}