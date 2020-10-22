public class Student {
    //Declare an enum type called Student_Status and declaring constants
    public enum Student_Status
    {
        UNDERGRAD, GRAD, ATHLETE, HONOR;
    }
    //Class members with private accessibility
    private Student_Status stStatus;
    private String fullName;
    
    //Class methods
    //Constructor with two parameters
    public Student(String fullName,Student_Status stStatus)
    {
        this.fullName = fullName;
        this.stStatus = stStatus;
    }
    
    //Setters
    public void setFullName(String fullName)
    {
        this.fullName = fullName;
    }
    public void setStatus(Student_Status stStatus)
    {
        this.stStatus = stStatus;
    }
    //Getters
    public String getFullName()  //Returns full name
    {
        return this.fullName;
    }
    public Student_Status getStatus()   //Returns student status
    {
        return this.stStatus;
    }
    //toString method
    @Override   // overides the default to string method
    public String toString()
    {
        return "\tName: \t"+fullName+"\tStatus:\t"+stStatus;
    }
}
