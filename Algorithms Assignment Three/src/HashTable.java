public class HashTable {
    private int HASH_TABLE_SIZE;
    private int size;
    private Entry[] hashTable;
    private int totalComparisons;
    private int tempComparisons;

    /* Constructor */
    public HashTable(int tableSize)
    {
        size = 0;
        HASH_TABLE_SIZE = tableSize;
        hashTable = new Entry[HASH_TABLE_SIZE];
        tempComparisons = 0;
        totalComparisons = 0;
        for (int i = 0; i < HASH_TABLE_SIZE; i++)
            hashTable[i] = null;
    }//Constructor

    //Gets the size of the HashTable
    public int getSize()
    {
        return size;
    }//getSize

    //Clears/Empties the hash table by setting all values in it to null, could also be used to initialize all values to null
    public void empty()
    {
        for (int i = 0; i < HASH_TABLE_SIZE; i++)
            hashTable[i] = null;
    }//empty

    //Gets the Value of a Key
    public int get(String key)
    {
        tempComparisons = 0;
        int hash = (makeHashCode( key ) % HASH_TABLE_SIZE);
        if (hashTable[hash] == null) {
            tempComparisons++;
            totalComparisons += tempComparisons;
            System.out.print("Comparisons to Get : " + tempComparisons);
            return -1;
        }//if
        else
        {
            Entry entry = hashTable[hash];
            while (entry != null && !entry.key.equals(key)) {
                tempComparisons++;
                entry = entry.next;
            }//while

            totalComparisons += tempComparisons;

            if (entry == null) {
                System.out.print("Comparisons to Get : " + tempComparisons);
                return -1;
            }//if
            else {
                System.out.print("Comparisons to Get : " + tempComparisons);
                return entry.value;
            }//else
        }//else
    }//get

    //Inserts a new entry into the hashTable
    public void put(String key, int value)
    {
        int hash = (makeHashCode( key ) % HASH_TABLE_SIZE);

        if (hashTable[hash] == null) {
            hashTable[hash] = new Entry(key, value);
        }//if
        else
        {
            Entry entry = hashTable[hash];
            while (entry.next != null && !entry.key.equals(key)) {
                entry = entry.next;
            }//while
            if (entry.key.equals(key)) {
                entry.value = value;
            }//if
            else {
                entry.next = new Entry(key, value);
            }//else
        }//else

        size++;
    }//put

    //Removes an entry from the hashTable
    public void remove(String key)
    {
        int hash = (makeHashCode( key ) % HASH_TABLE_SIZE);
        if (hashTable[hash] != null)
        {
            Entry prevEntry = null;
            Entry entry = hashTable[hash];

            while (entry.next != null && !entry.key.equals(key))
            {
                prevEntry = entry;
                entry = entry.next;
            }//while
            if (entry.key.equals(key))
            {
                if (prevEntry == null) {
                    hashTable[hash] = entry.next;
                }//if
                else {
                    prevEntry.next = entry.next;
                }//else

                size--;
            }//if
        }//if
    }//remove

    public int getTempComparisons(){
        return tempComparisons;
    }
    public int getTotalComparisons(){
        return totalComparisons;
    }


    //Prints the entire hashTable out listing the values in each bucket
    public void printHashTable()
    {
        for (int i = 0; i < HASH_TABLE_SIZE; i++)
        {
            System.out.print("\nBucket "+ (i) +" : ");

            Entry entry = hashTable[i];

            while (entry != null)
            {
                System.out.print(" | **" + entry.value + " - " + entry.key + " |");
                entry = entry.next;
            }//while
        }//for
    }//printHashTable


    public int makeHashCode(String str) {
        str = str.toUpperCase();
        int length = str.length();
        int letterTotal = 0;
        //System.out.println(" ");
        //System.out.print(str + " - ");

        // Iterate over all letters in the string, totalling their ASCII values.
        for (int i = 0; i < length; i++) {
            char thisLetter = str.charAt(i);
            int thisValue = (int)thisLetter;
            letterTotal = letterTotal + thisValue;
/*
            // Test: print the char and the hash.

            System.out.print(" [");
            System.out.print(thisLetter);
            System.out.print(thisValue);
            System.out.print("] ");
            //
*/

        }//for

        // Scale letterTotal to fit in HASH_TABLE_SIZE.
        int hashCode = (letterTotal * 1) % 250;  // % is the "mod" operator
        // TODO: Experiment with letterTotal * 2, 3, 5, 50, etc.

        return hashCode;
    }//makeHashCode
}
