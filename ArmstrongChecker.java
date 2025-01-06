import java.util.Scanner;

public class ArmstrongChecker {
    public boolean isArmstrong(int number) {
        int originalNumber = number;
        int result = 0;
        int digits = String.valueOf(number).length();

        while (number != 0) {
            int remainder = number % 10;
            result += Math.pow(remainder, digits);
            number /= 10;
        }

        return result == originalNumber;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArmstrongChecker checker = new ArmstrongChecker();

        System.out.println("Enter a number to check if it is an Armstrong number:");
        int userInput = scanner.nextInt();

        if (checker.isArmstrong(userInput))
            System.out.println(userInput + " is an Armstrong number.");
        else
            System.out.println(userInput + " is not an Armstrong number.");

        scanner.close();
    }
}
