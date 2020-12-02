public class KnapsackItem {

    //Our spices will have the attributes of
        //spiceName -- Here being a color name
        //totalPrice -- Represented in "quatloos"
        //quantity -- How many "scoops"

    private String spiceName;
    private double totalPrice;
    private int quantity;
    private final double unitPrice;

    public KnapsackItem(String name, double price, int qty){
        spiceName = name;
        totalPrice = price;
        quantity = qty;

        unitPrice = price/quantity;
    }//knapsackItem Constructor

    public int getQuantity() {
        return quantity;
    }//getQuantity

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }//setQuantity

    public double getTotalPrice() {
        return totalPrice;
    }//getTotalPrice

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }//setTotalPrice

    public String getSpiceName() {
        return spiceName;
    }//getSpiceName

    public void setSpiceName(String spiceName) {
        this.spiceName = spiceName;
    }//setSpiceName

    public double getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return "KnapsackItem{" +
                "spiceName='" + spiceName + '\'' +
                ", totalPrice=" + totalPrice +
                ", quantity=" + quantity +
                '}';
    }//toString
}
