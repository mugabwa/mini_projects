import java.util.Scanner;
public class SalesTest {
    //the driver method
    public static void main(String[] args){
        //Object instantiation
        Scanner scn = new Scanner(System.in);
        Product pr1 = new Product("A","Blue",10.5);
        Product pr2 = new Product("A","Red",9.99);
        Product pr3 = new Product("B","Blue",12.75);
        Product pr4 = new Product("B","Red",14.99);
        //display
        System.out.println("Please enter the name of the shopping site: ");
        //input
        String name = scn.nextLine();
        //object instatiation
        SalesSite s1 = new SalesSite(name);
        //calling a method
        s1.createInventory(pr1, pr2, pr3, pr4);
        boolean exit = false;
        //call the menu method and assign its returned value
        int status = s1.orderMenu();
        //the loop executes as long use the exit flag is false
        do{     //start of do...while loop
            switch (status){
                //option 1
                case 1:
                    System.out.println("Please choose the color:\n" +
"\t1. Blue\n" +
"\t2. Red");
                    int value = scn.nextInt();
                    System.out.println("Please enter the order amount:");
                    int amount = scn.nextInt();
                    if(value==1){
                        if(s1.checkAndProcess(pr1, amount)){
                            System.out.println("Order successfully processed.\n. . .");
                        } else{
                            System.out.println("Sorry, your order cannot be fulfilled at this time.\n. . .");
                        }
                    }else if(value==2){
                        if(s1.checkAndProcess(pr2, amount)){
                            System.out.println("Order successfully processed.\n. . .");
                        } else{
                            System.out.println("Sorry, your order cannot be fulfilled at this time.\n. . .");
                        }
                    }
                    break;
                    //option 2
                case 2:
                    System.out.println("Please choose the color:\n" +
"\t1. Blue\n" +
"\t2. Red");
                    value = scn.nextInt();
                    System.out.println("Please enter the order amount:");
                    amount = scn.nextInt();
                    if(value==1){
                        if(s1.checkAndProcess(pr3, amount)){
                            System.out.println("Order successfully processed.\n. . .");
                        } else{
                            System.out.println("Sorry, your order cannot be fulfilled at this time.\n. . .");
                        }
                    }else if(value==2){
                        if(s1.checkAndProcess(pr4, amount)){
                            System.out.println("Order successfully processed.\n. . .");
                        } else{
                            System.out.println("Sorry, your order cannot be fulfilled at this time.\n. . .");
                        }
                    }
                    break;
//                    option 3
                case 3:
                    s1.orderReport(pr1, pr2, pr3, pr4);
                    System.out.println(". . .");
                    break;
                    //option 4
                case 4:
                    pr1.productInventoryInfo();
                    System.out.println();
                    pr2.productInventoryInfo();
                    System.out.println();
                    pr3.productInventoryInfo();
                    System.out.println();
                    pr4.productInventoryInfo();
                    System.out.println("\n. . .");
                    break;
                    //option 5
                case 5:
                    System.out.printf("The total charge is %.2f\n",s1.theChange(pr1, pr2, pr3, pr4));
                    System.out.println(". . .");
                    break;
//                    option 6
                case 6:
                    exit = true;
                    break;
            }
//            the if statement will run as long use the exit flag if false
            if(!exit){
                status = scn.nextInt();
            }
        }while(!exit); //end of the do..while loop
        
    }
}
