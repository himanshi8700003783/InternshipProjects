package in.FutureIntern;
import java.util.Scanner;

public class Task1b {
    public static void guessNumber(int x){

    }
//    Number Guessing game
public static void main(String[] args) {
    System.out.println("Welcome to Number Guessing Game!");
    Scanner sc= new Scanner(System.in);
    int k= 1+ (int)(100* Math.random());// random num
    System.out.println("Guess a number between 1 to 100(Note- u have 7 chances ): ");
    int i;
    for ( i = 0; i <7 ; i++) {
        int s= sc.nextInt();
        if(s==k) {System.out.println("Congrats! You guessed right");break;}
        else if (s>k && i!=6) {
            System.out.println("Guess a smaller number!");

        }
        else if(s<k && i!=6) {System.out.println("Guess a bigger number!");}

    }
    if(i==7) System.out.println("Your 7 trials are over the number is : "+k);
}
}
