package exercise;

// BEGIN
public class MaxThread extends Thread {
    private int result;
    private final int[] numbers;

    public MaxThread(int[] numbers) {
        this.numbers = numbers;
    }
    @Override
    public void run() {
        result = numbers[0];
        for (int i : numbers) {
            result = Math.max(i, result);
        }
    }
    public int getResult() {
        return result;
    }
}
// END
