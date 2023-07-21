package exercise;

// BEGIN
class Flat implements Home {
    private final double area;
    private final double balconyArea;
    private final int floor;
    Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }
    public double getArea() {
        return (this.area + this.balconyArea);
    }


    public int compareTo(Home another) {
        return Double.compare((this.area + this.balconyArea), another.getArea());
    }

    @Override
    public String toString() {
        return "Квартира площадью "
                + (this.area + this.balconyArea)
                + " метров на "
                + this.floor
                + " этаже";
    }
}
// END
