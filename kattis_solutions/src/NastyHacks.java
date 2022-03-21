/**
 * Program : NastyHacks.java
 * Written By: Andrew A. Loesel
 * Written On : 3/21/2022
 * Organization : Saginaw Valley State University
 * Purpose -
 *          The purpose of this program is to provide a well documented, accepted solution to the kattis problem Nasty
 *          Hacks - https://open.kattis.com/problems/nastyhacks -
 *          This solution executes in O(n) time complexity. All input and output is handled in the main method, all
 *          logic is found in the advertise method.
 * Kattis Submission link :
 *      https://open.kattis.com/submissions/8664731
 */

import com.sun.source.tree.IfTree;

import java.util.Scanner;

public class NastyHacks {
    public static void main(String args[]){
        /**
         * Method : main
         * @params : String args[] - command line arguments (none used for this program)
         * @return : Void (Nothing)
         *
         * Purpose : The purpose for this method is to act as our control method for this program, all input and
         *           output is handled in this method, and we control program flow in this method.
         */
        //variable declarations
        int n; //number of cases
        int r; //revenue without advertising
        int e; //revenue with advertising
        int c; //cost to advertise
        Scanner sc = new Scanner(System.in); //scanner for console input
        //read in our number of cases from input
        n = sc.nextInt();
        //loop through all our cases
        while(n > 0){
            //assign the variables appropriately - first r, then e, last c
            r = sc.nextInt();
            e = sc.nextInt();
            c = sc.nextInt();
            //now we will print out the message returned from the advertise function
            System.out.println(advertise(r, e, c));
            //decrement our loop counter variable
            n--;
        }
    }
    public static String advertise(int r, int e, int c){
        /**
         * Method : advertise
         * @params : int r - input revenue without advertising
         *           int e - input revenue with advertising
         *           int c - input cost of advertising
         * @return : String msg - returns a string representing whether to advertise, not advertise, or does not matter
         *
         * Purpose : The purpose of this method is to take in three integer inputs, and test to see if we should or
         *           shouldn't advertise our product. We will simply use a series of if statements to handle our logic.
         *           We will then return a string which is our advertising message.
         */
        String msg;
        //see if (advertising revenue(e) - cost(c)) is greater than the non advertising revenue(r)
        if(e - c > r){
            //we want to advertise
            msg = "advertise";
        }else if(e - c == r){ //see if (advertising revenue(e) - cost(c)) is equal to non advertising revenue(r)
            //advertisement does not make a difference
            msg = "does not matter";
        }else{//(advertising revenue(e) - cost(c)) is less than non advertising revenue(r)
            msg = "do not advertise";
        }
        //return our message
        return msg;
    }
}
