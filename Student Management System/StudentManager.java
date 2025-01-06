import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Scanner scanner) {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Student Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Subject> subjects = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            System.out.print("Enter Subject " + i + " Name: ");
            String subjectName = scanner.nextLine();
            int mark;
            while (true) {
                System.out.print("Enter marks for " + subjectName + ": ");
                mark = scanner.nextInt();
                scanner.nextLine();
                if (mark >= 0 && mark <= 100)
                    break;
                else
                    System.out.println("Invalid mark! Please enter a value between 0 and 100.");
            }
            subjects.add(new Subject(subjectName, mark));
        }

        students.add(new Student(id, name, age, subjects));
        System.out.println("Student added successfully!");
    }

    public void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No students to display.");
            return;
        }

        System.out.println("List of Students:");
        for (Student student : students)
            student.displayStudent();
    }

    public void searchStudentById(Scanner scanner) {
        System.out.print("Enter Student ID to search: ");
        String id = scanner.nextLine();
        for (Student student : students) {
            if (student.getId().equals(id)) {
                System.out.println("Student Found:");
                student.displayStudent();
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }

    public void deleteStudent(Scanner scanner) {
        System.out.print("Enter Student ID to delete: ");
        String id = scanner.nextLine();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.remove(i);
                System.out.println("Student removed successfully!");
                return;
            }
        }
        System.out.println("Student with ID " + id + " not found.");
    }
}
