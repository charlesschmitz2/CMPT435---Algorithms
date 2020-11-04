public class BinarySearchTree {

    BinarySearchNode root;
    int totalComparisons = 0;
    int tempComparisons = 0;

    /*----addNode method----*/
    //S represents the node string that we will be inserting here
    //My Method
    public void addTreeNode(int key, String s){
        //initialize node
        BinarySearchNode newNode = new BinarySearchNode(key, s);

        //check to see if it is the root
        if (root == null){
            //if is root, then just need to add
            root = newNode;
        }//if
        else{
            //Traversing the Tree and adding to left child or right child
            //otherwise, create new node to focus on and set the root to this because always start at the root
            BinarySearchNode currNode = root;
            //create the parent node that will be set later for the currNode
            BinarySearchNode parent;
            //creating infinite while loop which will be broken out of with return
            while(true){
                //set parent which at this point is the root because we start at the root
                parent = currNode;

                //Check if the newNode should go on the left side
                //if < then we go to the left child
                if (key < currNode.key){
                    currNode = currNode.leftChild;

                    if (currNode == null){
                        parent.leftChild = newNode;
                        return; //to jump out of the while loop because node has been added
                    }//if
                }//if
                //Otherwise, newNode can go on the right side
                //if > then we go to the right child
                else {
                    currNode = currNode.rightChild;

                    if (currNode == null){
                        parent.rightChild = newNode;
                        return; //to jump out of the while loop because node has been added
                    }//if
                }//else
            }//while
        }//else
    }//addNode

    public void removeTreeNode(BinarySearchNode node){

    }

    //Method Discussed in Class--Cant seem to get to work quite right
    public void treeInsert(BinarySearchTree T, BinarySearchNode z, int key){
        BinarySearchNode trailingPointer = null;
        BinarySearchNode currNode = T.root; //Assign the root

        //Assign the parent
        while (currNode != null) {
            trailingPointer = currNode;

            if (z.key < currNode.key){
                currNode = currNode.leftChild;
            }//if
            else{
                currNode = currNode.rightChild;
            }//else

            z.parentNode = trailingPointer;
        }//while

        if (trailingPointer == null) {
            T.root = z;
        }//if
        else{
            if (z.key < trailingPointer.key){
                currNode.leftChild = z;
            }//if
            else{
                    currNode.rightChild = z;
            }//else
        }//else
    }//treeInsert

    /*----In order Traversal of Binary Tree----*/
    //Recursive method of traversing the binary search tree in order
    public void inOrderTraversal(BinarySearchNode currNode){
        if (currNode != null) {
            inOrderTraversal(currNode.leftChild);
            //print out each traversal so can visually confirm
            System.out.println(currNode);

            inOrderTraversal(currNode.rightChild);
        }

    }//inOrderTraversal

    public BinarySearchNode searchNode(int key){
        BinarySearchNode currNode = root;
        tempComparisons = 0;

        //Loop through until the key of the current node matches the key of the Node being searched
        while (currNode.key != key){
            tempComparisons++;
            if (key < currNode.key){
                tempComparisons++;
                currNode = currNode.leftChild;
            }//if
            else{
                tempComparisons++;
                currNode = currNode.rightChild;
            }//else

            //Node not found
            if (currNode == null) {
                return null;
            }//if
        }//while

        totalComparisons += tempComparisons;
        return currNode;
    }//BinarySearchNode

    public int getTotalComparisons(){
        return totalComparisons;
    }//getTotalComparisons
    public int getTempComparisons(){
        return tempComparisons;
    }//getTempComparisons;
    public void resetTotalComparisons(){
        totalComparisons = 0;
    }
    

}//BinarySearchTree
