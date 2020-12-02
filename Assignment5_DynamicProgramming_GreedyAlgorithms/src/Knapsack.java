import java.util.ArrayList;
import java.util.List;

public class Knapsack {

    private KnapsackItem[] knapsackItems;
    private int knapsackCapacity;

    public Knapsack(KnapsackItem[] items, int capacity) {
        knapsackItems = items;
        knapsackCapacity = capacity;
    }//knapsack

    public KnapsackSolution findWorth() {
        int itemListLength = knapsackItems.length;
        int[][] matrix = new int[itemListLength + 1][knapsackCapacity + 1];

        for (int i = 0; i <= knapsackCapacity; i++) {
            matrix[0][i] = 0;
        }//for

        for (int i = 1; i <= itemListLength; i++) {
            for (int j = 0; j <= knapsackCapacity; j++) {
                if (knapsackItems[i - 1].getQuantity() > j) {
                    matrix[i][j] = matrix[i - 1][j];
                }//if
                else {
                    matrix[i][j] = Math.max(matrix[i - 1][j], matrix[i - 1][j - knapsackItems[i - 1].getQuantity()] + knapsackItems[i - 1].getTotalPrice());
                }//else
            }//for
        }//for


        int result = matrix[itemListLength][knapsackCapacity];
        int cap = knapsackCapacity;
        List<KnapsackItem> itemSolutionList = new ArrayList<>();

        for (int i = itemListLength; i > 0 && result > 0; i--){
            if (result != matrix[i-1][cap]){
                itemSolutionList.add(knapsackItems[i-1]);
                result -= knapsackItems[i-1].getTotalPrice();
                result -= knapsackItems[i-1].getQuantity();
            }//if
        }//for

        return new KnapsackSolution(itemSolutionList, matrix[itemListLength][knapsackCapacity]);

    }//findWorth

    public void print(){
        if (knapsackItems != null && knapsackItems.length > 0) {
            System.out.println("Knapsack Problem ");
            System.out.println("Capacity : " + knapsackCapacity);
            System.out.println("Items : ");

            for (KnapsackItem item : knapsackItems){
                System.out.println("- " + knapsackItems.toString());
            }//for
        }//if
    }//print
}//Knapsack
