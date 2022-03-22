import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
    public static void main(String args[]){
        /**
         * Method : main
         * @param : String args[] - command line arguments (none used for this program)
         * @return : Void (Nothing)
         *
         *
         */
        //create a hashmep for all posible combinations of four 4's with + - * / as operators as the key, and what they equal as the value
        Map<String, Integer> expr = new HashMap<String, Integer>(); //a hashmap storing key-value-pairs with keys = expression, value = value of expression
        expr = generateExpressions();
    }
    public static HashMap<String, Integer> generateExpressions(){
        Map<String, Integer> generator = new HashMap<String, Integer>(); //the hashmap we generate all possible combinations into
        String operators[] = {"+", "-", "/", "*"};
        for(int i = 0; i < operators.length; i++){
            for(int j = 0; j < operators.length; j++) {
                for (int k = 0; k < operators.length; k++) {
                String expression = "4 " + operators[i] + " 4 " + operators[j] + " 4 " + operators[k];
                int value = evaluateExpression(expression);
                }
            }
        }

        return (HashMap<String, Integer>) generator; //have to explicitly cast it as a hashmap for the return statement
    }
    public static int evaluateExpression(String expression){
        int val = 0;

        return val;
    }
}
