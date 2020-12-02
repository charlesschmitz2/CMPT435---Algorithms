import java.util.ArrayList;
import java.util.List;

public class Knapsack {

    private List<KnapsackItem> knapsackItems;
    private int knapsackCapacity;

    public Knapsack(List<KnapsackItem> items, int capacity) {
        knapsackItems = items;
        knapsackCapacity = capacity;
    }//knapsack

    public List<KnapsackItem> findWorth(List<KnapsackItem> items, int capacity) {
        List<KnapsackItem> itemsList = items;
        List<KnapsackItem> itemSolutions = new ArrayList<KnapsackItem>();
        return itemSolutions;
    }//findWorth

    public void addItem(String name, double price, int quanity){
        KnapsackItem item = new KnapsackItem(name, price, quanity);
        knapsackItems.add(item);
    }

    public int getKnapsackCapacity() {
        return knapsackCapacity;
    }

    public void setKnapsackCapacity(int knapsackCapacity) {
        this.knapsackCapacity = knapsackCapacity;
    }

    public void print(){
        System.out.println("PRINTING");
        if (!knapsackItems.isEmpty()) {
            System.out.println("Knapsack Problem ");
            System.out.println("Capacity : " + knapsackCapacity);
            System.out.println("Items : ");

            for (int j = 0; j < knapsackItems.size(); j++) {
                System.out.println(knapsackItems.get(j));
            }//for
        }//if
    }//print
}//Knapsack
