import java.util.Scanner;

class Matrix {
    private int rows, cols;
    private double[][] data;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        data = new double[rows][cols];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public double getElement(int i, int j) {
        return data[i][j];
    }

    public void setElement(int i, int j, double value) {
        data[i][j] = value;
    }

    public void readMatrix(Scanner sc) {
        System.out.println("Enter elements of the matrix (" + rows + "x" + cols + "):");
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                setElement(i, j, sc.nextDouble());
    }

    public void displayMatrix() {
        System.out.println("Matrix:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++)
                System.out.print(getElement(i, j) + " ");
            System.out.println();
        }
    }

    public Matrix add(Matrix m) {
        if (rows != m.getRows() || cols != m.getCols()) {
            System.out.println("Matrices must have the same dimensions for addition.");
            return null;
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result.setElement(i, j, getElement(i, j) + m.getElement(i, j));
        return result;
    }

    public Matrix subtract(Matrix m) {
        if (rows != m.getRows() || cols != m.getCols()) {
            System.out.println("Matrices must have the same dimensions for subtraction.");
            return null;
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result.setElement(i, j, getElement(i, j) - m.getElement(i, j));
        return result;
    }

    public Matrix multiply(Matrix m) {
        if (cols != m.getRows()) {
            System.out.println("Matrix multiplication not possible.");
            return null;
        }
        Matrix result = new Matrix(rows, m.getCols());
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < m.getCols(); j++) {
                double sum = 0;
                for (int k = 0; k < cols; k++)
                    sum += getElement(i, k) * m.getElement(k, j);
                result.setElement(i, j, sum);
            }
        return result;
    }

    public Matrix transpose() {
        Matrix result = new Matrix(cols, rows);
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                result.setElement(j, i, getElement(i, j));
        return result;
    }
}

public class MatrixOperations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter dimensions of the first matrix:");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();
        Matrix m1 = new Matrix(r1, c1);
        m1.readMatrix(sc);

        System.out.println("Enter dimensions of the second matrix:");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();
        Matrix m2 = new Matrix(r2, c2);
        m2.readMatrix(sc);

        int choice;
        do {
            System.out.println("\n--- Matrix Operations Menu ---");
            System.out.println("1. Add Matrices");
            System.out.println("2. Subtract Matrices");
            System.out.println("3. Multiply Matrices");
            System.out.println("4. Transpose First Matrix");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> {
                    Matrix addResult = m1.add(m2);
                    if (addResult != null)
                        addResult.displayMatrix();
                }
                case 2 -> {
                    Matrix subResult = m1.subtract(m2);
                    if (subResult != null)
                        subResult.displayMatrix();
                }
                case 3 -> {
                    Matrix mulResult = m1.multiply(m2);
                    if (mulResult != null)
                        mulResult.displayMatrix();
                }
                case 4 -> {
                    Matrix transResult = m1.transpose();
                    transResult.displayMatrix();
                }
                case 5 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
