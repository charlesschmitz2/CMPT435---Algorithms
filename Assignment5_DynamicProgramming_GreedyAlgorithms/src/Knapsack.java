import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Knapsack {

    private List<KnapsackItem> knapsackItems;
    private int knapsackCapacity;

    public Knapsack(List<KnapsackItem> items, int capacity) {
        knapsackItems = items;
        knapsackCapacity = capacity;
    }//knapsack

    public Knapsack findWorth(int capacity) {

        ArrayList<KnapsackItem> solution = new ArrayList<>(); // Initialize Variables
        Knapsack knapsackSolution = new Knapsack(solution,0);

        if (capacity <= 0) {
            System.out.println("\tUnable to compute worth, 'Capacity' was listed as a negative value or none was given");
            return knapsackSolution;
        }//if
        if (capacity > this.totalCapacity()){
            System.out.println("\tUnable to compute worth, ' Capacity was listed as a value larger than the size of the Knapsack");
            return knapsackSolution;
        }

            this.setKnapsackCapacity(capacity);

            boolean capacityRemains = true;

            int counter = 0;
            //int tempQuantity = knapsackItems.get(counter).getQuantity();
            while (capacityRemains) {
                if (capacity == 0) {
                    capacityRemains = false;
                    //System.out.println("Setting Capacity to false");
                }//if
                else {
                    int tempQuantity = knapsackItems.get(counter).getQuantity();
                    while (tempQuantity > 0 && capacity > 0) {
                        //System.out.println("in tempQuantity > 0 \nBefore : ");
                        //System.out.println(tempQuantity);
                        //System.out.println(capacity);
                        if (ifExistsInSolution(knapsackItems.get(counter).getSpiceName(), solution)){
                            int temp1 = solution.get(counter).getQuantity();
                            temp1++;
                            solution.get(counter).setQuantity(temp1);
                            System.out.println("\t\u2022 Adding another scoop of " + knapsackItems.get(counter).getSpiceName());
                            //System.out.println("in tempQuantity > 0 if statement");
                        }//if
                        else {
                            //System.out.println("in tempQuantity > 0 else statement");
                            System.out.println("\t\u2022 Adding to Solution Knapsack the first scoop of " + knapsackItems.get(counter).getSpiceName());
                            knapsackSolution.addItem(knapsackItems.get(counter).getSpiceName(), knapsackItems.get(counter).getTotalPrice(), 1, knapsackItems.get(counter).getUnitPrice());
                        }//else\
                        tempQuantity--;
                        capacity--;
                        //System.out.println("After: ");
                        //System.out.println(tempQuantity);
                        //System.out.println(capacity);
                    }//while
                    counter++;
                }//else
                //System.out.println("in Capacity Remains");
            }//while

            return knapsackSolution;


    }//findWorth

    public void addItem(String name, double price, int quanity,double unitPrice){
        KnapsackItem item = new KnapsackItem(name, price, quanity, unitPrice);
        knapsackItems.add(item);
    }//addItem

    public void sort(){
        Collections.sort(knapsackItems, Comparator.comparing(KnapsackItem::getUnitPrice));
        Collections.reverse(knapsackItems);
    }


    public List<KnapsackItem> getKnapsackItems() {
        return knapsackItems;
    }

    public int getKnapsackCapacity() {
        return knapsackCapacity;
    }

    public void setKnapsackCapacity(int knapsackCapacity) {
        this.knapsackCapacity = knapsackCapacity;
    }

    public boolean ifExistsInSolution(String name, ArrayList<KnapsackItem> solutions){
        for (int i = 0; i < solutions.size(); i++){
            if(solutions.get(i).getSpiceName().trim().compareToIgnoreCase(name.trim()) == 0) {
                return true;
            }//if
        }//for
        return false;
    }//ifExists

    public int totalCapacity(){
        int totalCapacity = 0;
        for (int i = 0; i < knapsackItems.size(); i++){
            totalCapacity += knapsackItems.get(i).getQuantity();
        }//for
        return totalCapacity;
    }//totalCapacity

    public double totalWorth(){
        double totalWorth = 0.0;
        for(int i = 0; i < knapsackItems.size(); i++){
            totalWorth += knapsackItems.get(i).getUnitPrice()*knapsackItems.get(i).getQuantity();
        }
        return totalWorth;
    }//totalWorth

    public void print(){
        if (!knapsackItems.isEmpty()) {
            System.out.println("\t-- Knapsack Contents --  ");
            System.out.println("\t\tCapacity Left : " + knapsackCapacity);
            System.out.println("\t\tItems : ");

            for (int j = 0; j < knapsackItems.size(); j++) {
                System.out.println("\t\t\t\u2022" + knapsackItems.get(j));
            }//for
        }//if
    }//print


}//Knapsack
