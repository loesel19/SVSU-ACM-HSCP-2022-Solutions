import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * Program : FourThought.java
 * Written By: Andrew A. Loesel
 * Written On : 3/21/2022
 * Organization : Saginaw Valley State University
 * Purpose -
 *          The purpose of this program is to provide a well documented, accepted solution to the kattis problem Four
 *          Thought - https://open.kattis.com/problems/4thought -
 *
 * Kattis Submission link :
 *
 */
public class FourThought {
    static int pmc = 0;
    public static void main(String args[]) {
        /**
         * Method : main
         * @param : String args[] - command line arguments (none used for this program)
         * @return : Void (Nothing)
         *
         *
         */
        Scanner sc = new Scanner(System.in); //our scanner for input
        Map<String, Integer> expr = new HashMap<String, Integer>(); //a hashmap storing key-value-pairs with keys = expression, value = value of expression
        expr = generateExpressions();
        //now we want to read the inputs, first will be the number of solutions we have to find
        int solutions = sc.nextInt();
        //now loop through the rest of our inputs, and see if our hashmap contains the value
        for (int i = 0; i < solutions; i++) {
            int val = sc.nextInt();
            if (expr.containsValue(val)) {
                /* now we have to iterate over the hashmap using a for each, and when we find an entry with our
                    desired value we can print it off using printf. */
                boolean found = false;
                for (Map.Entry<String, Integer> entry : expr.entrySet()) {
                    if (Objects.equals(entry.getValue(), val) && !found) {
                        System.out.printf("%s = %d%n", entry.getKey(), val);
                        found = true;
                    }
                }
            }else{
                System.out.println("no solution");
            }
        }
    }
    public static HashMap<String, Integer> generateExpressions(){
        /**
         * Method : generateExpressions
         * @param : None
         * @return : returns Hashmap<String, Integer>() generator - a hashmap with all possible 4 {+, -, *, /} expressions
         *           as strings for the keys, and what they evaluate to as integer value.
         *
         *
         */
        Map<String, Integer> generator = new HashMap<String, Integer>(); //the hashmap we generate all possible combinations into
        String operators[] = {"+", "-", "/", "*"};
        for(int i = 0; i < operators.length; i++){
            for(int j = 0; j < operators.length; j++) {
                for (int k = 0; k < operators.length; k++) {
                String expression = "4 " + operators[i] + " 4 " + operators[j] + " 4 " + operators[k] + " 4";
                int value;
                //now we check what our middle operator is and call the appropriate method
                    if(operators[j].equals("+")){
                        System.out.println(expression);
                        int[] vals =plusMinusCase(operators);
                        value = vals[0] + vals[1];
                    }else if(operators[j].equals("-")){
                        System.out.println(expression);
                        int[] vals =plusMinusCase(operators);
                        value = vals[0] - vals[1];
                    }else{
                        value = timesDivCase(operators);
                    }
                    //now we need to add our string expression, and int value to our hashmap.
                    generator.put(expression, value);
                }
            }
        }

        return (HashMap<String, Integer>) generator; //have to explicitly cast it as a hashmap for the return statement
    }

    public static int[] plusMinusCase(String ops[]){
        pmc++;
        int[] vals = {0,0};
        if(ops[0].equals("*")) {
            vals[0] = 4 * 4;
        } else if(ops[0].equals("/")) {
            vals[0] = 4 / 4;
        }else if(ops[0].equals("+")) {
            System.out.println("***::" + ops[0]);
            vals[0] = 4 + 4;
        }else{
            vals[0] = 4 - 4;
        }
        if(ops[2].equals("*")) {
            vals[1] = 4 * 4;
        }else if(ops[2].equals("/")) {
            System.out.println("***::" + ops[2]);
            vals[1] = 4 / 4;
        }else if(ops[2].equals("+")) {
            vals[1] = 4 + 4;
        }else {
            vals[1] = 4 - 4;
        }
        //now we can just add val1 and val2 together and return them
        System.out.println("pmc " + pmc + " : v1 " + vals[0] + ", v2 " + vals[1]);
        return vals;
    }

    public static int timesDivCase(String ops[]){
        int middle;
        if(ops[1].equals("*")){
            middle = 4 * 4;
        }else{
            middle = 4 / 4;
        }
        //now if first operator is * we multiple middle by 4, if / we divide by 4
        if(ops[0].equals("*")){
            middle = middle * 4;
            //and we do whatever our third operator is to middle
            if(ops[2].equals("*"))
                middle = middle * 4;
            else if(ops[2].equals("/"))
                middle = middle * 4;
            else if(ops[2].equals("+"))
                middle = middle * 4;
            else
                middle = middle * 4;
        }else if(ops[0].equals("/")){
            middle = middle / 4;
            //and we do whatever our third operator is to middle
            if(ops[2].equals("*"))
                middle = middle * 4;
            else if(ops[2].equals("/"))
                middle = middle * 4;
            else if(ops[2].equals("+"))
                middle = middle * 4;
            else
                middle = middle * 4;
        }else{
            //we do our third operator to middle first, and add or subtract first operator after
            if(ops[2].equals("*"))
                middle = middle * 4;
            else if(ops[2].equals("/"))
                middle = middle * 4;
            else if(ops[2].equals("+"))
                middle = middle * 4;
            else
                middle = middle * 4;
            if(ops[0].equals("+"))
                middle = middle + 4;
            else
                middle = middle - 4;
        }
        return middle;
    }
}
