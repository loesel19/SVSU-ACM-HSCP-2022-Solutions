import java.util.Scanner;
/**
 * Program : ToiletSeat.java
 * Written By: Andrew A. Loesel
 * Written On : 3/23/2022
 * Organization : Saginaw Valley State University
 * Purpose - to provide a well documented solution to the kattis problem Toilet Seat - https://open.kattis.com/problems/toilet
 *
 * Kattis Submission link :
 *      https://open.kattis.com/submissions/8675403
 */
public class ToiletSeat {
    public static void main(String args[]){
        /**
         * Method : main
         * @params : String args[] - command line arguments (none used for this program)
         * @return : Void (Nothing)
         *
         * Purpose : The purpose for this method is to act as our control method for this program. We first read in the
         *           user input, and then pass this to our 3 different methods which each represent a policy. These
         *           methods then output the number of flips required based on the sequence of preferences.
         */
        Scanner sc = new Scanner(System.in); //scanner for console input
        String seq = sc.next(); //create a string that is set to the sequence of Us and Ds the user specifies
        /* we could split the first character off like so, but why bother
            char initPos = seq.charAt(0);
            seq = seq.substring(1, seq.length());
         */
        //run our method for always up
        alwaysUp(seq);
        //method for always down
        alwaysDown(seq);
        //method for preferred policy
        preferredPolicy(seq);
    }
    public static void alwaysUp(String seq){
        /**
         * Method : alwaysUp
         * @params : String seq - the sequence where the first character is the initial position and the following
         *                        characters are personal preferences.
         * @return : Void (Nothing)
         *
         * Purpose : This method is used to calculate the number of toilet seat flips required when people follow the
         *           policy of always leaving the toilet seat up. We check if the initial position requires us to perform
         *           1 flip (starts down), 2 flips(starts up but first person is D), or none. We then loop through each
         *           of the following Characters and perform a flip whenever we see a D (one flip down, and another up
         *           before leaving). Lastly print out the number of flips performed.
         */
        int flips = 0; //number of flips we perform
        /* if seq[0] is D we have to flip up regardless of the first person's preference (add 1 flip) */
        if(seq.charAt(0) == 'D'){
            flips++;
            /* if We start up, and the first person prefers down we will have to perform 2 flips */
        }else if(seq.charAt(0) != seq.charAt(1)){
            flips += 2;
        }
        /* now we can just loop through the rest of the chars (pos 2 through seq.length) and add 2 flips when we find D */
        for(int i = 2; i < seq.length(); i++){
            if(seq.charAt(i) == 'D')
                flips += 2;
        }
        //print out flips
        System.out.println(flips);
    }
    public static void alwaysDown(String seq){
        /**
         * Method : alwaysDown
         * @params : String seq - the sequence where the first character is the initial position and the following
         *                        characters are personal preferences.
         * @return : Void (Nothing)
         *
         * Purpose : This method is used to calculate the number of toilet seat flips required when people follow the
         *           policy of always leaving the toilet seat down. The logic is exactly the same as the alwaysUp method.
         *           We just replace every D in a conditional statement with a U.
         */
        int flips = 0; //number of flips we perform
        /* same as always down for logic, we just switch D's with U's in conditions */
        if(seq.charAt(0) == 'U'){
            flips++;
            /* if We start down, and the first person prefers up we will have to perform 2 flips */
        }else if(seq.charAt(0) != seq.charAt(1)){
            flips += 2;
        }
        /* now we can just loop through the rest of the chars (pos 2 through seq.length) and add 2 flips when we find U */
        for(int i = 2; i < seq.length(); i++){
            if(seq.charAt(i) == 'U')
                flips += 2;
        }
        //print out flips
        System.out.println(flips);
    }
    public static void preferredPolicy(String seq){
        /**
         * Method : preferredPolicy
         * @params : String seq - the sequence where the first character is the initial position and the following
         *                        characters are personal preferences.
         * @return : Void (Nothing)
         *
         * Purpose : This method is used to calculate the number of flips that will occur if we follow the policy
         *           of leaving the toilet seat in whatever the preferred position is. We simply have to loop through
         *           all of the characters, and check them with the previous character. If the current and previous are
         *           not the same we add 1 flip. We then print out the number of flips that occurred at the end of the
         *           method.
         */
        int flips = 0; //number of flips we perform
        /* we can loop through all the characters in the string, and add 1 whenever the previous position differs from
        the current preference */
        for(int i = 1; i < seq.length(); i++){
            if(seq.charAt(i) != seq.charAt(i - 1))
                flips++;
        }
        //print out flips
        System.out.println(flips);
    }
}
