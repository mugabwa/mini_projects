public class Student {
    //private members which can only be accessed directly by methods in the class
    private final String fullName;
    private final double GPA;
    private double balance;
    private String mealPlan;
    private String scholarshipApplication;
    //Constructor method which is parameterized
    Student(String nm, double gp, double amnt){
        fullName = nm;
        GPA = gp;
        balance = amnt;
        mealPlan = "Not Chosen";
        scholarshipApplication = "Void";
    }
    //The get and set of the private methods
    public void setMealPlan(String temp){
        mealPlan = temp;
    }
    public String getMealPlan(){
        return mealPlan;
    }
    public void setBalance(double bal){
        balance = bal;
    }
    public double getBalance(){
        return balance;
    }
    public double getGPA(){
        return GPA;
    }
    public void setScholarshipApplication(String temp){
        scholarshipApplication = temp;
    }
    //The report method used for displaying information about the student
    public void reportInfo(){
        System.out.printf("Name: %s\nGPA: %.2f\n" +
            "Account Balance: $%.2f\nMeal Plan: %s\n" +
            "Scholarship Request Status: %s\n\n", fullName, GPA,
            balance, mealPlan, scholarshipApplication);
    }
}