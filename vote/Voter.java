
public class Voter {
    private final int LEGAL_AGE = 18;   //constant age 18
    //class attributes
    private String fullName;           
    private int birthYear;
    //Class members
    public void setName(String name){
        fullName = name;
    }
    public String getName(){
        return fullName;
    }
    public void setBirthYear(int year){
        birthYear = year;
    }
    public int getBirthYear(){
        return birthYear;
    }
    //This method returns true if the age is greater or equals to legal age else return false
    public boolean eligibleToVote(final int Year){
        return (Year-birthYear) >= LEGAL_AGE;       
    }
    public void ineligibleToVoteMessage(final int currentYear){
        int waitTime=LEGAL_AGE-(currentYear-birthYear);
        System.out.println("You will be eligible to vote in " + waitTime +" year(s).");
    }
}
