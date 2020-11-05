import java.io.File;
import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Scanner;

public class AlgorithmsAssignmentFour {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();

        /*----Adding to File, Creating magicitems and randomMagicItems array,Testing it----*/
                //Declare Variables, in this case the strings that will be used throughout main
                String[] magicitems = readArray("magicitems.txt");
                String[] randomMagicItems = new String[42];

                //Randomly select 42 items within the magic items list, hold onto these values in a new array
                //Unique Numbers will be an array of value 0-666 all unique and in a random order, from this the first 42 can be used as an index value for the magic items to have 42 random and unique value
                //Each time the program is rerun new random values are generated but during the duration of the program the random elements remain the same
                int[] uniqueNumbers = createUniqueRandomNumber(0,665);

                for(int i = 0; i < randomMagicItems.length; i++){
                    int temp = uniqueNumbers[i];
                    String temp2 = null;
                    if (magicitems != null) {
                        temp2 = magicitems[temp];
                    }

                    randomMagicItems[i]= temp2;
                }

            /*
                System.out.println("All Elements in Array MagicItems: ");
                    for(int i = 0; i < magicitems.length; i++){
                        System.out.println(magicitems[i]);
                    }//for
                System.out.println("\n--------Randomly Selected 42 Elements in Array-------- ");
                    for (int i = 0; i < randomMagicItems.length; i++) {
                        System.out.println(randomMagicItems[i] + ", ");
                    }
             */
        /*-----------------------------------------------------------------------------*/

        /*----Adding all the Nodes to the Tree ----*/
        //root is determined in the order they are added to the tree,
        //first addNode is the root and everything else stems from that
        for (int i = 0; i < magicitems.length; i++){
            String keyInsert = magicitems[i];
            tree.addTreeNode(keyInsert, i);
        }//for

        /*-----------------------------------------------------------------------------*/

            //Testing :
                //Traverse and print out them inOrder, preOrder, and postOrder starting at the root of the tree
                tree.inOrderTraversal(tree.root);
                //System.out.println("");
                //tree.preOrderTraversal(tree.root);
                //System.out.println("");
                //tree.postOrderTraversal(tree.root);
/*

    //Keep getting null pointer exception likely due to line 83 and 86
    //when trying to set currNode to left or right child
            BinarySearchTree newTree = new BinarySearchTree();
            BinarySearchNode nodeInsert = new BinarySearchNode(50, "Boss");
            newTree.treeInsert(newTree, nodeInsert, nodeInsert.key);
            BinarySearchNode nodeInsert2 = new BinarySearchNode(25, "VicePresident");
            newTree.treeInsert(newTree, nodeInsert2, nodeInsert2.key);
            BinarySearchNode nodeInsert3 = new BinarySearchNode(15, "Office Manager");
            newTree.treeInsert(newTree, nodeInsert3, nodeInsert3.key);
            BinarySearchNode nodeInsert4 = new BinarySearchNode(30, "Secretary");
            newTree.treeInsert(newTree, nodeInsert4, nodeInsert4.key);
            BinarySearchNode nodeInsert5 = new BinarySearchNode(75, "Sales Manager");
            newTree.treeInsert(newTree, nodeInsert5, nodeInsert5.key);

            tree.inOrderTraversal(newTree.root);
 */
        //Testing :
            System.out.println("\nSearch for Hectorius's Twin Rings");
            System.out.println(tree.searchNode("UFO tofu"));
            System.out.println(tree.getTempComparisons());
            System.out.println(tree.getTotalComparisons());

        tree.print2D(tree.root);
    }//main

    //A function that will take in a string parameter that is the name of the file and copy the contents into an array
    //Assumes one element per line
    public static String[] readArray(String file){
        int count = 0;

        try{
            Scanner s1 = new Scanner(new File(file));

            //Count how many elements are in the file
            while(s1.hasNextLine()){
                count++;
                s1.nextLine();
            }//while

            //Create the array and copy elements into it
            String[] words = new String[count];

            Scanner s2 = new Scanner(new File(file));
            for(int i = 0; i < count; i++){
                words[i]=s2.nextLine();
            }

            return words;
        }//try
        catch (FileNotFoundException e){

        }

        return null;
    }//readString

    //A function that will create a list of random unique numbers between the desired range
    public static int[] createUniqueRandomNumber(int from, int to){
        //Number of integers need to generate
        int n = to - from + 1;

        //Create an array to store all the numbers from, from - to
        int array[] = new int[n];
        for (int i = 0; i < n; i++){
            array[i] = i;
        }//for

        //Create an array to store the result
        int result[] = new int[n];

        int x = n;
        SecureRandom rd = new SecureRandom();
        for(int i = 0; i < n; i++){
            //k is a random index in [0, x]
            int k = rd.nextInt(x);

            result[i] = array[k];

            //Replace value from a[k] by the value from the last index
            //so that there will not get the value array[k] again
            array[k] = array[x-1];

            //Decrease x by 1 to get a random index from 0 to x only
            x--;
        }

        return result;
    }//UniqueRandomNumber

}//AlgorithmsAssignmentFour
