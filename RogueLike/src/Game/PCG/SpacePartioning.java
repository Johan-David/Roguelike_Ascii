package Game.PCG;

import Game.Utility.Tile;
import Game.Utility.WorldBuilder;

import java.util.*;

public class SpacePartioning extends PCGalgorithm{

    public SpacePartioning(int width, int height){
        super(width, height);
    }

    public WorldBuilder generateLevel() {
        partioning();
        corridorAllRooms();
        return new WorldBuilder(width, height, tiles, listOfRooms);
    }

    private void partioning(){
        /* world full of wall */
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = Tile.WALL;
            }
        }

        Tree tree = new Tree();
        tree.generateTree(new Room(width, height));
        HashSet<InternNode> set = tree.treeToListOfLeaf();
        int n = set.size();
        List<InternNode> list = new ArrayList<InternNode>(n);
        for (InternNode in : set)
            list.add(in);
        Collections.shuffle(list);

        int count = n-1;
        while (!list.isEmpty() && count >= 0) {

            InternNode in = list.get(count);
            Room r;
            if(Math.random() < 0.5){
                r = in.getLeftNode().getValue();
            } else{
                r = in.getRightNode().getValue();
            }
            roomToTiles(r);
            this.listOfRooms.add(r);

            count --;
        }

    }


    private void hCorridor(Point m1, Point m2){
        int y = m1.getY();
        if(m1.getX() < m2.getX()){
            for(int x = m1.getX(); x <= m2.getX(); x++){
                this.tiles[x][y] = Tile.FLOOR;
            }
        }else{
            for(int x = m1.getX(); x >= m2.getX(); x--){
                this.tiles[x][y] = Tile.FLOOR;
            }
        }
    }

    private void vCorridor(Point m1, Point m2){
        int x = m2.getX();
        if(m1.getY() < m2.getY()){
            for(int y = m1.getY(); y <= m2.getY(); y++){
                this.tiles[x][y] = Tile.FLOOR;
            }
        }else{
            for(int y = m1.getY(); y >= m2.getY(); y--){
                this.tiles[x][y] = Tile.FLOOR;
            }
        }
    }

    private void corridorBetweenTwoRooms(Room r1, Room r2){
        Point m1 = r1.middle();
        Point m2 = r2.middle();
        hCorridor(m1, m2);
        vCorridor(m1, m2);
    }

    private void corridorAllRooms(){
        if(this.listOfRooms.size() >= 2){
            Iterator<Room> i = this.listOfRooms.iterator();
            Room r1 = i.next();
            Room r2;
            while(i.hasNext()){
                r2 = i.next();
                corridorBetweenTwoRooms(r1, r2);
                r1 = r2;

            }

        }
    }

    private void roomToTiles(Room room){

        int startX = room.getTopLeftCorner().getX();
        int startY = room.getTopLeftCorner().getY();
        int roomWidth = room.getWidth();
        int roomHeight = room.getHeight();

        if(roomWidth <= width && roomHeight <= height){
            for(int x = startX; x < startX + roomWidth; x++){
                for(int y = startY; y < startY + roomHeight; y++){
                    if(x == startX || y == startY || x == startX + roomWidth -1 || y == startY + roomHeight -1){
                        this.tiles[x][y] = Tile.WALL;
                    }else{
                        this.tiles[x][y] = Tile.FLOOR;
                    }
                }
            }
        }

    }
}
