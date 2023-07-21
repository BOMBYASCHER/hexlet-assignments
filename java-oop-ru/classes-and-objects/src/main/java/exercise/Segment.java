package exercise;

// BEGIN
class Segment {
    private final Point x;
    private final Point y;
    Segment(Point x, Point y) {
        this.x = x;
        this.y = y;
    }
    public Point getBeginPoint() {
        return this.x;
    }
    public Point getEndPoint() {
        return this.y;
    }
    public Point getMidPoint() {
        int newX = (this.x.getX() + this.y.getX()) / 2;
        int newY = (this.x.getY() + this.y.getY()) / 2;
        return new Point(newX, newY);
    }
}
// END
