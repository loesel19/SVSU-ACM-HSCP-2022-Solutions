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
 *          The purpose of this program is to provide a well documented, accepted solution to the kattis problem 4
 *          Thought - https://open.kattis.com/problems/4thought - Note that there are much much better ways to do this problem.
 *          If you are familiar with hashmaps you might've thought we can use whatever number an expression evaluates to
 *          as a key, and then the actual expression as the value, which would allow us to forego the for each loop search of
 *          the map while trying to find a solution to print in main, but this method should be fairly digestible for
 *          most people.
 *
 * Kattis Submission link : https://open.kattis.com/submissions/8670955
 *
 * If you are interested in HashMaps I suggest giving the w3Schools article - https://www.w3schools.com/java/java_hashmap.asp -
 * a read since they are one of the most powerful structures in Java.
 */
public class FourThought {
    public static void main(String args[]) {
        /**
         * Method : main
         * @param : String args[] - command line arguments (none used for this program)
         * @return : Void (Nothing)
         * Purpose -
         *          The purpose of this method is to act as our main program method. We control the program flow
         *          in here. We first generate all possible expressions of form 4 (+|-|*|/) 4 (+|-|*|/) 4 (+|-|*|/) 4
         *          into a HashMap. we then read in user-specified values with the scanner, first is number of cases n,
         *          the following n inputs will each be a proposed solution to a generated expression. With our hashmap
         *          we can see if values set contains the proposed solution, if no we print out no solution. If yes we
         *          must iterate through every entry in the hashmap until we find one with a value equal to the proposed
         *          solution, and then print out the key (which is a string containing the first expression we encounter
         *          that evaluates to the solution). We have a boolean called found which we set to true when a solution is
         *          found so that we only print out the first valid expression.
         *
         */
        Scanner sc = new Scanner(System.in); //our scanner for input
        Map<String, Integer> expr = new HashMap<String, Integer>(); //a hashmap storing key-value-pairs with keys = expression, value = value of expression
        expr = generateExpressions(); //this line assigns all possible expression of problem criteria to expr, with solutions as the value
        int cases = sc.nextInt(); //number of cases we want to test, will be read from first line of user input
        //now loop through the rest of our inputs, and see if our hashmap contains the value
        for (int i = 0; i < cases; i++) {
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
         *Purpose :
         *          This method will be used similarly to a generator for a Context Free Grammar, meaning that
         *          we will generate every possible expression given our criteria. 3 loops are nested, call them loops
         *          i, j and k. Each loop is tied to one of our three mathematical operators. The way I solved this was
         *          by splitting the logic into different cases depending on what our middle operator was. So if our middle
         *          operator is a + or - we pass only the current operators (i, j, k are used as indexes to grab from all the
         *          possible operators) into the method plusMinusCase which deals with an expression where the middle
         *          operator is a + or -, otherwise we call timesDivCase which deals with our * and / middle operator
         *          cases. We then place the expression and integer that it resolved to into our HashMap.
         *
         */
        Map<String, Integer> generator = new HashMap<String, Integer>(); //the hashmap we generate all possible combinations into
        String operators[] = {"+", "-", "/", "*"}; //all possible operators for the expression
        for(int i = 0; i < operators.length; i++){
            for(int j = 0; j < operators.length; j++) {
                for (int k = 0; k < operators.length; k++) {
                    //generate a new expression to solve
                String expression = "4 " + operators[i] + " 4 " + operators[j] + " 4 " + operators[k] + " 4";
                int value; // he value our expression evaluates to
                //now we check what our middle operator is and call the appropriate method
                    //we have to get an array with our current 3 operators to pass to our evaluation methods
                    String[] currOps = {operators[i], operators[j], operators[k]};
                    if(operators[j].equals("+") || operators[j].equals("-")){
                        value = plusMinusCase(currOps);
                    }else{
                        value = timesDivCase(currOps);
                    }
                    //now we need to add our string expression, and int value to our hashmap.
                    generator.put(expression, value);
                }
            }
        }

        return (HashMap<String, Integer>) generator; //have to explicitly cast it as a hashmap for the return statement
    }

    public static int plusMinusCase(String ops[]){
        /**
         * Method : plusMinusCase
         * @param : String ops[] - this is a String array with 3 elements, each element corresponds to a mathematical
         *          operator, and the order of the elements matters.
         * @return : returns int resVal - the final value that the input operators evaluate to given the rules of the
         *           problem.
         *Purpose :
         *          - The purpose of this method is to evaluate an expression where the middle operator, op[1], is either
         *            a + or -. We can evaluate our order of operations based on when a higher or lower precedence operator
         *            shows up, and the comments below explain my logic for setting up the conditions in this certain way.
         *            Note there are plenty of ways to do this subproblem, such as nesting case statements, but I chose
         *            a method that would be most digestible to everyone.
         */
        int firstVal; //the value that our first operator and its left and right operands evaluate to
        int resVal; //the final result of the expression
        if(ops[0].equals("*")) {
            firstVal = 4 * 4;
        } else if(ops[0].equals("/")) {
            firstVal = 4 / 4;
        }else if(ops[0].equals("+")) {
            firstVal = 4 + 4;
        }else{
            firstVal = 4 - 4;
        }
        /* when the last operation is a * or a / we can operate like normal, you will see why we can not
            for + and - in a second */
        if(ops[2].equals("*")) {
            if(ops[1].equals("+"))
                resVal = firstVal + (4 * 4);
            else
                resVal = firstVal - (4 * 4);
        }else if(ops[2].equals("/")) {
            if(ops[1].equals("+"))
                resVal = firstVal + (4 / 4);
            else
                resVal = firstVal - (4 / 4);
        /*  if we have a + or - think about how the two above conditions would evaluate the exoression
            4 / 4 - 4 + 4  : we already evaluated 4 / 4 to 1, if we do the same as above the 4 + 4 at the
            end of this expression will go to 8 then we will do 1 - 8 = -7, which is incorrect.
            for the + or - case here we must first do our middle operation in order to obtain the correct
            result. */
        }else if(ops[2].equals("+")) {
            if(ops[1].equals("+")){
                resVal = (firstVal + 4) + 4;
            }else{
                resVal = (firstVal - 4) + 4;
            }
        }else {
            if(ops[1].equals("+")){
                resVal = (firstVal + 4) - 4;
            }else{
                resVal = (firstVal - 4) - 4;
            }
        }
        return resVal;
    }

    public static int timesDivCase(String ops[]){
        /**
         * Method : timesDivCase
         * @param : String ops[] - this is a String array with 3 elements, each element corresponds to a mathematical
         *          operator, and the order of the elements matters.
         * @return : returns int middle - throughout this method middle gets set to different mid expression values, but
         *                                when returned it will be the final result of the expression.
         *Purpose :
         *          - The purpose of this method is to solve expressions where our middle operator is a * or /. We know that
         *            we can start by multiplying or dividing the middle 4's, and then using if conditions we can control
         *            in what order the first and last operations are performed. We need to control these because if our order
         *            of operations is always middle -> first -> last (4 - 4 * 4 * 4) will evaluate to (4 - (16) * 4) then
         *            (-12 * 4) and lastly -48, when it should evaluate to - 60. So depending on operator precedence we
         *            may have to do m -> f -> l or m -> l -> f or order may not matter at all. The inline comments will
         *            explain when order matters and why.
         */
        int middle;
        if(ops[1].equals("*")){
            middle = 4 * 4;
        }else{
            middle = 4 / 4;
        }
        /*  now if first operator is * we multiple middle by 4, if / we divide by 4, do not do + or -
            yet in case our third operator is a * or /, say we have 4 + 4 / 4 * 4, if we follow the
            algorithm above we would first get 4 + (1) * 4, then we would do 4 + 1 -> 5 * 4 = 20, which
            would not be correct. */
        if(ops[0].equals("*")){
            middle = middle * 4;
            //and we do whatever our third operator is to middle
            if(ops[2].equals("*"))
                middle = middle * 4;
            else if(ops[2].equals("/"))
                middle = middle / 4;
            else if(ops[2].equals("+"))
                middle = middle + 4;
            else
                middle = middle - 4;
        }else if(ops[0].equals("/")){
            middle = middle / 4;
            //and we do whatever our third operator is to middle
            if(ops[2].equals("*"))
                middle = middle * 4;
            else if(ops[2].equals("/"))
                middle = middle / 4;
            else if(ops[2].equals("+"))
                middle = middle + 4;
            else
                middle = middle - 4;
        }else{
            /*  we will do the last operation now if * or / since it has precedence over the first
                which if we are in this condition must be a + or -  */
            if(ops[2].equals("*")) {
                middle = middle * 4;
                if(ops[0].equals("+"))
                    middle = 4 + middle;
                else
                    middle = 4 - middle;
            }else if(ops[2].equals("/")) {
                middle = middle / 4;
                if(ops[0].equals("+"))
                    middle = 4 + middle;
                else
                    middle = 4 - middle;
            /*  when last operator is also a + or - we have to do the first operation prior to last */
            }else if(ops[2].equals("+")) {
                if(ops[0].equals("+"))
                    middle = 4 + middle;
                else
                    middle = 4 - middle;
                middle = middle + 4;
            }else {
                if(ops[0].equals("+"))
                    middle = 4 + middle;
                else
                    middle = 4 - middle;
                middle = middle - 4;
            }
        }
        return middle;
    }
}
