package in.FutureIntern;

import java.util.Scanner;

public class Task1a {
    public static void main(String[] args) {
//        Task 1a Build a calculator app that can perform basic arithmetic operations such as add,sub,mul,div
        System.out.println("Welcome to calculator Program!");
        System.out.print("Enter the numbers : ");
        Scanner sc= new Scanner(System.in);
        double a= sc.nextDouble(),b= sc.nextDouble();
        System.out.print("Enter your choice(1 for add,2 for sub,3 for mul,4 for div): ");
        int c= sc.nextInt();
        double r;
        switch (c){
            case 1 -> {
                r=a+b;
                System.out.println("Result is : "+r);
            }
            case 2->{r=a-b; System.out.println("Result is : "+r);}
            case 3->{r=a*b; System.out.println("Result is : "+r);}
            case 4->{r= (double) a /b; System.out.println("Result is : "+r);}
            default -> System.out.println("Wrong choice");
        }

    }
}
