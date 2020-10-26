public class Entry {

    String key;
    int value;
    Entry next;

    /* Constructor */
    Entry(String key, int value)
    {
        this.key = key;
        this.value = value;
        this.next = null;
    }

}