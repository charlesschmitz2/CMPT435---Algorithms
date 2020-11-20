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
    //Visited is the equivalent of 'hasbeenprocessed' from our notes, I just changed to something that made sense for me.

    public GraphLinkedObjects(int vertices) {
        graphLinkedObjects = new ArrayList<>();
        visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            graphLinkedObjects.add(i, new ArrayList<>());
        }//for
    }//constructor

    /*----addEdge to the Linked Objects Graph----*/
    public void addEdge(int source, int destination) {
        //Make sure each edge is added in both directions as graph is undirected
        graphLinkedObjects.get(source).add(destination);
        graphLinkedObjects.get(destination).add(source);
    }//addEdge

    /*----BFS, Goes wide before going deep. Traverses every node, finishing the current level before going onto the next level----*/
    public void breathFirstSearch(int startIndex) {
        Queue<Integer> queue = new LinkedList<>();

        //add and poll are the same as enqueue and dequeue I am just using the built in java queue commands but could have easily used our queue classes previously built
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

    /*----DFS, Goes deep starting at root/startIndex here, working up after hitting bottom, then back down until hit bottom, then back up and so on----*/
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


}
