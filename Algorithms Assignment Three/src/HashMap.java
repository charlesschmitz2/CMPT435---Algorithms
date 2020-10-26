import java.util.ArrayList;

public class HashMap<K, V> {
    //here we could use an array and have it manually set to the size of our hash table which we know, but I chose to use array list because
    //it is more flexible and not fixed. Number of buckets is the capacity of the array list here.
    private ArrayList<HashNode<K,V>> arrBucket;
    private int numberOfBuckets;
    private int size;
    //buckets refer to the initial spaces that will be a "bucket" aka linked list pointing to multiple elements of the same value


    public HashMap(){
        arrBucket = new ArrayList<>();
        numberOfBuckets = 250;
        size = 0;

        //initialize all of the buckets in the array to be null
        for (int i = 0; i < numberOfBuckets; i++){
            arrBucket.add(null);
        }//for
    }//Constructor for hashMap

    private int getBucketIndex(K key){
        //here to get the Index of the bucket I pass the K object Key (which we know to be a string so I cast it to that) and get the hashCode of it
        //using the makeHashCode given to us
        int hashCode = makeHashCode((String) key);
        int index = hashCode() % numberOfBuckets;

        return index;
    }//getBucketIndex

    public V remove (K key){
        int bucketIndex = getBucketIndex(key);

        HashNode<K,V> head = arrBucket.get(bucketIndex);
        HashNode<K,V> prev = null;
    //looking for key in the chain
        while (head != null){
            if(head.key.equals(key)){
                break;
            }//if

            prev = head;
            head = head.next;
        }//while

    //key not there
        if (head == null){
            return null;
        }//if

    //reduce size
        size--;

    //Remove Key
        if(prev != null){
            prev.next = head.next;
        }//if
        else{
            arrBucket.set(bucketIndex, head.next);
        }//else

        return head.value;

    }//remove

    public V get(K key){
        //get head
        int bucketIndex = getBucketIndex(key);
        HashNode<K,V> head = arrBucket.get(bucketIndex);

        //while head is not null, search for the key
        while(head != null){
            if (head.key.equals(key)){
                return head.value;
            }//if

            head = head.next;
        }//while

        return null; //if the key is not found
    }//get

    public void put(K key, V value) {
        //get head
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = arrBucket.get(bucketIndex);

        //while head is not null, search for key
        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }//if

            head = head.next;
        }//while

        //Add key
        size++;
        head = arrBucket.get(bucketIndex);
        HashNode<K,V> newHashNode = new HashNode<K,V>(key,value);
        newHashNode.next = head;
        arrBucket.set(bucketIndex, newHashNode);

        //there is possibility that the threshold of the number of buckets can be reached and you should need to increase the size of the hashtable
        //since we are working with a defined set of values its not entirely necessary here but can be implemented anyways
        if ((1.0*size)/numberOfBuckets >= 0.7) {
            ArrayList<HashNode<K, V>> temp = arrBucket;
            arrBucket = new ArrayList<>();
            numberOfBuckets = 2 * numberOfBuckets;
            size = 0;
            for (int i = 0; i < numberOfBuckets; i++)
                arrBucket.add(null);

            for (HashNode<K, V> headNode : temp) {
                while (headNode != null) {
                    put(headNode.key, headNode.value);
                    headNode = headNode.next;
                }//while
            }//for
        }//if
    }//put

    public int makeHashCode(String str) {
        str = str.toUpperCase();
        int length = str.length();
        int letterTotal = 0;

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

    public int getSize(){
        return size;
    }//getSize

    public boolean isEmpty(){
        return (size == 0);
    }//isEmpty

}
