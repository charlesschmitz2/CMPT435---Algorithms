public class BinarySearchNode {

    int key;
    String s;

    BinarySearchNode leftChild;
    BinarySearchNode rightChild;
    BinarySearchNode parentNode;

    BinarySearchNode(int key, String s){
        this.key = key;
        this.s = s;
    }//BinarySearchNode

    public String toString(){
        return s + " has a key " + key;
    }


}//BinarySearchNode
