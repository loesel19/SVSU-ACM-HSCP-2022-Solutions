import java.util.Scanner;

public class GameOfThrowns {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int students = sc.nextInt();
        int numCmds = sc.nextInt();
        int[] allPositions = new int[numCmds + 1];
        allPositions[0] = 0;
        for (int i = 1; i < numCmds + 1; i++){
            System.out.println("in for");
            String cmd = sc.next();
            int num;
            if (cmd.equals("undo")){
                num = Integer.parseInt(sc.next());
                allPositions[i] = allPositions[i - num];
            }else{
                num = Integer.parseInt(sc.next());
                if (num == 0 || students % num == 0){
                    allPositions[i] = allPositions[i - 1];
                }else{
                    allPositions[i] = allPositions[i - 1] + num;
                }
            }
        }
        System.out.println(allPositions[numCmds + 1] % students);
    }
}
