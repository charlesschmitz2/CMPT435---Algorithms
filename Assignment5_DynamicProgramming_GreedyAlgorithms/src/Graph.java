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

        for (int i = 0; i < vertices; i++){
            
        }
    }


}//graph
