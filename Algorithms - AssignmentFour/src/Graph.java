import java.util.LinkedList;

//could have used our previously made linked list class, but because of the circumstances I explained to you I just don't have the time to focus on that and just
//chose to focus on the general understanding of how they work and what they do.
public class Graph {
    int vertexCount;
    LinkedList<Integer> adjacencyList[];

    public Graph(int vertexCount) {
        this.vertexCount = vertexCount;
        adjacencyList = new LinkedList[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        adjacencyList[source].addFirst(destination);
        adjacencyList[destination].addFirst(source);
    }

    public void printGraphAdjacencyList() {
        for (int i = 0; i < vertexCount; i++) {
            if (adjacencyList[i].size() > 0) {
                System.out.print("[" + i + "] : ");
                for (int j = 0; j < adjacencyList[i].size(); j++) {
                    System.out.print(adjacencyList[i].get(j) + " ");
                }
                System.out.println();
            }
        }
    }
}