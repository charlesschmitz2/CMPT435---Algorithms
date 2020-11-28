import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Assignment5_DynamicProgramming_GreedyAlgorithms {

    public static int vertexCount = 0;
    public static int startVertex = 0;
    public static ArrayList<Integer> vertexListALL = new ArrayList<Integer>();
    public static int edgeCount = 0;
    public static ArrayList<Integer> edgeListALL = new ArrayList<Integer>();

    public static void main(String[] args) {

        readAndProcess("graphs2.txt");
        int V = 5; // Number of vertices in graph
        int E = 8; // Number of edges in graph

        Graph graph = new Graph(V, E);

        // add edge 0-1 (or A-B in above figure)
        graph.edgeArray[0].source = 0;
        graph.edgeArray[0].destination = 1;
        graph.edgeArray[0].weight = -1;
        // add edge 0-2 (or A-C in above figure)
        graph.edgeArray[1].source = 0;
        graph.edgeArray[1].destination = 2;
        graph.edgeArray[1].weight = 4;

        // add edge 1-2 (or B-C in above figure)
        graph.edgeArray[2].source = 1;
        graph.edgeArray[2].destination = 2;
        graph.edgeArray[2].weight = 3;

        // add edge 1-3 (or B-D in above figure)
        graph.edgeArray[3].source = 1;
        graph.edgeArray[3].destination = 3;
        graph.edgeArray[3].weight = 2;

        // add edge 1-4 (or A-E in above figure)
        graph.edgeArray[4].source = 1;
        graph.edgeArray[4].destination = 4;
        graph.edgeArray[4].weight = 2;

        // add edge 3-2 (or D-C in above figure)
        graph.edgeArray[5].source = 3;
        graph.edgeArray[5].destination = 2;
        graph.edgeArray[5].weight = 5;

        // add edge 3-1 (or D-B in above figure)
        graph.edgeArray[6].source = 3;
        graph.edgeArray[6].destination = 1;
        graph.edgeArray[6].weight = 1;

        // add edge 4-3 (or E-D in above figure)
        graph.edgeArray[7].source = 4;
        graph.edgeArray[7].destination = 3;
        graph.edgeArray[7].weight = -3;

        graph.bellmanFord(graph, 0);

    }//main

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
                        System.out.println("List of all Edges : " + edgeListALL + "   EdgeCount = " + edgeCount/3);
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
                                System.out.println(edge1);
                                edgeListALL.remove(0);

                                int edge2 = edgeListALL.get(0);
                                graph.edgeArray[k].destination = edge2;
                                System.out.println(edge2);
                                edgeListALL.remove(0);

                                int weight = edgeListALL.get(0);
                                graph.edgeArray[k].weight = weight;
                                System.out.println(weight);
                                edgeListALL.remove(0);
                            }//if
                        }
                        //graph.bellmanFord(graph, startVertex);
                        edgeListALL.clear();
                        vertexListALL.clear();
                    }


                }//for

                if(!strLine.contains("--") && !strLine.isEmpty() && !strLine.contains("new")){
                    System.out.println("\t\t\tVertex's Being Added: " + vertexList);
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
                    System.out.println("List of all Vertices : " + vertexListALL);
                    System.out.println("List of all Edges : " + edgeListALL);
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
    }

    }//Assignment5_DynamicProgramming_GreedyAlgorithms
