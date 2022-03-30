import java.util.ArrayList;
import java.util.Scanner;
/**
 * Program : HotHike.java
 * Written By: Andrew A. Loesel
 * Written On : 3/30/2022
 * Organization : Saginaw Valley State University
 * Purpose - to provide a well documented solution to the kattis problem Hot Hike - https://open.kattis.com/problems/hothike
 *
 * Kattis Submission link :
 *      https://open.kattis.com/submissions/8723120
 */
public class HotHike {
    public static void main(String args[]){
        /**
         * Method : main
         * @param : String args[] - command line arguments (none used for this program)
         * @return : Void (Nothing)
         * Purpose -
         *          The purpose of this method is to act as our main program method. We control the program flow
         *          in here. We first read in all of the required input for the problem. Then we pass the data to
         *          findLowestTemps which returns an array with the lowest start day index, and the highest temp
         *          of the lowest 2 days. We then print these out
         *
         */
        Scanner sc = new Scanner(System.in); //scanner for reading input
        int days = sc.nextInt(); //number of days for the trip
        //read in temperatures
        int[] temps = new int[days]; //temperatures for given day
        for(int i = 0; i < days; i++)
            temps[i] = sc.nextInt();
        /* now we want to see which day to start our trip on as well as the lowest max temp for the two hiking
         * days, lets create a function for this */
        int[] lowest = findLowestTemps(temps); //an array of two elements, 0 is lowest index, 1 is lowest max
        //now we need to print the start day(lowest index + 1) and the lowest temp of the two hike days
        System.out.println((lowest[0] + 1) + " " + lowest[1]);
    }
    public static int[] findLowestTemps(int[] temps){
        /**
         * Method : findLowestTemps
         * @param : int[] temps - The temperatures on each day that we are looking to go on vacation
         * @return : int[] - returns the lowest start day index [0] and the lowest max temperature for any
         *                   given two hiking days [1]
         * Purpose -
         *          The purpose of this function is to loop through all of our temperatures, and
         *          find the two days with the lowest temperatures. We will then return the index
         *          of the day we start on to get the lowest hiking temps, and the higher of the two
         *          temperatures.
         *
         */
        int lowestIndex = 0; //the index of the start of the trip with the lowest avg
        int lowestMax = 4137467; //the max value of the lowest two temp days, starts at max val for integer
        for(int i = 0; i < temps.length - 2; i++){
            if (temps[i] < lowestMax && temps[i+2] < lowestMax){
                //set the lowest index
                lowestIndex = i;
                //now we set the lowestMax to the higher of the two values
                if (temps[i] > temps[i+2])
                    lowestMax = temps[i];
                else
                    lowestMax = temps[i+2];
            }
        }
        //return the lowest index and lowest max as an array
        return new int[]{lowestIndex, lowestMax};
    }
}
