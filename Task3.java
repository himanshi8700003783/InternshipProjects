// Random Password generator
package in.FutureIntern;
import java.security.SecureRandom;
import java.util.Scanner;

public class Task3 {
    private static final String UPPERCASE="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE="abcdefghijklmnopqrstuvwxyz";
    private static final String NUMBER="0123456789";
    private static final String SPECIAL_CHAR="!@#$%^&*()-=[]/';.,_+?><";
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Welcome to Random Password Generator");
        System.out.print("Enter desired password length: ");
        int len= sc.nextInt();
        System.out.println("Wanna include uppercase letters?(true/false)");
        boolean uCase= sc.nextBoolean();
        System.out.println("Wanna include lowercase letters?(true/false)");
        boolean lCase= sc.nextBoolean();
        System.out.println("Wanna include numbers?(true/false)");
        boolean num= sc.nextBoolean();
        System.out.println("Wanna include special characters?(true/false)");
        boolean sChar= sc.nextBoolean();
        String password= generatePassword(len,uCase,lCase,num, sChar);
        System.out.println("Generated Password: "+password);

    }
    private static String generatePassword(int len,boolean uCase,boolean lCase,boolean num,boolean sChar){
        StringBuilder charPool= new StringBuilder();
        if (uCase){
            charPool.append(UPPERCASE);
        }
        if (lCase){
            charPool.append(LOWERCASE);
        }
        if (num){
            charPool.append(NUMBER);
        }
        if (sChar){
            charPool.append(SPECIAL_CHAR);
        }
        if (charPool.isEmpty()){throw new IllegalArgumentException("At least one char type must be selected!");}
        SecureRandom r= new SecureRandom();
        StringBuilder password= new StringBuilder(len);
        for (int i = 0; i <len ; i++) {
int index= r.nextInt(charPool.length());
password.append(charPool.charAt(index));
        }
        return password.toString();
    }
}
