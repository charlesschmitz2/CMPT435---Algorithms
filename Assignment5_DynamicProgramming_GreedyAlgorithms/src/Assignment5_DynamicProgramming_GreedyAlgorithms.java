import java.io.*;
import java.util.*;

public class Assignment5_DynamicProgramming_GreedyAlgorithms {

    public static int vertexCount = 0;
    public static int startVertex = 0;
    public static ArrayList<Integer> vertexListALL = new ArrayList<Integer>();
    public static int edgeCount = 0;
    public static ArrayList<Integer> edgeListALL = new ArrayList<Integer>();
    public static Graph graph = new Graph(0, 0);

    public static void main(String[] args) {

    /*----BellmanFord Single Source Shortest Path Algorithm----*/
        readAndProcess("graphs2.txt");

        /*
        //-----FOR SOME REASON WORKS WHEN HARDCODING IN BUT CANT SEEM TO GET TO WORK WHEN LOOPING EVEN THOUGH MY BELLMAN FORD FUNCTION SEEMS CORRECT
                                    int V = 5; // Number of vertices in graph
                                    int E = 8; // Number of edges in graph
                                    graph = new Graph(V, E);

                                    // add edge 0-1
                                    graph.edgeArray[0].source = 0;
                                    graph.edgeArray[0].destination = 1;
                                    graph.edgeArray[0].weight = -1;
                                    // add edge 0-2
                                    graph.edgeArray[1].source = 0;
                                    graph.edgeArray[1].destination = 2;
                                    graph.edgeArray[1].weight = 4;

                                    // add edge 1-2
                                    graph.edgeArray[2].source = 1;
                                    graph.edgeArray[2].destination = 2;
                                    graph.edgeArray[2].weight = 3;

                                    // add edge 1-3
                                    graph.edgeArray[3].source = 1;
                                    graph.edgeArray[3].destination = 3;
                                    graph.edgeArray[3].weight = 2;

                                    // add edge 1-4
                                    graph.edgeArray[4].source = 1;
                                    graph.edgeArray[4].destination = 4;
                                    graph.edgeArray[4].weight = 2;

                                    // add edge 3-2
                                    graph.edgeArray[5].source = 3;
                                    graph.edgeArray[5].destination = 2;
                                    graph.edgeArray[5].weight = 5;

                                    // add edge 3-1
                                    graph.edgeArray[6].source = 3;
                                    graph.edgeArray[6].destination = 1;
                                    graph.edgeArray[6].weight = 1;

                                    // add edge 4-3
                                    graph.edgeArray[7].source = 4;
                                    graph.edgeArray[7].destination = 3;
                                    graph.edgeArray[7].weight = -3;

                                    graph.bellmanFord(graph, 0);

                                    int Ver = 4;
                                    int edg = 8;
                                    graph = new Graph(Ver, edg);

                                    int j = 0;
                                    while(j < edg){
                                        System.out.println("--"+j);
                                            int randomNum = ThreadLocalRandom.current().nextInt(0, 50 + 1);
                                        graph.edgeArray[j].source = randomNum;
                                        System.out.println(randomNum);
                                            int randomNum1 = ThreadLocalRandom.current().nextInt(0, 50 + 1);
                                        graph.edgeArray[j].destination = randomNum1;
                                        System.out.println(randomNum1);
                                            int randomNum2 = ThreadLocalRandom.current().nextInt(0, 50 + 1);
                                        graph.edgeArray[j].weight = randomNum2;
                                        System.out.println(randomNum2);
                                        j++;
                                    }
                                    System.out.print("DONE");
                                    graph.bellmanFord(graph, 0);


         */


        /*----Knapsack Problem----*/
        //spice name = red;    total_price =  4.0;  qty = 4;
        //spice name = green;  total_price = 12.0;  qty = 6;
        //spice name = blue;   total_price = 40.0;  qty = 8;
        //spice name = orange; total_price = 18.0;  qty = 2;
        List<KnapsackItem> items = new ArrayList<>(); // Initialize Variables
        Knapsack knapsack = new Knapsack(items,0);
            knapsack.addItem("red", 4.0, 4, 4.0/4);//Add the items to the knapsack
            knapsack.addItem("green", 12.0, 6, 12.0/6);
            knapsack.addItem("blue", 40.0, 8, 40.0/8);
            knapsack.addItem("orange", 18.0, 2, 18.0/2);
            knapsack.sort(); //sort the items
                                //calculate the solution based on the capacity provided
        knapsack.print();

        Knapsack knapsackSolution = knapsack.findWorth(21);
        knapsackSolution.print();










    }//main

    /*----BellmanFord Single Source Shortest Path Algorithm Functions----*/

        /*----This function is responsible for the bellman ford functions and processing the input of the graph2.txt file----*/
        private static void readAndProcess(String s) {
            try {
                // Open the file
                FileInputStream fstream = new FileInputStream(s);
                BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

                String strLine;
                String graphName = " ";

                System.out.println("PROCESSING FILE " + "'"+s+"'" + "[");
                //Read File Line By Line
                while ((strLine = br.readLine()) != null) {
                    // Print the content on the console
                    //System.out.println(strLine);
                    String[] words = strLine.split(" ");
                    ArrayList<Integer> edgeList = new ArrayList<Integer>();
                    ArrayList<Integer> vertexList = new ArrayList<Integer>();
                    for (int i = 0; i < words.length; i++){
                        if(isInteger(words[i]) && strLine.contains("add")){
                            System.out.println("\t\t\u2022 '" + strLine + "'" + " --> Processing Number -  " + words[i]);
                            if (strLine.contains("vertex")) {
                             //System.out.println("--Adding Vertex" + " WORD " + words[i]);
                             vertexList.add(Integer.parseInt(words[i]));
                                vertexListALL.add(Integer.parseInt(words[i]));
                             vertexCount++;
                            }//if
                            else if (strLine.contains("edge")){
                                //System.out.println("--Adding Edge" + " " + words[i] + " ----- " + i);
                                edgeList.add(Integer.parseInt(words[i]));
                                    edgeListALL.add(Integer.parseInt(words[i]));
                                edgeCount++;

                            }//else if

                        }
                        else if (strLine.contains("--")){
                            //these are comments so do nothing
                            if (strLine.contains("directed") || strLine.contains("CLRS")){
                                graphName = strLine;
                            }//if
                        }//else if
                        else if (strLine.contains("new") && i == 0){
                            System.out.println("\n\n\t" + "GENERATING NEW GRAPH " + graphName);
                            vertexCount = 0;
                            edgeCount = 0;


                        }//else if
                        else if (strLine.trim().isEmpty()){
                            //System.out.println("BlankLine");
                            int vertices = vertexCount; // Number of vertices in graph
                            int edges = edgeCount/3; // Number of edges in graph divided by 3 because each time count is incremented it counts the weight value so this takes care of that.
                            //System.out.println(vertices);
                            //System.out.println(edges);
                            System.out.println("List of all Vertices : " + vertexListALL + "   VertexCount = " + vertexCount);
                            System.out.println("List of all Edges (w/ weights): " + edgeListALL + "   EdgeCount = " + edgeCount/3);
                            Graph graph = new Graph(vertices, edges);
                           /* for (int y = startVertex; y < edgeListALL.size();y++){
                                //int edge1 = edgeListALL.get(0);
                                System.out.println(edgeListALL.get(0));
                                    edgeListALL.remove(0);
                                //graph.edgeArray[y].source = edge1;
                                //int edge2 = edgeListALL.get(0);
                                System.out.println(edgeListALL.get(0));
                                    edgeListALL.remove(0);
                                //graph.edgeArray[y].destination = edge2;
                                //int weight = edgeListALL.get(0);
                                System.out.println(edgeListALL.get(0));
                                    edgeListALL.remove(0);
                                //graph.edgeArray[y].weight = weight;
                            }

                            */
                            /*
                            int y = startVertex;
                            while(!vertexListALL.isEmpty()){
                                int edge1 = edgeListALL.get(0);
                                graph.edgeArray[y].source = edge1;
                                edgeListALL.remove(0);

                                int edge2 = edgeListALL.get(0);
                                graph.edgeArray[y].destination = edge2;
                                edgeListALL.remove(0);

                                int weight = edgeListALL.get(0);
                                graph.edgeArray[y].weight = weight;
                                edgeListALL.remove(0);

                                y++;
                                System.out.print(y);
                            }//while


                             */
                            for(int k = 0; k < (edgeCount/3); k++){
                                if(!edgeListALL.isEmpty()) {
                                    int edge1 = edgeListALL.get(0);
                                    graph.edgeArray[k].source = edge1;
                                    //System.out.println(edge1);
                                    edgeListALL.remove(0);

                                    int edge2 = edgeListALL.get(0);
                                    graph.edgeArray[k].destination = edge2;
                                    //System.out.println(edge2);
                                    edgeListALL.remove(0);

                                    int weight = edgeListALL.get(0);
                                    graph.edgeArray[k].weight = weight;
                                    //System.out.println(weight);
                                    edgeListALL.remove(0);
                                }//if
                            }
                            //graph.bellmanFord(graph, startVertex);
                            edgeListALL.clear();
                            vertexListALL.clear();
                        }


                    }//for

                    if(!strLine.contains("--") && !strLine.isEmpty() && !strLine.contains("new")){
                        System.out.println("\t\t\tVertex's Being Added: " + vertexList );
                        if(!vertexList.isEmpty()){
                            //add the vertex
                            //Testing - System.out.println("----Vertex Count " + vertexCount);

                        }//if
                        System.out.println("\t\t\tEdge's Being Added: " + edgeList);
                        if(!edgeList.isEmpty()){
                            //add the edge, the first and second items in the list are the edge connection and the third is the weight

                        }//if
                    }//if

                }//while

                //Close the input stream
                fstream.close();
                        //need to perform one more graph since my method adds and performs functions on the graphs at each white space and since there is no extra space after the last item this is what I did
                        //a much smarter thing to do would be to simply hit return one more time after the last graph so they all follow the same pattern but for now this will be in here and I feel as though
                        //that's fine because of how the text file is set up and it doesn't make sense to rethink how I read the graphs in just for something so minor
                        int vertices = vertexCount; // Number of vertices in graph
                        int edges = edgeCount/3; // Number of edges in graph divided by 3 because each time count is incremented it counts the weight value so this takes care of that.
                        //System.out.println(vertices);
                        //System.out.println(edges);
                        System.out.println("List of all Vertices : " + vertexListALL + "   VertexCount = " + vertexCount);
                        System.out.println("List of all Edges (w/ weights): " + edgeListALL  + "   EdgeCount = " + edgeCount/3);
                        Graph graph = new Graph(vertices, edges);
                        graph.bellmanFord(graph, startVertex);
                System.out.println("\n\n] PROCESSING FILE COMPLETE **^^Created for Testing and Debugging/Visualizing Purposes^^**");

            }//try
            catch (IOException e) {
                e.printStackTrace();
            }//catch

        }//readAndProcess

        public static boolean isInteger(String s) {
            boolean isValidInteger = false;
            try
            {
                Integer.parseInt(s);

                // s is a valid integer

                isValidInteger = true;
            }
            catch (NumberFormatException ex)
            {
                // s is not an integer
            }

            return isValidInteger;
        }//isInteger

    /*----Knapsack Problem----*/



    }//Assignment5_DynamicProgramming_GreedyAlgorithms

