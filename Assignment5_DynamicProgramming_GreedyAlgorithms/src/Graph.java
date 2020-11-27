public class Graph {
    int vertices;
    int edges;
    Edge edgeArray[];

    Graph (int verticesNum, int edgesNum){
        vertices = verticesNum;
        edges = edgesNum;
        edgeArray = new Edge[edgesNum];

        //initialize the values in the edgeArray to the new edge
        for (int i = 0; i < edgesNum; i++){
            edgeArray[i] = new Edge();
        }//for
    }//Graph constructor

    /*----BellmanFord Algorithm----*/
    public void bellmanFord(Graph graph, int source){
        int vertices = graph.vertices;
        int edges = graph.edges;
        int distance[] = new int[vertices];

        //1.
        for (int i = 0; i < vertices; i++){
            distance[i] = Integer.MAX_VALUE;
        }//for
        distance[source] = 0;

        //2.
        for (int i = 1; i < vertices; i++){
            for (int j = 0; j < edges; j++){
                int src = graph.edgeArray[j].source;
                int dest = graph.edgeArray[j].destination;
                int weight = graph.edgeArray[j].weight;

                if ((distance[src] != Integer.MAX_VALUE) && (distance[src]+weight < distance[dest])){
                    distance[dest] = distance[src] + weight;
                }//if
            }//for
        }//for

        //3.
        for (int j = 0; j < edges; j++){
            int src = graph.edgeArray[j].source;
            int dest = graph.edgeArray[j].destination;
            int weight = graph.edgeArray[j].weight;

            if (distance[src] != Integer.MAX_VALUE && distance[src]+weight < distance[dest]){
                System.out.println("There is a negative weight cycle within the graph");
                return;
            }//if
        }//for

        printSolution(distance, vertices);
    }//BellmanFord

    public void printSolution(int[] distance, int vertices) {
        System.out.println("\nVertex Distance from Source w/ Cost Analysis: ");
        for (int i = 0; i < vertices; i++){
            System.out.println("\t\t" + i + "\t\t" + distance[i] + "\t\t | 0 --> " + i + " - Cost is " + distance[i]);
        }//for

    }//printSolution


}//graph
