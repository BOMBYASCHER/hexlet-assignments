package exercise;

// BEGIN
public class MinThread extends Thread {
    private int result;
    private final int[] numbers;

    public MinThread(int[] numbers) {
        this.numbers = numbers;
    }
    @Override
    public void run() {
        result = numbers[0];
        for (int i : numbers) {
            result = Math.min(i, result);
        }
    }
    public int getResult() {
        return result;
    }
}
// END
