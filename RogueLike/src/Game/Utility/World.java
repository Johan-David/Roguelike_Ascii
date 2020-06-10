package Game.Utility;


import java.awt.*;
import java.util.ArrayList;

public class World {
    private int width;
    private int height;
    private Tile[][] tiles;
    private ArrayList<Creature> creatures;

    public World(){
        this.tiles = new Tile[0][0];
        this.creatures = new ArrayList<Creature>();
        this.width = 0;
        this.height = 0;
    }

    public World(Tile[][] tiles, ArrayList<Creature> creatures){
        this.tiles = tiles;
        this.creatures = creatures;
        this.width = tiles.length;
        this.height = tiles[0].length;
    }

    public int width() { return width; }

    public int height() { return height; }

    public Tile tile(int x, int y){
        return tiles[x][y];
    }

    public char glyph(int x, int y){
        return tile(x, y).glyph();
    }

    public Color color(int x, int y){
        return tile(x, y).color();
    }

    private void addAtEmptyLocation(Creature creature){
        int x;
        int y;

        do {
            x = (int)(Math.random() * width);
            y = (int)(Math.random() * height);
        }
        while (!tile(x,y).isGround());

        creature.x = x;
        creature.y = y;
    }

    public void spawnAllCreatures(){
        for (Creature c : this.creatures) {
            addAtEmptyLocation(c);
        }
    }

    public Creature getPlayer(){
        return this.creatures.get(0);
    }

    public void movePlayer(int mx, int my){
        Creature player = this.getPlayer();
        int x = player.x;
        int y = player.y;
        player.moveBy(mx,my, this.tile(x,y));
    }
}