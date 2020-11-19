import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


//THIS FILE ENDED UP NOT WORKING WITH HOW I WANTED TO IMPLEMENT THIS ASSIGNMENT BUT I CHOSE TO LEAVE IT IN THE SRC AS IT WAS USEFUL
//TO EXPERIMENT WITH HASHMAPS AND THE MANY METHODS OF WHICH TO ADDRESS GRAPHS


//in this file I will be using a hashmap as a map of linkedlist objects of vertex nodes where I will traverse using BFS and DFS
public class GraphLinkedObjectsHashMap {

    private Map<Vertex, LinkedList<Vertex>> adjacencyMap;

    public GraphLinkedObjectsHashMap(){
        adjacencyMap = new HashMap<>();
    }//constructor

    public void addEdge(Vertex source, Vertex destination){
        //check to see if the source exists, is it doesnt put the source. The source value basically represents what we usually call a key value in all are other assignments
        if(!adjacencyMap.keySet().contains(source)){
            adjacencyMap.put(source, null);
        }//if
        //check to make sure that even if a vertex has no edges, it will still be included
        if (!adjacencyMap.keySet().contains(destination)){
            adjacencyMap.put(destination, null);
        }//if

        LinkedList<Vertex> tempValue = adjacencyMap.get(source);

        if (tempValue == null){
            tempValue = new LinkedList<>();
        }//if

        tempValue.add(destination);
        adjacencyMap.put(source, tempValue);
    }//addEdge

    public boolean hasEdge(Vertex source, Vertex destination){
        //adjacencyMap contains the source, is not null, and the source contains the target destination
        return adjacencyMap.containsKey(source) && adjacencyMap.get(source) != null && adjacencyMap.get(source).contains(destination);
    }//hasEdge



    public void printGraph(){
        for (Vertex rootNode: adjacencyMap.keySet()){
            LinkedList<Vertex> vertexCount = adjacencyMap.get(rootNode);
            if(vertexCount != null){
                for (Vertex adjacent: adjacencyMap.get(rootNode)){
                    System.out.println(adjacent.toString());
                }
            }
        }
    }
}
