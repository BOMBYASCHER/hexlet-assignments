package exercise;

// BEGIN
class Cottage implements Home {
    private final double area;
    private final int floorCount;
    Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }
    public double getArea() {
        return this.area;
    }
    @Override
    public String toString() {
        return this.floorCount
                + " этажный коттедж площадью "
                + this.area
                + " метров";
    }

    public int compareTo(Home another) {
        return Double.compare(this.area, another.getArea());
    }
}
// END
