import java.util.ArrayList;
import java.util.Scanner;

public class HotHike {
    public static void main(String args[]){
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
