public class BinarySearchTree {

    BinarySearchNode root;
    int totalComparisons = 0;
    int tempComparisons = 0;

    /*----addNode method----*/
    //S represents the node integer number of that node, so 0-665 since we have 666
    //My Method
    public void addTreeNode(String key, int s){
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
                //if key is < the key of the current/focus node then we go to the left child
                if (key.compareToIgnoreCase(currNode.key) < 0){
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

            if (z.key.compareToIgnoreCase(currNode.key) < 0){
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
            if (z.key.compareToIgnoreCase(trailingPointer.key) < 0){
                currNode.leftChild = z;
            }//if
            else{
                    currNode.rightChild = z;
            }//else
        }//else
    }//treeInsert

    /*----In order Traversal of Binary Tree----*/
    //Recursive method of traversing the binary search tree in order
    //This aims fort the smallest Node value first then moves up from there
    public void inOrderTraversal(BinarySearchNode currNode){
        if (currNode != null) {
            inOrderTraversal(currNode.leftChild);
            //print out each traversal so can visually confirm
            System.out.println(currNode);

            inOrderTraversal(currNode.rightChild);
        }//if

    }//inOrderTraversal

    //Cycle down through left children first
    //Jump up one parent, then go to right child, jump up to root eventually and go through right children
    public void preOrderTraversal(BinarySearchNode currNode){
        if (currNode != null) {
            //print out each traversal so can visually confirm
            System.out.println(currNode);

            preOrderTraversal(currNode.leftChild);

            preOrderTraversal(currNode.rightChild);
        }//if
    }//preOrderTraversal

    //root or node will come last
    public void postOrderTraversal(BinarySearchNode currNode){
        if (currNode != null) {
            //print out each traversal so can visually confirm

            postOrderTraversal(currNode.leftChild);

            postOrderTraversal(currNode.rightChild);

            System.out.println(currNode);
        }//if
    }//postOrderTraversal

    /*----Tree Search for a key element within the tree----*/
    public BinarySearchNode searchNode(String key){
        BinarySearchNode currNode = root;
        tempComparisons = 0;

        //Loop through until the key of the current node matches the key of the Node being searched
        while (currNode.key != key){
            tempComparisons++;
            if (key.compareToIgnoreCase(currNode.key) < 0){
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


    /*----********THIS BELOW IS NOT MY CODE*******----*/
    //FULL CREDIT TO https://www.geeksforgeeks.org/print-binary-tree-2-dimensions/
    //I used this to help me visualize the binary tree

    // Function to print binary tree in 2D
    // It does reverse inorder traversal
    static final int COUNT = 10;
    public void print2DUtil(BinarySearchNode root, int space)
    {
        // Base case
        if (root == null)
            return;

        // Increase distance between levels
        space += COUNT;

        // Process right child first
        print2DUtil(root.rightChild, space);

        // Print current node after space
        // count
        System.out.print("\n");
        for (int i = COUNT; i < space; i++)
            System.out.print("- ");
        System.out.print(root.key + "\n");

        // Process left child
        print2DUtil(root.leftChild, space);
    }

    // Wrapper over print2DUtil()
    public void print2D(BinarySearchNode root)
    {
        // Pass initial space count as 0
        print2DUtil(root, 0);
    }
    

}//BinarySearchTree
