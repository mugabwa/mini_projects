import java.util.Scanner;
public class Project {
    public enum Project_ID
    {
        GSCP, AP, SSP, USCP;
    }
    public enum Project_Status
    {
        OPEN, CLOSED;
    }
    //Class members
    private Project_ID pID; //what type of project
    private Project_Status pStatus; //whether the project is OPEN or CLOSED
    private String projectLeader; //The name of the faculty in charge
    private Student[] teamMembers; //The team that consists of objects of type Student
    private final int maxCap = 5; //Only 5 members per team allowed.
    private int teamCount; //To keep track of number of students per team at any given time
    
    //Class Methods
    // class constructor
    public Project(String projectLeader,Project_ID pID,Project_Status pStatus)
    {
        this.pID = pID;
        this.projectLeader = projectLeader;
        this.pStatus = pStatus;
        this.teamMembers = new Student[this.maxCap];
        this.teamCount = 0;
    }
    //Setters
    public void setTeamCount(int teamCount)
    {
        this.teamCount = teamCount;
    }
    //Getters
    public int getTeamCount()
    {
        return this.teamCount;
    }
    public Project_Status getStatus(){
        return this.pStatus;
    }
    public Project_ID getProjectID(){
        return this.pID;
    }
    // Checks for the qualification conditions
    public  boolean isQualified( Project_ID projID, Student.Student_Status status)
    {
        Scanner input = new Scanner(System.in);
        //Graduate students
        if((status==Student.Student_Status.GRAD)&&(projID==Project_ID.GSCP)){
            return true;
        }   //Athlete students 
        else if((status==Student.Student_Status.ATHLETE)&&(projID==Project_ID.AP)){
            return true;
        }   //Honor students 
        else if((status==Student.Student_Status.HONOR)&&(projID==Project_ID.USCP)){
            return true;
        }   //Undergraduate Students
        else if((status==Student.Student_Status.UNDERGRAD)&&(projID==Project_ID.USCP)){
            float gpa;
            System.out.println("Please enter you GPA: ");
            gpa = input.nextFloat();
            return gpa>=3.5;
        }   //SSP students
        else if((projID==Project_ID.SSP)&&((status==Student.Student_Status.ATHLETE)||(status==Student.Student_Status.GRAD)||(status==Student.Student_Status.UNDERGRAD)||(status==Student.Student_Status.HONOR))){
            System.out.println("Are you currently enrolled as a full time student?\n1.\tYes\n2.\tNo");
            int response = input.nextInt();
            return (response==1);
        }
        return false;
    }
    // Function to display members
    public void displayTeamMembers(){
        if(this.teamCount>0)    //Check if count condition is > 0
        {
            for(int i=0; i<this.teamCount;++i){
                System.out.println(this.teamMembers[i].toString());
            }
        }
        else
        {
            System.out.println("There are no members in this team.");
        }
    }
    // Check and adds member to a particular group
    public boolean addMember(Student studentObj){
        if(this.pStatus == Project_Status.CLOSED){
            return false;
        }
        this.teamMembers[this.teamCount] = studentObj;
        ++this.teamCount;       //Increments count
        if(this.teamCount>=5){
            this.pStatus = Project_Status.CLOSED;   //Changes the project status
        }
        return true; //returns true if member is added
    }
    @Override   //override the default toString method
    public String toString(){
        return "Project ID:\t"+this.pID+"\n\tProject Leader:\t"+this.projectLeader+"\n\tProject Status:\t"+this.pStatus;
    }
}
