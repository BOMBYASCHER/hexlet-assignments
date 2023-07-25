package exercise;

// BEGIN
class NegativeRadiusException extends Exception {
    public String error;
    NegativeRadiusException(String error) {
        this.error = error;
    }
}
// END
