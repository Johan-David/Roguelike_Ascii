package Game.PCG;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int distance(Point other){
        int x = (int) Math.pow(this.x - other.x, 2);
        int y = (int) Math.pow(this.y - other.y,2);

        return (int) Math.sqrt(x + y);
    }

    public Point copyPoint(){
        return new Point(this.getX(), this.getY());
    }
    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                "}\n";
    }

}
