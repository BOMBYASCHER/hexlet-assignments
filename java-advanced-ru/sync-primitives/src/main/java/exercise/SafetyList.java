package exercise;

class SafetyList {
    // BEGIN
    private int[] array = new int[0];

    public synchronized void add(int number) {
        int length = array.length;
        int[] extended = new int[length + 1];
        System.arraycopy(array, 0, extended, 0, length);
        extended[length] = number;
        array = extended;
    }

    public int get(int index) {
        return array[index];
    }

    public int getSize() {
        return array.length;
    }
    // END
}
