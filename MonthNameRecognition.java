import java.util.Scanner;

public class MonthNameRecognition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a month number: ");

        if (scanner.hasNextInt()) {
            int month = scanner.nextInt();
            System.out.println(getMonthName(month));
        } else {
            System.out.println("Please enter the month in numbers");
        }
        scanner.close();
    }

    public static String getMonthName(int month) {
        return switch (month) {
            case 1 -> "January";
            case 2 -> "February";
            case 3 -> "March";
            case 4 -> "April";
            case 5 -> "May";
            case 6 -> "June";
            case 7 -> "July";
            case 8 -> "August";
            case 9 -> "September";
            case 10 -> "October";
            case 11 -> "November";
            case 12 -> "December";
            default -> "Invalid month";
        };
    }
}
