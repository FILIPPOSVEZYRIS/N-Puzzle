import java.util.*;
public class Main{
    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Unsolved Array(put 0 in the empty spot):  ");
        int[] unsolved = new int[9];
        
        for(int i=0;i<9;i++){
            unsolved[i] = sc.nextInt();
        }

        System.out.println("using UCS: ");
        PuzzleSolver.solve(unsolved, false);

        System.out.println("using A*: ");
        PuzzleSolver.solve(unsolved, true);
    }

    
}