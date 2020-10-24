
public class HashTable<T> {
    Entry[] arrayHash;
    int size;

    public HashTable(int size){
        this.size = size;
        arrayHash = new Entry[size];

        //initialize all the elements of the hash table to null
        for (int i = 0; i < size; i++){
            arrayHash[i] = new Entry();
        }//for
    }//HashTable

    public int getHash(int key){
        return key%size;
    }//get hash

    public void put(int key, Object value){
    //get the hash for the key, once know where in the list the item is there could be multiple items at that point
    //so make sure pointing to correct item
        int hashIndex = getHash(key);
        Entry arrValue = arrayHash[hashIndex];
        Entry newItem = new Entry(key, value);

        newItem.next = arrValue.next;
        arrValue.next = newItem;
    }//put

    public T get(int key){
        T value = null;
        //using T here but we do know that it will be a list of strings in our case

        int hashIndex = getHash(key);
        Entry arrValue = arrayHash[hashIndex];

        while(arrValue != null){
            if (arrValue.getKey() == key){
                value = (T) arrValue.getValue();
                break;
            }//if
            arrValue = arrValue.next;
        }//while

        return value;
    }//get
}
