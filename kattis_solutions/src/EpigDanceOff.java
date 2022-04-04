import java.util.Scanner;

public class EpigDanceOff {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        char[][] showMeWhatYouGot = new char[rows][cols];
        //load array
        for(int i = 0; i < rows; i++){
            String strRow = sc.next();
            for(int j = 0; j < cols; j++){
                showMeWhatYouGot[i][j] = strRow.charAt(j);
            }
        }
        int moves = analyzeDance(showMeWhatYouGot, rows, cols);
        System.out.println(moves);
    }
    public static int analyzeDance(char[][] showMeWhatYouGot, int rows, int cols){
        int moves = 1; //number of moves in the dance, starts at 1
        for (int i = 0; i < cols; i++){
            boolean noDollars = true;
            for (int j = 0; j < rows; j++){
                if(showMeWhatYouGot[j][i] == '$'){
                    noDollars = false;
                    break;
                }
            }
            if(noDollars){
                moves++;
            }
        }
        return moves;
    }
}
