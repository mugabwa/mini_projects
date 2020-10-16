import java.util.Random;
import java.util.Scanner;
public class SalesSite {
    private final String branch;
    //Parameterized constructor
    public SalesSite(String branch){
        this.branch = branch;
    }
    //the get method
    public String getBranch(){return branch;}
    //Assign the product a random inventory value in range 10-100 inclusively
    public void createInventory(Product a,Product b,Product c,Product d){
        Random random = new Random(); //instance of the random
        int max=100;    //maximum value
        int min=10;     //minimum value
        int rand;
        for(int i=1; i<5; ++i){
            rand = random.nextInt((max-min)+1)+min; //find the random value between min-max inclusive
            //the switch conditional statement where the inventory number is assigned in each product
            switch (i){
                case 1:
                    a.setNumInventory(rand);
                    break;
                case 2:
                    b.setNumInventory(rand);
                    break;
                case 3:
                    c.setNumInventory(rand);
                    break;
                case 4:
                    d.setNumInventory(rand);
            }
        }
    }
    //display the menu and return an integer
    public int orderMenu(){
        Scanner scn = new Scanner(System.in);
        System.out.printf("\nWelcome to our %s site. \n\nPlease choose an option:\n\n"
                + "\t1. Place an order for Product A\n"
                + "\t2. Place an order for Product B\n"
                + "\t3. View Order List\n"
                + "\t4. View inventory\n"
                + "\t5. View The Bill\n"
                + "\t6. Exit.\n", branch);
        int val = scn.nextInt();
        return val;
    }
    //checks if the amount ordered is available, adjust the inventory and order value and return true, else returns false
    public boolean checkAndProcess(Product x, int value){
        if(x.getNumInventory()>=value){
            x.setNumInventory(x.getNumInventory()-value);
            x.setNumOrdered(x.getNumOrdered()+value);
            return true;
        }else{
            return false;
        }  
    }
    //Returns the report of ordered products
    public void orderReport(Product a,Product b,Product c,Product d){
        
        if(a.getNumOrdered()>0 || b.getNumOrdered()>0 || c.getNumOrdered()>0 || d.getNumOrdered()>0){
            if(a.getNumOrdered()>0){
                a.productOrderInfo();
            }
            if(b.getNumOrdered()>0){
                b.productOrderInfo();
            }
            if(c.getNumOrdered()>0){
                c.productOrderInfo();
            }
            if(d.getNumOrdered()>0){
                d.productOrderInfo();
            }
        }else{
            System.out.println("Your shopping cart is empty.");
        }
    }
    //Calculate and return the invoice total price
    public double theChange(Product a,Product b,Product c,Product d){
        double total=0;
        if(a.getNumOrdered()>0){
            total += a.totalProductCharge();
        }
        if(b.getNumOrdered()>0){
            total += b.totalProductCharge();
        }
        if(c.getNumOrdered()>0){
            total += c.totalProductCharge();
        }
        if(d.getNumOrdered()>0){
            total += d.totalProductCharge();
        }
        return total;
    }
    
}
