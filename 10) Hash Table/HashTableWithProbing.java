class HashTableWithProbing {
    Student[] array;
    int size;
    int occupied = 0;
    int a;

    // Constructors :
    public HashTableWithProbing(int size) {
        this.size = size;
        array = new Student[this.size];
        a = optimalA(this.size);
    }

    // Methods :
    public void add(Student obj) {
        int x = 0;
        int index = (this.hash(obj) + this.linearProbing(x)) % this.size;
        while (array[index] != null) {
            x++;
            index = (this.hash(obj) + this.linearProbing(x)) % this.size;
        }
        this.array[index] = obj;
    }

    public int hash(Student obj) {
        return obj.id;
    }

    // VARIOUS PROBING FUNCTIONS.
    public int linearProbing(int x) {
        return this.a * x;
        // in this case to prevent cycles, a and this.size have to be relatively prime.
    }

    public int quadraticProbing1(int x) {
        return ((this.a * x * x) + x) / 2;
        // in this schem of quadraticProbing, the table size has to be power of 2.
    }

    public int quadraticProbing2(int x) {
        return x * x;
        // in this the size of the table has to be a prime number greater than 3 to
        // prevent cycles
    }

    // Helper Methods :
    private int optimalA(int size) // we need to find a such that the size and a, both have a and N have a GCD of 1
    {
        int i = 1;
        while (gcd(i, size) != 1)// makes sure that a & size have gcd of 1 and this function is called everytime
                                 // hash table is expanded in size.
        {
            i++;
        }
        return i;
    }

    private int gcd(int a, int b)// generates the highest common dinominator for two numbers
    {
        int temp = 1;
        for (int i = 1; i <= (a > b ? b : a); i++) {
            if (a % i == 0 && b % i == 0) {
                temp = i;
            }
        }
        return temp;
    }

    boolean threasholdCheck()// to maintain occupied/size ration to 0.6
    {
        if ((float) (occupied) / (float) size > 0.6f) {
            return false;
        }
        return true;
    }
}
// Probing is hopping within the range of hash table array in order to find the
// optimal posisions based on the probing function.
// we feed out probing function an incrementing number every time its called in
// order for it to give us the incremented probe value.
// P(x) = ax function, note that x is incrementing and 'a' is a variable whose
// values is determined by the size of array table
// in linear probing(P(x) = ax) we need to make sure that 'a' and 'size'(size of
// table/array) have the HCD as 1 for preventing cycles in probing functions.
// Hence the value of a will change based on the value of size of array.

// Relatively Prime : when two numbers have GCD of 1.

// BETTER ALTERNATIVE :
// Another thing that can be done is, we can increase the size of the table
// based on the probing function a value, we can increase the value such that
// the a in the
// probing function dosent have to change at all instead we change the size such
// that a and new size are Relatively prime.
// Alco upon making a new table of bigger size, we have to actually reassign the
// values from old table into the new one and they will be at new positions.