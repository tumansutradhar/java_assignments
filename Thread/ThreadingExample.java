package Thread;

public class ThreadingExample {
    public static void main(String[] args) {
        ThreadTask T1 = new ThreadTask("T");
        T1.start();
        ThreadTask T2 = new ThreadTask("Tuman");
        T2.start();
    }
}
