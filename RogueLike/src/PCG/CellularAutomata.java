package PCG;

import Utility.Tile;
import Utility.WorldBuilder;

import java.util.HashSet;

public class CellularAutomata extends PCGalgorithm{

        private int times;
        public CellularAutomata(int width, int height, int times){
            super(width, height);
            this.times = times;
        }

        public WorldBuilder generateLevel(){
            randomizeTiles();
            smooth(times);
            return new WorldBuilder(width, height, tiles, listOfRooms);
        }

    private void randomizeTiles() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                tiles[x][y] = Math.random() < 0.5 ? Tile.FLOOR : Tile.WALL;
            }
        }

    }

    private void smooth(int times) {
        Tile[][] tiles2 = new Tile[width][height];
        for (int time = 0; time < times; time++) {

            for (int x = 0; x < width; x++) {
                for (int y = 0; y < height; y++) {
                    int floors = 0;
                    int rocks = 0;

                    for (int ox = -1; ox < 2; ox++) {
                        for (int oy = -1; oy < 2; oy++) {
                            if (x + ox < 0 || x + ox >= width || y + oy < 0
                                    || y + oy >= height)
                                continue;

                            if (tiles[x + ox][y + oy] == Tile.FLOOR)
                                floors++;
                            else
                                rocks++;
                        }
                    }
                    tiles2[x][y] = floors >= rocks ? Tile.FLOOR : Tile.WALL;
                }
            }
            tiles = tiles2;
        }
    }

}
