package PCG;

import Utility.Tile;
import Utility.WorldBuilder;

import java.util.HashSet;

public abstract class PCGalgorithm {
    protected int width;
    protected int height;
    protected Tile[][] tiles;
    protected HashSet<Room> listOfRooms;

    protected PCGalgorithm(int width, int height){
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];
        this.listOfRooms = new HashSet<Room>();
    }
    abstract WorldBuilder generateLevel();
}
