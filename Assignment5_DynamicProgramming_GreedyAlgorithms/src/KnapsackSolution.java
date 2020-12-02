import java.util.List;

public class KnapsackSolution {

    public List<KnapsackItem> knapsackItems; //represents the items to be put into the bag that produce the maximum value
    public int knapsackPrice; //represents the maximum value

    public KnapsackSolution (List<KnapsackItem> items, int value) {
        knapsackItems = items;
        knapsackPrice = value;
    }//Knapsack Solution values/items

    public void print(){
        //if the list of knapsack items does not equal null
        // AND it is not empty -- covers both cases
        if (knapsackItems != null && !knapsackItems.isEmpty()){
            System.out.println("Worth : " + knapsackPrice + "Scoops : ");

            for (KnapsackItem item : knapsackItems){
                System.out.print(" " + item.toString() + ", ");
            }//for
        }//if
    }//print
}
