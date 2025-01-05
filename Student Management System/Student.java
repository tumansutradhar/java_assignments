import java.util.ArrayList;

public class Student {
    private String id;
    private String name;
    private int age;
    private ArrayList<Subject> subjects;

    public Student(String id, String name, int age, ArrayList<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.subjects = subjects;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public double calculateAverage() {
        int total = 0;
        for (Subject subject : subjects)
            total += subject.getMark();
        return total / (double) subjects.size();
    }

    public void displayStudent() {
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", Average: " + String.format("%.2f", calculateAverage()));
        System.out.println("Subjects:");
        for (Subject subject : subjects)
            subject.displaySubject();
    }
}