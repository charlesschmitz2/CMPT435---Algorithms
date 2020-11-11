public class GraphMatrix {
    int vertexCount;
    int matrixGraph[][];

    public GraphMatrix(int vertexCount) {
        this.vertexCount = vertexCount;
        matrixGraph = new int[vertexCount][vertexCount];
    }//constructor

    public void addEdge(int source, int destination) {
        //add edge
        matrixGraph[source][destination] = 1;

        //add bak edge for undirected graph
        matrixGraph[destination][source] = 1;
    }//addEdge

    public void printGraph() {
        for (int i = 0; i < vertexCount; i++) {
            System.out.print(i + " | ");
            for (int j = 0; j < vertexCount; j++) {
                System.out.print(matrixGraph[i][j] + " ");
            }//for
            System.out.println();
        }//for

    }//printGraph
}//GraphMatrix
