public class HashTable {
    private int TABLE_SIZE;
    private int size;
    private Entry[] table;

    /* Constructor */
    public HashTable(int tableSize)
    {
        size = 0;
        TABLE_SIZE = tableSize;
        table = new Entry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }
    /* Function to get number of key-value pairs */
    public int getSize()
    {
        return size;
    }
    /* Function to clear hash table */
    public void empty()
    {
        for (int i = 0; i < TABLE_SIZE; i++)
            table[i] = null;
    }
    /* Function to get value of a key */
    public int get(String key)
    {
        int hash = (makeHashCode( key ) % TABLE_SIZE);
        if (table[hash] == null)
            return -1;
        else
        {
            Entry entry = table[hash];
            while (entry != null && !entry.key.equals(key))
                entry = entry.next;
            if (entry == null)
                return -1;
            else
                return entry.value;
        }
    }
    /* Function to insert a key value pair */
    public void insert(String key, int value)
    {
        int hash = (makeHashCode( key ) % TABLE_SIZE);
        if (table[hash] == null)
            table[hash] = new Entry(key, value);
        else
        {
            Entry entry = table[hash];
            while (entry.next != null && !entry.key.equals(key))
                entry = entry.next;
            if (entry.key.equals(key))
                entry.value = value;
            else
                entry.next = new Entry(key, value);
        }
        size++;
    }

    public void remove(String key)
    {
        int hash = (makeHashCode( key ) % TABLE_SIZE);
        if (table[hash] != null)
        {
            Entry prevEntry = null;
            Entry entry = table[hash];
            while (entry.next != null && !entry.key.equals(key))
            {
                prevEntry = entry;
                entry = entry.next;
            }
            if (entry.key.equals(key))
            {
                if (prevEntry == null)
                    table[hash] = entry.next;
                else
                    prevEntry.next = entry.next;
                size--;
            }
        }
    }

    /* Function to print hash table */
    public void printHashTable()
    {
        for (int i = 0; i < TABLE_SIZE; i++)
        {
            System.out.print("\nBucket "+ (i) +" : ");
            Entry entry = table[i];
            while (entry != null)
            {
                System.out.print(" | " + entry.value + " - " + entry.key + " |");
                entry = entry.next;
            }
        }
    }

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

        }

        // Scale letterTotal to fit in HASH_TABLE_SIZE.
        int hashCode = (letterTotal * 1) % 250;  // % is the "mod" operator
        // TODO: Experiment with letterTotal * 2, 3, 5, 50, etc.

        return hashCode;
    }//makeHashCode
}
