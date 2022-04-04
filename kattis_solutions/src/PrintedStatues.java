import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PrintedStatues {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int statues = sc.nextInt();
        System.out.println(Collections.min(calculateDays(statues)));
    }

    public static HashSet<Integer> calculateDays(int statues){
        Set<Integer> s = new HashSet();
        for(int i = 1; i < statues; i++){
            /* you can either make a printer or start printing statues on a given day, so we
               just loop through each day and see how long it would take if we started printing
               statues on day i */
            int madePrinter = (int)Math.ceil((double)statues /Math.pow(2, i));
            madePrinter += i;
            s.add(madePrinter);

        }
        s.add(statues);
        return (HashSet<Integer>) s;
    }
}
