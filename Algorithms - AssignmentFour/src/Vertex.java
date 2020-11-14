public class Vertex {
    /*
    String label;
    Vertex(String label) {
        this.label = label;
    }
    */

    int num;
    String name;
    boolean visited;

    public Vertex(int num, String name){
        this.num = num;
        this.name = name;
        visited = false;
    }//constructor

    public void setVisited(){
        visited = true;
    }//setVisited

    public void setUnVisited(){
        visited = false;
    }//setUnvisited



    //each vertex represents a node within the graph,
}

