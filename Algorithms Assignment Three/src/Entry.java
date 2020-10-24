public class Entry {
    int key;
    Object value;
    Entry next;

    public Entry(int key, Object value){
        this.key = key;
        this.value = value;
        next = null;
    }//constructor

    public Entry(){
        next = null;
    }//constructor

    public int getKey(){
        return key;
    }//getKey

    public Object getValue() {
        return value;
    }//getValue
}
