package Utility;

import PCG.*;

import java.util.*;

public class WorldBuilder {
    private int width;
    private int height;
    private Tile[][] tiles;
    private HashSet<Room> listOfRooms;

    public WorldBuilder(int width, int height) {
        this.width = width;
        this.height = height;
        this.tiles = new Tile[width][height];
        this.listOfRooms = new HashSet<Room>();
        //System.out.println("w = " + this.width + "h = " + this.height);
    }

    public WorldBuilder(int width, int height, Tile[][] tiles, HashSet<Room> listOfRooms) {
        this.width = width;
        this.height = height;
        this.tiles = tiles;
        this.listOfRooms = listOfRooms;
        System.out.println("w = " + this.width + "h = " + this.height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    public HashSet<Room> getListOfRooms() {
        return listOfRooms;
    }

    public World build() {
        return new World(tiles);
    }

    public WorldBuilder makeCaves() {
        //return new CellularAutomata(width, height, 10).generateLevel();
        return new SpacePartioning(width, height).generateLevel();
    }
}