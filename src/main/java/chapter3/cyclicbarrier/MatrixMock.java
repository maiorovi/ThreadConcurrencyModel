package chapter3.cyclicbarrier;

import java.util.Random;

public class MatrixMock {
    private int[][] data;
    private Random random;
    private int counter;

    public MatrixMock(int size, int length, int number) {
        random = new Random();
        data = new int[size][length];
        fillInMatrix(size, length, number);
        System.out.printf("Mock: There are %d ocurrences of number in generated data.\n",counter,number);

    }

    private void fillInMatrix(int size, int length, int number) {
        //TODO: Refactor this using streams
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < length; j++) {
                data[i][j] = random.nextInt(10);
                if (data[i][j] == number) {
                    counter++;
                }
            }
        }

    }

    public int[] getRow(int index) {
        if (index >= 0 && index < data.length) {
            return data[index];
        }

        return null;
    }
}
