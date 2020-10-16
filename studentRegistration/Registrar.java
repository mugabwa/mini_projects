import java.util.Scanner;           //package for reading user input
import java.util.Random;
public class Registrar {
    static Scanner input = new Scanner(System.in);  //A global object to be used within the class
    //The menu method
    static void menu(Student personx){
        System.out.printf("Congratulations! Your student account is successfully activated.\n");
        boolean exitFlag = false;
        //The while loop will execute as long as the exitFlag is false
        while(!exitFlag){
            System.out.printf("Please choose an option from the following menu:\n");
            System.out.printf("1. Purchase meal plan\n" +
                "2. Apply for scholarship.\n" +
                "3. View the account balance.\n" +
                "4. View the record information.\n" + 
                "5. Exit.\n\n");
            int val = input.nextInt();
            //The switch control flow
            switch(val){
                case 1:
                    meal_submenu(personx);
                    break;
                case 2:
                    scholarship(personx);
                    break;
                case 3:
                    account_balance(personx.getBalance());
                    break;
                case 4:
                    report(personx);
                    break;
                case 5:
                    exitFlag = true;
                    break;
                default:
                    System.out.printf("Invalid option\n");
                    menu(personx);
                    break;
            }
        }
    }
    //The meal submenu function
    static void meal_submenu(Student personx){ //Thakes an object as the parameter.
        int val;
        double planA = 250;
        double planB = 300;
        double bal = personx.getBalance();
        //The if statement will execute if the use has not taken a meal plan
        if("Not Chosen".equals(personx.getMealPlan())){
            System.out.printf("Please choose the meal plan:\n" +
                "1. Plan A: $%.0f\n" +
                "2. Plan B: $%.0f \n", planA, planB);
            val = input.nextInt();
            //the statement will execute when plan A is chosen
            if(val==1){
                if(bal >= planA){
                    personx.setBalance(bal-planA);
                    personx.setMealPlan("A");
                    System.out.printf("You have successfully added meal plan A to your record.\n");
                } else{
                    System.out.printf("Unfortunately, your account balance is not sufficient for this plan.\n" +
                        "Please choose an option:\n" +
                        "1. Return to menu.\n" +
                        "2. Make a deposit.\n");
                    val=0;  //put the value to 0
                    val = input.nextInt();
                    if(val==1){
                        return;
                    }else if(val==2){
                        System.out.printf("Please enter the amount you would like to deposit in your account:\n");
                        double temp = input.nextDouble();
                        bal += temp;
                        personx.setBalance(bal);
                        return;
                    }
                }
            } else if(val==2){  //the statement will execute when plan B is chosen
                if(bal >= planB){
                    personx.setBalance(bal-planB);
                    personx.setMealPlan("B");
                    System.out.printf("You have successfully added meal plan B to your record.\n");   
                } else{
                    System.out.printf("Unfortunately, your account balance is not sufficient for this plan.\n" +
                        "Please choose an option:\n" +
                        "1. Return to menu.\n" +
                        "2. Make a deposit.\n");
                    val = input.nextInt();
                    if(val==1){
                        return;
                    }else if(val==2){
                        System.out.printf("Please enter the amount you would like to deposit in your account:\n");
                        double temp = input.nextDouble();
                        bal += temp;
                        personx.setBalance(bal);
                        return;
                    }
                }
            }
        } else{
            System.out.printf("You already have meal plan %s associated with your account.\n", personx.getMealPlan());
        }
        
    }
    //Scholarship method
    static void scholarship(Student personx){
        double limit = 3.5;
        if(personx.getGPA()>=limit){
            System.out.printf("Congratulations! You meet the criteria for scholarship. Your name is\n" +
                "added to the list of prospective recipients.\n\n");
            personx.setScholarshipApplication("Added");
        } else{
            System.out.printf("The GPA cut for scholarship qualification is 3.5 and higher.\n\n");
        }
    }
    //Balance method
    static void account_balance(double balance){
        System.out.printf("Your account balance is: $%.2f\n\n", balance);
    }
    //Report method
    static void report(Student personx){
        personx.reportInfo();
    }
    //Main method
    public static void main(String[] args){
        System.out.printf("Please the student's fullName\n"); //display to user
        String name = input.nextLine(); //prompt the user to input
        System.out.printf("Please the student's GPA\n"); //display the user
        double gpa = input.nextDouble(); //wait for the user to input
        System.out.printf("Enter the amount of money you want to deposit\n");   //display the user
        double account = input.nextDouble();    //wait for the user to input
        System.out.printf("\n");
        Student person = new Student(name,gpa,account); //instantiate the object of the class Student
        menu(person);   //call the main method with object as the argument
 
    }
}
