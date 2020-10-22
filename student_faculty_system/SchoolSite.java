import java.util.Scanner;
public class SchoolSite 
{
    // Displays the project menu
    static void projectMenu(){
        System.out.println("List of Projects:\n1.\tGraduate Science Project (GSCP)\n2.\tAthletic Project (AP)\n3.\tSocial Studies Project (SSP)\n"
                + "4.\tUndergraduage Science Project (USCP)");
    }
    // Displays the student menu
    static void studentMenu(){
        System.out.println("What is your status:");
        System.out.println("1.\tUndergraduate\n2.\tGraduate\n3.\tStudent Athlete\n4.\tHonor Student");
        
    }
    // Override of the default toString method
    static String toString(int val){
        String[] array={"GSCP","AP","SSP","USCP"};
        return "Project ID:\t"+array[val]+"\tNOT REGISTERED.";
    }
    //Function overloading
    static String toString(Project.Project_Status status,int val){
        String[] array={"GSCP","AP","SSP","USCP"};
        return "Project ID:\t"+array[val]+"\t"+status+".";
    }
    //Main method
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);     //Used to read input
        Project[] objProj = new Project[4];         //empty array of objects
        int response,status,response1,response2,response3;
        String name;
        int itr = 0;
        boolean proceed,checkFaculty,checkStudent;
        //The main loop
        do{
            proceed = true;     //main loop will run as lon as the value is true
            System.out.println("Please select an option below:");
            System.out.println("1.\tFaculty \n2.\tStudent \n3.\tExit");
            response = input.nextInt();
            //Switch condition on user input
            switch (response) {
                // Faculty
                case 1:
                    // Faculty loop
                    do{
                        checkFaculty=true;
                        System.out.println("1.\tRegister a project\n2.\tView the projects' full information\n"
                                + "3.\tBack to main menu");
                        response1 = input.nextInt();
                        switch (response1) {
                            case 1:
                                System.out.println("Please enter your full name.");
                                input.nextLine();
                                name = input.nextLine();
                                projectMenu();
                                status = input.nextInt();
                                switch(status){
                                    case 1:
                                        objProj[itr] = new Project(name,Project.Project_ID.GSCP,Project.Project_Status.OPEN);
                                        ++itr;
                                        break;
                                    case 2:
                                        objProj[itr] = new Project(name,Project.Project_ID.AP,Project.Project_Status.OPEN);
                                        ++itr;
                                        break;
                                    case 3:
                                        objProj[itr] = new Project(name,Project.Project_ID.SSP,Project.Project_Status.OPEN);
                                        ++itr;
                                        break;
                                    case 4:
                                        objProj[itr] = new Project(name,Project.Project_ID.USCP,Project.Project_Status.OPEN);
                                        ++itr;
                                        break;
                                    default:
                                        break;
                                }
                                break;
                            case 2:
                                for(int i=0; i<4;++i){
                                    if(objProj[i]==null){
                                        System.out.println(toString(i));
                                    }else{
                                        System.out.println(objProj[i].toString());
                                        System.out.println();
                                        objProj[i].displayTeamMembers();
                                        System.out.println();
                                    }
                                }
                                break;
                            case 3:
                                checkFaculty = false;
                                break;
                            default:
                                break;
                        }
                    }while(checkFaculty);
                    break;
                // Student
                case 2:
                    studentMenu();
                    status = input.nextInt();
                    // Student loop
                    do{
                        checkStudent=true;
                        System.out.println("1.\tView project status\n2.\tApply for a project\n"
                                + "3.\tBack to main menu");
                        response3 = input.nextInt();
                        if(response3==1){
                            for(int i=0; i<4;++i){
                                if(objProj[i]==null){
                                    System.out.println(toString(i));
                                }else{
                                    System.out.println(toString(objProj[i].getStatus(),i));
                                }
                            }
                        } else if(response3==2){
                            projectMenu();
                            response2 = input.nextInt();
                            System.out.println("Please enter your full name.");
                            input.nextLine();
                            name = input.nextLine();
                            Student student=null;
                            if(status==1){
                                student = new Student(name,Student.Student_Status.UNDERGRAD);
                            }else if(status==2){
                                student = new Student(name,Student.Student_Status.GRAD);
                            }else if(status==3){
                                student = new Student(name,Student.Student_Status.ATHLETE);
                            }else if(status==4){
                                student = new Student(name,Student.Student_Status.HONOR);
                            }
                            switch (response2) {
                                case 1:
                                    if(objProj[response2-1]==null){
                                        System.out.println("The project is currently not open.");
                                    }else{
                                        if(objProj[response2-1].isQualified(objProj[response2-1].getProjectID(), student.getStatus())){
                                            if(objProj[response2-1].addMember(student)){
                                                System.out.println("You are successfully added to project GSCP.");
                                            }else{
                                                System.out.println("The project is currently not open.");
                                            }
                                        }else{
                                            System.out.println("Unfortunately you do not meet the criteria for this project.");
                                        }
                                    }   break;
                                case 2:
                                    if(objProj[response2-1]==null){
                                        System.out.println("The project is currently not open.");
                                    }else{
                                        if(objProj[response2-1].isQualified(objProj[response2-1].getProjectID(), student.getStatus())){
                                            if(objProj[response2-1].addMember(student)){
                                                System.out.println("You are successfully added to project AP.");
                                            }else{
                                                System.out.println("The project is currently not open.");
                                            }
                                        }else{
                                            System.out.println("Unfortunately you do not meet the criteria for this project.");
                                        }
                                    }   break;
                                case 3:
                                    if(objProj[response2-1]==null){
                                        System.out.println("The project is currently not open.");
                                    }else{
                                        if(objProj[response2-1].isQualified(objProj[response2-1].getProjectID(), student.getStatus())){
                                            
                                            if(objProj[response2-1].addMember(student)){
                                                System.out.println("You are successfully added to project SSP.");
                                            }else{
                                                System.out.println("The project is currently not open.");
                                            }
                                        }else{
                                            System.out.println("Unfortunately you do not meet the criteria for this project.");
                                        }
                                    }   break;
                                case 4:
                                    if(objProj[response2-1]==null){
                                        System.out.println("The project is currently not open.");
                                    }else{
                                        if(objProj[response2-1].isQualified(objProj[response2-1].getProjectID(), student.getStatus())){
                                            if(objProj[response2-1].addMember(student)){
                                                System.out.println("You are successfully added to project USCP.");
                                            }else{
                                                System.out.println("The project is currently not open.");
                                            }
                                        }else{
                                            System.out.println("Unfortunately you do not meet the criteria for this project.");
                                        }
                                    }   break;
                                default:
                                    break;
                            }
                        }else if(response3 == 3){
                            checkStudent = false;
                        }
                    }while(checkStudent);
                    break;
                //exit
                case 3:
                    proceed = false;
                    break;
                default:
                    break;
            }
        }while(proceed);
        
    }
}
