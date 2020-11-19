import java.util.HashMap;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Map;

public class GraphLinkedObjects {

    List<List<Integer>> graphLinkedObjects; //This is the Linked List of Objects
    boolean[] visited; //Keeps track of if each vertex has been visited, this will be used for BFS and DFS

    public GraphLinkedObjects(int vertices) {
        graphLinkedObjects = new ArrayList<>();
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            graphLinkedObjects.add(i, new ArrayList<>());
        }//for
    }//constructor

    public void addEdge(int source, int destination) {
        //Make sure each edge is added in both directions as graph is undirected
        graphLinkedObjects.get(source).add(destination);
        graphLinkedObjects.get(destination).add(source);
    }//addEdge

    public void breathFirstSearch(int startIndex) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startIndex);
        visited[startIndex] = true;

        while (!queue.isEmpty()) {
            Integer vertex = queue.poll();
            System.out.print(vertex + " ");

            List<Integer> childList = graphLinkedObjects.get(vertex);

            for (Integer child : childList) {
                if (!visited[child]) {
                    queue.add(child);
                    visited[child] = true;
                }//if
            }//for
        }//while
    }//breathFirstSearch

    public void depthFirstSearch(int startIndex) {
        Stack<Integer> stack = new Stack<>();

        stack.push(startIndex);
        visited[startIndex] = true;

        while (!stack.isEmpty()) {
            Integer vertex = stack.pop();
            System.out.print(vertex + " ");

            List<Integer> neighboursList = graphLinkedObjects.get(vertex);

            for (Integer neighbouringVertex : neighboursList) {
                if (!visited[neighbouringVertex]) {
                    stack.push(neighbouringVertex);
                    visited[neighbouringVertex] = true;
                }//if
            }//for
        }//while
    }//depthFirstSearch

    /*
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

     */

}
