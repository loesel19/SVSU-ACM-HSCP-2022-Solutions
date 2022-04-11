import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class AboveAverage {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int cases;
        //get number of cases
        cases = sc.nextInt();
        //loop through all cases
        while(cases > 0){
            int grades = sc.nextInt();
            int[] arr = new int[grades];
            //add grades to set
            for (int i = 0; i < grades; i++){
                arr[i] = sc.nextInt();
            }
            //calculate average
            int sum = 0;
            for (int i = 0; i < grades; i++){
                sum += arr[i];
            }
            double avg = (double)sum / grades;
            //now see how many students are above average
            int above = 0;
            for (int i = 0; i < grades; i++){
                if((double) arr[i] > avg){
                    above++;
                }
            }
            //now print the percantage to 3 decimal places
            double pct = 100000.00 * above;
            pct = pct / (double) grades;
            pct = Math.round(pct);
            pct = pct/ 1000;
            System.out.printf("%.3f%s%n", pct, "%");
            //decrement cases
            cases--;
        }
    }
}