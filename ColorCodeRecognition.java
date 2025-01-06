import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ColorCodeRecognition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a color code (R, B, G, O, Y, W): ");
        char colorCode = scanner.next().charAt(0);
        System.out.println(getColorName(colorCode));
        scanner.close();
    }

    public static String getColorName(char colorCode) {
        Map<Character, String> colorDict = new HashMap<>();
        colorDict.put('R', "Red");
        colorDict.put('B', "Blue");
        colorDict.put('G', "Green");
        colorDict.put('O', "Orange");
        colorDict.put('Y', "Yellow");
        colorDict.put('W', "White");

        return colorDict.getOrDefault(Character.toUpperCase(colorCode), "Invalid Code");
    }
}
