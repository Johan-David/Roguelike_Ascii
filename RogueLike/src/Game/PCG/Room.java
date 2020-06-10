package Game.PCG;

public class Room {
    private Point topLeftCorner;
    private Point downRightCorner;


    public Room(Point topLeftCorner, Point downRightCorner) {
        this.topLeftCorner = topLeftCorner;
        this.downRightCorner = downRightCorner;
    }

    public Room(int width, int height) {
        this.topLeftCorner = new Point(0,0);
        this.downRightCorner = new Point(width-1,height-1);
    }

    public Point getTopLeftCorner() {
        return topLeftCorner;
    }

    public Point getDownRightCorner() {
        return downRightCorner;
    }

    public Point topMiddleWidth(){
        int x = this.topLeftCorner.getX() + getWidth()/ 2;
        int y = this.topLeftCorner.getY();
        return new Point(x,y);
    }

    public Point downMiddleWidth(){
        int x = this.topLeftCorner.getX() + getWidth() / 2;
        int y = this.downRightCorner.getY();
        return new Point(x,y);
    }

    public Point leftMiddleHeight(){
        int x = this.topLeftCorner.getX();
        int y = this.topLeftCorner.getY() + (this.downRightCorner.getY() - this.topLeftCorner.getY() ) / 2;
        return new Point(x,y);
    }

    public Point rightMiddleHeight(){
        int x = this.downRightCorner.getX();
        int y = this.topLeftCorner.getY() + (this.downRightCorner.getY() - this.topLeftCorner.getY() ) / 2;
        return new Point(x,y);
    }

    public Point topRightCorner(){
        int x = this.topLeftCorner.getX() + this.downRightCorner.getX();
        int y = this.topLeftCorner.getY();
        return new Point(x,y);
    }

    public Point downLeftCorner(){
        int x = this.topLeftCorner.getX();
        int y = this.topLeftCorner.getY() + this.downRightCorner.getY();
        return new Point(x,y);
    }

    public Point middle(){
        int x = this.topLeftCorner.getX() + (this.downRightCorner.getX() - this.topLeftCorner.getX() )/ 2;
        int y = this.topLeftCorner.getY() + (this.downRightCorner.getY() - this.topLeftCorner.getY() )/ 2;
        return new Point(x,y);
    }

    public boolean sliceRoom(Room[] result){
        if(getHeight() < getWidth() ){
            /*vertical slice*/
            return sliceVerticaly(result);
        }else{
            /*horizontal slice*/
            return sliceHorizontaly(result);

        }
    }

    int randomWithRange(int min, int max){   //defining method for a random number generator
        int range = (max - min);
        return (int)(Math.random() * range) + min;
    }

    private boolean sliceVerticaly(Room[] result){
        if(getWidth() <= 20)
            return false;

        Room firstRoom;
        Room secondRoom;

        int min = topLeftCorner.getX() + 10;
        int max = downRightCorner.getX() - 10;

        int cutX = randomWithRange(min, max);
        Point firstRoomDownCorner = new Point(cutX,downRightCorner.getY());
        Point secondRoomTopCorner = new Point(cutX+1,topLeftCorner.getY());
        firstRoom = new Room(topLeftCorner, firstRoomDownCorner);
        secondRoom = new Room(secondRoomTopCorner, downRightCorner);
        result[0] = firstRoom;
        result[1] = secondRoom;
        return true;
    }

    private boolean sliceHorizontaly(Room[] result){
        if(getHeight() <= 20)
            return false;
        Room firstRoom;
        Room secondRoom;

        int min = topLeftCorner.getY() + 10;
        int max = downRightCorner.getY() - 10;

        int cutY = randomWithRange(min, max);
        Point firstRoomDownCorner = new Point(downRightCorner.getX(),cutY);
        Point secondRoomTopCorner = new Point(topLeftCorner.getX(),cutY+1);
        firstRoom = new Room(topLeftCorner, firstRoomDownCorner);
        secondRoom = new Room(secondRoomTopCorner, downRightCorner);
        result[0] = firstRoom;
        result[1] = secondRoom;
        return true;
    }

    public int getWidth(){
        return downRightCorner.getX() - topLeftCorner.getX() + 1;
    }

    public int getHeight(){
        return downRightCorner.getY() - topLeftCorner.getY() + 1;
    }

    public int roomArea(){
        return getWidth() * getHeight();
    }

    public Room copyRoom(){

        return new Room(topLeftCorner.copyPoint(), downRightCorner.copyPoint());
    }
    @Override
    public String toString() {
        return "Room{" +
                "topLeftCorner=" + topLeftCorner +
                ", downRightCorner=" + downRightCorner +
                '}';
    }
}
