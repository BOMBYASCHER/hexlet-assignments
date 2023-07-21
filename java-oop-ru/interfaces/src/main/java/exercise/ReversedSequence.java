package exercise;

// BEGIN
class ReversedSequence implements CharSequence {
    private final String string;
    ReversedSequence(String string) {
        this.string = new StringBuilder(string).reverse().toString();
    }
    @Override
    public String toString() {
        return this.string;
    }
    public int length() {
        return this.string.length();
    }

    public char charAt(int index) {
        return this.string.charAt(index);
    }

    public CharSequence subSequence(int start, int end) {
        return this.string.subSequence(start, end);
    }
}
// END
