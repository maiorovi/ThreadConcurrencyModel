package chapter3.cyclicbarrier;

public class Results {
    private int[] data;

    public Results(int size) {
        data = new int[size];
    }

    public void setData(int index, int value) {
        data[index] = value;
    }

    public int[] getData() {
        return data;
    }


}
