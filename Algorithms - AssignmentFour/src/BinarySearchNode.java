public class BinarySearchNode {

    String key;
    int s;

    BinarySearchNode leftChild;
    BinarySearchNode rightChild;
    BinarySearchNode parentNode;

    BinarySearchNode(String key, int s){
        this.key = key;
        this.s = s;
    }//BinarySearchNode

    public String toString(){
        return "'" + key + "'" + " ---- " + s;
    }




}//BinarySearchNode
