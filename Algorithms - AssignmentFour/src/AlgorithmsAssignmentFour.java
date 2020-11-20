import java.io.File;
import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AlgorithmsAssignmentFour {

    public static Graph graph;
    public static GraphMatrix graphMatrix;
    public static GraphLinkedObjects graphLinkedObjects;

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

        /*----Searching for the 42 RandomMagicItems within Magicitems----*/

    System.out.println("\n--------Binary Search Tree--------\n");
        for (int i = 0; i < randomMagicItems.length; i++){
            String searchKey = randomMagicItems[i];
            tree.searchNode(searchKey);
            System.out.println("\t\u2022Searching For -> " + searchKey);
            System.out.println("\t\tComparisons to Find : " + tree.getTempComparisons() + "\n");
        }//for

        System.out.println("**Total Comparisons : " + tree.getTotalComparisons());
        double avgBinarySearchVal = tree.getTotalComparisons()/42.0;
        System.out.println("**Average Comparisons (Total/42) : " + new DecimalFormat("0.00").format(avgBinarySearchVal));

        /*-----------------------------------------------------------------------------*/

        //Use this to print out an "Image" of what the tree would look like
        //tree.print2D(tree.root);


        /*----Undirected Graphs---*/

        String[] graphInstructions = readArray("graphs1.txt");
        //System.out.println(graphInstructions.length);
        ArrayList<Integer> vertexList1 = new ArrayList<Integer>();
        ArrayList<Integer> vertexList2 = new ArrayList<Integer>();
        ArrayList<Integer> vertexList3 = new ArrayList<Integer>();
        ArrayList<Integer> vertexList4 = new ArrayList<Integer>();
        ArrayList<Integer> vertexList5 = new ArrayList<Integer>();
        ArrayList<Integer> edgeList1 = new ArrayList<Integer>();
        ArrayList<Integer> edgeList2 = new ArrayList<Integer>();
        ArrayList<Integer> edgeList3 = new ArrayList<Integer>();
        ArrayList<Integer> edgeList4 = new ArrayList<Integer>();
        ArrayList<Integer> edgeList5 = new ArrayList<Integer>();



        int graphNum = 0;
        String graphName = "NONE";
        for (int i = 0; i < graphInstructions.length; i++){

            //System.out.println(graphInstructions[i]);


            if(graphInstructions[i].toLowerCase().contains("new".toLowerCase())){
                graphNum++;
                graphName = graphInstructions[i-1];
                System.out.println("\n\u2022 CREATING NEW GRAPH : " + graphName + " -- "+ "Graph Number: " + graphNum);
            }//if
            else if (graphInstructions[i].toLowerCase().contains("edge".toLowerCase()) && !(graphInstructions[i].toLowerCase().contains("undirected".toLowerCase()))){
                int edge1 = 0;
                String edge1String = "";
                int edge2 = 0;
                String edge2String = "";
                int switchEdgeNum = 0;
                for (int y = 0; y < graphInstructions[i].length(); y++){
                    if(Character.isDigit(graphInstructions[i].charAt(y)) || graphInstructions[i].charAt(y) == '-'){
                        if (graphInstructions[i].charAt(y) == '-'){
                            switchEdgeNum = 1;
                            y++;
                        }

                        if(switchEdgeNum == 0){
                            String edge1DigitTemp = String.valueOf(graphInstructions[i].charAt(y));
                            edge1String = edge1String.concat(edge1DigitTemp);
                            //System.out.println("Setting Edge1 as " + graphInstructions[i].charAt(y));
                        }//if
                        else if(switchEdgeNum == 1 && graphInstructions[i].charAt(y) != ' '){
                            String edge2DigitTemp = String.valueOf(graphInstructions[i].charAt(y));
                            edge2String = edge2String.concat(edge2DigitTemp);
                            //System.out.println("Setting Edge2 as " + graphInstructions[i].charAt(y));
                        }//else if




                    }
                }
                edge1 = Integer.parseInt(edge1String);
                edge2 = Integer.parseInt(edge2String);

                System.out.print("| Adding Edge : "+ edge1 + " - " + edge2 + " ");

                if (graphNum == 1){
                    edgeList1.add(edge1);
                    edgeList1.add(edge2);
                }//if
                else if (graphNum == 2){
                    edgeList2.add(edge1);
                    edgeList2.add(edge2);
                }//elseif
                else if (graphNum == 3){
                    edgeList3.add(edge1);
                    edgeList3.add(edge2);
                }//elseif
                else if (graphNum == 4){
                    edgeList4.add(edge1);
                    edgeList4.add(edge2);
                }//elseif
                else if (graphNum == 5){
                    edgeList5.add(edge1);
                    edgeList5.add(edge2);
                }//elseif
                else{
                    System.out.println("ERROR - UNABLE TO ADD EDGE");
                }//else




            }//else if
            else if (graphInstructions[i].toLowerCase().contains("vertex".toLowerCase()) && !(graphInstructions[i].toLowerCase().contains("undirected".toLowerCase()))){
                int addVertex = Integer.parseInt(graphInstructions[i].replaceAll("[\\D]", ""));


                System.out.print("| Adding Vertex " + addVertex + " ");
                if (graphNum == 1){
                    vertexList1.add(addVertex);
                }//if
                else if (graphNum == 2){
                    vertexList2.add(addVertex);
                }//elseif
                else if (graphNum == 3){
                    vertexList3.add(addVertex);
                }//elseif
                else if (graphNum == 4){
                    vertexList4.add(addVertex);
                }//elseif
                else if (graphNum == 5){
                    vertexList5.add(addVertex);
                }//elseif
                else{
                    System.out.println("ERROR - NOT ENOUGH VERTEXLISTS TO HOLD GRAPHS NEED TO EDIT CODE");
                }//else

            }//else if
            else{
                System.out.println();

                if (graphNum == 1 && !edgeList1.isEmpty()){
                    graph = new Graph(vertexList1.size()+1);
                    graphMatrix = new GraphMatrix(vertexList1.size()+1);
                    graphLinkedObjects = new GraphLinkedObjects(vertexList1.size()+1);

                    while(!edgeList1.isEmpty()){
                        //System.out.println("adding edges " + edgeList1.get(0) + " - " + edgeList1.get(1));
                        graph.addEdge(edgeList1.get(0), edgeList1.get(1));
                        graphMatrix.addEdge(edgeList1.get(0), edgeList1.get(1));
                        graphLinkedObjects.addEdge(edgeList1.get(0), edgeList1.get(1));
                        edgeList1.remove(0);
                        edgeList1.remove(0);
                    }


                    System.out.println("\n\t--GRAPH ADJACENCY LIST--");
                    graph.printGraphAdjacencyList();
                    System.out.println("\n\t--GRAPH MATRIX--");
                    graphMatrix.printGraph();
                    System.out.println("\n");
                    for (int y = 0; y < vertexList1.size(); y++){
                        System.out.print("Breath First Search : ");
                        graphLinkedObjects.breathFirstSearch(vertexList1.get(y));
                        System.out.print(" | Depth First Search : ");
                        graphLinkedObjects.depthFirstSearch(vertexList1.get(y));
                        System.out.println("\n");
                    }

                }//if
                else if (graphNum == 2 && !edgeList2.isEmpty()){
                    graph = new Graph(vertexList2.size()+1);
                    graphMatrix = new GraphMatrix(vertexList2.size()+1);
                    graphLinkedObjects = new GraphLinkedObjects(vertexList2.size()+1);

                    while(!edgeList2.isEmpty()){
                        //System.out.println("adding edges " + edgeList1.get(0) + " - " + edgeList1.get(1));
                        graph.addEdge(edgeList2.get(0), edgeList2.get(1));
                        graphMatrix.addEdge(edgeList2.get(0), edgeList2.get(1));
                        graphLinkedObjects.addEdge(edgeList2.get(0), edgeList2.get(1));
                        edgeList2.remove(0);
                        edgeList2.remove(0);
                    }


                    System.out.println("\n\t--GRAPH ADJACENCY LIST--");
                    graph.printGraphAdjacencyList();
                    System.out.println("\n\t--GRAPH MATRIX--");
                    graphMatrix.printGraph();

                }//elseif
                else if (graphNum == 3 && !edgeList3.isEmpty()){
                    graph = new Graph(vertexList3.size()+1);
                    graphMatrix = new GraphMatrix(vertexList3.size()+1);
                    graphLinkedObjects = new GraphLinkedObjects(vertexList3.size()+1);

                    while(!edgeList3.isEmpty()){
                        //System.out.println("adding edges " + edgeList1.get(0) + " - " + edgeList1.get(1));
                        graph.addEdge(edgeList3.get(0), edgeList3.get(1));
                        graphMatrix.addEdge(edgeList3.get(0), edgeList3.get(1));
                        graphLinkedObjects.addEdge(edgeList3.get(0), edgeList3.get(1));
                        edgeList3.remove(0);
                        edgeList3.remove(0);
                    }


                    System.out.println("\n\t--GRAPH ADJACENCY LIST--");
                    graph.printGraphAdjacencyList();
                    System.out.println("\n\t--GRAPH MATRIX--");
                    graphMatrix.printGraph();

                }//elseif
                else if (graphNum == 4 && !edgeList4.isEmpty()){
                    graph = new Graph(vertexList4.size()+1);
                    graphMatrix = new GraphMatrix(vertexList4.size()+1);
                    graphLinkedObjects = new GraphLinkedObjects(vertexList4.size()+1);

                    while(!edgeList4.isEmpty()){
                        //System.out.println("adding edges " + edgeList1.get(0) + " - " + edgeList1.get(1));
                        graph.addEdge(edgeList4.get(0), edgeList4.get(1));
                        graphMatrix.addEdge(edgeList4.get(0), edgeList4.get(1));
                        graphLinkedObjects.addEdge(edgeList4.get(0), edgeList4.get(1));
                        edgeList4.remove(0);
                        edgeList4.remove(0);
                    }


                    System.out.println("\n\t--GRAPH ADJACENCY LIST--");
                    graph.printGraphAdjacencyList();
                    System.out.println("\n\t--GRAPH MATRIX--");
                    graphMatrix.printGraph();


                }//elseif
                else if (graphNum == 5 && !edgeList5.isEmpty()){
                    graph = new Graph(vertexList5.size()+1);
                    graphMatrix = new GraphMatrix(vertexList5.size()+1);
                    graphLinkedObjects = new GraphLinkedObjects(vertexList5.size()+1);

                    while(!edgeList5.isEmpty()){
                        //System.out.println("adding edges " + edgeList1.get(0) + " - " + edgeList1.get(1));
                        graph.addEdge(edgeList5.get(0), edgeList5.get(1));
                        graphMatrix.addEdge(edgeList5.get(0), edgeList5.get(1));
                        graphLinkedObjects.addEdge(edgeList5.get(0), edgeList5.get(1));
                        edgeList5.remove(0);
                        edgeList5.remove(0);
                    }


                    System.out.println("\n\t--GRAPH ADJACENCY LIST--");
                    graph.printGraphAdjacencyList();
                    System.out.println("\n\t--GRAPH MATRIX--");
                    graphMatrix.printGraph();
                    for (int y = 0; y < vertexList5.size(); y++){
                        graphLinkedObjects.breathFirstSearch(vertexList5.get(y));
                        graphLinkedObjects.depthFirstSearch(vertexList5.get(y));
                    }

                }//elseif
                else{
                    System.out.println("");
                }//else

            }//else

        }//for


        System.out.println("\n\u2022 Note -> The objects in the 'GRAPH ADJACENCY LIST' are linked list objects from the 'Graph' Class");
        System.out.println("\u2022 Note -> The objects in the 'GRAPH MATRIX' are NOT linked objects and are from the 'GraphMatrix' Class");
        System.out.println("\u2022 Note -> The objects in the 'GRAPH LINKED OBJECTS HASHMAP' are linked list objects from the 'GraphLinkedObjectsHashMap' Class\n");
        //**********************************************IMPORTANT NOTE***************************************************************************************************************
            //I chose to do 3 separate classes, many of which contain similarities, because there were so many different approaches to doing this when I was researching the topic
            //so I decided to try a few different methods to achieve the same thing to get a better understanding\
            //each class is left to be basic because I simply as said multiple times am dealing with a loss and cannot dedicate the time I would like to in order to make the project my best work
            //I simply chose to have that understanding of how and why and will continue to work on the implementation in the future

        /*System.out.println("\n--GRAPH ADJACENCY LIST--");
        Graph graph = new Graph(7+1);
        graph.addEdge(1,2);
        graph.addEdge(1,5);
        graph.addEdge(1,6);
        graph.addEdge(2,3);
        graph.addEdge(2,5);
        graph.addEdge(2,6);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(5,6);
        graph.addEdge(5,7);
        graph.addEdge(6,7);
        graph.printGraphAdjacencyList();



        System.out.println("\n--GRAPH MATRIX--");

        GraphMatrix graphMatrix = new GraphMatrix(8);
        graphMatrix.addEdge(1,2);
        graphMatrix.addEdge(1,5);
        graphMatrix.addEdge(1,6);
        graphMatrix.addEdge(2,3);
        graphMatrix.addEdge(2,5);
        graphMatrix.addEdge(2,6);
        graphMatrix.addEdge(3,4);
        graphMatrix.addEdge(4,5);
        graphMatrix.addEdge(5,6);
        graphMatrix.addEdge(5,7);
        graphMatrix.addEdge(6,7);
        graphMatrix.printGraph();

        GraphLinkedObjects graphLinkedObjects = new GraphLinkedObjects(8);
        graphLinkedObjects.addEdge(1,2);
        graphLinkedObjects.addEdge(1,5);
        graphLinkedObjects.addEdge(1,6);
        graphLinkedObjects.addEdge(2,3);
        graphLinkedObjects.addEdge(2,5);
        graphLinkedObjects.addEdge(2,6);
        graphLinkedObjects.addEdge(3,4);
        graphLinkedObjects.addEdge(4,5);
        graphLinkedObjects.addEdge(5,6);
        graphLinkedObjects.addEdge(5,7);
        graphLinkedObjects.addEdge(6,7);


         */










        /*-----------------------------------------------------------------------------*/





            /*Testing :
                //Traverse and print out them inOrder, preOrder, and postOrder starting at the root of the tree
                tree.inOrderTraversal(tree.root);
                //System.out.println("");
                //tree.preOrderTraversal(tree.root);
                //System.out.println("");
                //tree.postOrderTraversal(tree.root);
                //System.out.println("\nSearch for Hectorius's Twin Rings");
                System.out.println(tree.searchNode("UFO tofu"));
                System.out.println(tree.getTempComparisons());
                System.out.println(tree.getTotalComparisons());
             */
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
                    words[i] = s2.nextLine();
            }

            return words;
        }//try
        catch (FileNotFoundException e){
            System.out.println("File Not Found");
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
