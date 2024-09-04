package in.FutureIntern;
import java.util.Random;
import java.util.Scanner;
public class Task2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Welcome to Rock Paper Scissors Game!");
        String []choice={"r","p","s"};
        String cm= choice[new Random().nextInt(3)];

        while (true){
            System.out.print("Enter your move : ");
            String pm=sc.next();
            if (pm.equals("r")||pm.equals("p")||pm.equals("s")){
                if ((pm.equals("r")&&cm.equals("s"))||(pm.equals("s")&&cm.equals("p"))||(pm.equals("p")&&cm.equals("r"))){
                    System.out.println("You win!");
                    System.out.println("Computers Move: "+cm);
                } else if (pm.equals(cm)) {
                    System.out.println("Its a tie!");
                    System.out.println("Computers Move: "+cm);
                } else{
                    System.out.println("You Lose!");
                    System.out.println("Computers Move: "+cm);
                }
            } else if (pm.equals("exit")) {
                System.out.println("Hope you enjoyed playing");break;
            } else {System.out.println("Enter valid move! ");}


        }
    }
}