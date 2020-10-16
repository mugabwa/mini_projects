import java.util.Scanner;                                                            //important for the input process
public class VotingSite {
    //function to calculate the age
    static int whatAge(final int year, int birthYear){
        return(year-birthYear);
    }
    //function to return a message to the voter
    static void votingFor_POTUS_Message(int age){
        if(age>=18 && age<=21){
            System.out.println("This is the first time you are eligible to vote in presidential election.");
        }
        System.out.println("Thanks for practicing your very important civic duty.");
    }
    //main function
    public static void main(String[] args){
        final int CURRENT_YEAR = 2020;                                              //Constant current year
        Scanner input = new Scanner(System.in);                                     //Object for the input operation
        Voter person = new Voter();                                                 //Voter object instatiation
        System.out.println("Please enter your fullName");                           //Message to the user
        person.setName(input.nextLine());                                           //Input full name from the user and pass to object
        System.out.println("Please enter your year of birth");                      //Message to the user
        person.setBirthYear(input.nextInt());                                       //Input year of birth from user and pass to object
        if(!person.eligibleToVote(CURRENT_YEAR)){                                   //Checks of the person is eligible
            person.ineligibleToVoteMessage(CURRENT_YEAR);                           //Person is ineligible
        }else{                                                                      //eligible to vote
            votingFor_POTUS_Message(whatAge(CURRENT_YEAR,person.getBirthYear()));   //Prints the message to the voter
        }
    }
}
