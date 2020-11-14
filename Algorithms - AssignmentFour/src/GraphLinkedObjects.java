import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GraphLinkedObjects {

    private Map<Vertex, LinkedList<Vertex>> adjacencyMap;
    private boolean directed;

    public GraphLinkedObjects(){
        this.directed = directed;
        adjacencyMap = new HashMap<>();
    }//constructor

    public void addEdgeHelper(Vertex a, Vertex b) {
        LinkedList<Vertex> tempValue = adjacencyMap.get(a);

        if (tempValue != null) {
            tempValue.remove(b);
        }
        else tempValue = new LinkedList<>();
        tempValue.add(b);
        adjacencyMap.put(a,tempValue);
    }//addEdgeHelper

    public void addEdge(Vertex source, Vertex destination){
        //check to see if the source exists, is it doesnt put the source. The source value basically represents what we usually call a key value in all are other assignments
        //check all edge cases
        if (!adjacencyMap.keySet().contains(source)){
            adjacencyMap.put(source, null);
        }//if
        if (!adjacencyMap.keySet().contains(destination)){
            adjacencyMap.put(destination, null);
        }//if

        addEdgeHelper(source, destination);

        //We are working with undirected graphs here so want to ensure that each connection is added both ways
        if (!directed) {
            addEdgeHelper(destination, source);
        }//if
    }//addEdge

    public void addVertex(int num){
        String numString = new String(String.valueOf(num));
        Vertex node = new Vertex(num,numString);

    }

    public void printEdges() {
        for (Vertex vertex : adjacencyMap.keySet()) {
            System.out.print("The " + vertex.name + " has an edge towards: ");
            for (Vertex neighbor : adjacencyMap.get(vertex)) {
                System.out.print(neighbor.name + " ");
            }
            System.out.println();
        }
    }

    public boolean hasEdge(Vertex source, Vertex destination) {
        return adjacencyMap.containsKey(source) && adjacencyMap.get(source).contains(destination);
    }

    public void resetVertexVisited(){
        for(Vertex vertex : adjacencyMap.keySet()){
            vertex.setUnVisited();
        }
    }

}
