import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class MagicTrick {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        char[] chars = input.toCharArray();
        Set<Character> s = new HashSet();
        int guess = 1;
        for(int i = 0; i < chars.length; i++){
            if (s.contains(chars[i])){
                guess = 0;
                break;
            }else{
                s.add(chars[i]);
            }
        }
        System.out.println(guess);
    }
}
