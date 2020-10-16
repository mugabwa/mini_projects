public class Product {
    //Class members
    private final String pID;
    private final String color;
    private int numInventory;
    private int numOrdered;
    private final double pricePerUnit;
    //parameterized constructor
    public Product(String pID, String color, double pricePerUnit){
        this.pID = pID;
        this.color = color;
        this.pricePerUnit = pricePerUnit; 
        numInventory = 0;
        numOrdered = 0;
   }
    //The set methods
    public void setNumInventory(int numInventory){this.numInventory = numInventory;}
    public void setNumOrdered(int numOrdered){this.numOrdered = numOrdered;}
    //the get methods
    public int getNumInventory(){return numInventory;}
    public int getNumOrdered(){return numOrdered;}
    //display the order information
    public void productOrderInfo(){
        System.out.printf("Product ID: %s - Color: %s - Units Ordered: %d\n", pID, color, numOrdered);
    }
    //display the inventory information
    public void productInventoryInfo(){
        System.out.printf("Product ID: %s - Color: %s - Units in Stock: %d", pID, color, numInventory);
    }
    //return the total price
    public double totalProductCharge(){
        return (numOrdered*pricePerUnit);
    }
}
