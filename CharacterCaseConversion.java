import java.util.Scanner;

public class CharacterCaseConversion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char character = scanner.next().charAt(0);
        System.out.println(convertCase(character));
    }

    public static String convertCase(char character) {
        if (Character.isLowerCase(character))
            return character + "->" + Character.toUpperCase(character);
        else if (Character.isUpperCase(character))
            return character + "->" + Character.toLowerCase(character);
        else
            return "Invalid Input";
    }
}
