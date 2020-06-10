package Game.Infra;

import Game.Utility.World;

import static Game.Infra.TileDAO.FLOORDAO;

public class WorldDAO {
    private int width;
    private int height;
    private TileDAO[][] tiles;

    public WorldDAO(World world){
        int width = world.width();
        int height = world.height();
        this.width = width;
        this.height = height;
        TileDAO[][] tiles = new TileDAO[width][height];
        for(int x = 0; x < width; x++){
            for(int y = 0; y < height; y++){
                tiles[x][y] = world.tile(x,y).convertTileToDAO();
                System.out.println(FLOORDAO.color());
            }
        }
        this.tiles = tiles;
    }

    public int width() { return width; }

    public int height() { return height; }

    public TileDAO tile(int x, int y){
        return tiles[x][y];
    }

    public int glyph(int x, int y){
        return tile(x, y).glyph();
    }

    public int color(int x, int y){
        return tile(x, y).color();
    }
}
