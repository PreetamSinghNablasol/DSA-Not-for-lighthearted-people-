class DoubleHashing {
    Map[] hashTable;
    int size = 7; // table size has to be maintained prime.
    int occupied;
    Map tombStone = new Map(-101, -101);
    double loadFacatorThreshold = 0.6;

    // Constructor :
    public DoubleHashing() {
        this.hashTable = new Map[size];
        this.occupied = 0;
    }

    // Mehods :

    public void add(Map object) {
        int x = 1;
        int index = hashFunction1(object.key);
        while (hashTable[index] != null) {
            if (probingFunction(object.key) != 0) {
                index = (hashFunction1(object.key) + x * probingFunction(object.key)) % this.size;
            }
            if (probingFunction(object.key) == 0) {
                index = (hashFunction1(object.key) + x) % this.size;
            }
            x++;
        }
        hashTable[index] = object;
        this.occupied++;
        this.loadFactor();
    }

    public int hashFunction1(int key)// a double hash function
    {
        return key * key;
    }

    public int hashFunction2(int key) {
        return key;
    }

    public int probingFunction(int k) {
        int delta = (hashFunction2(k)) % this.size;
        return delta;
    }

    public void loadFactor() {
        double loadFactor = (double) this.occupied / (double) this.size;
        if (loadFactor >= this.loadFacatorThreshold) {
            this.resize();
        }

    }

    public void resize() {

    }

}