package Game.Utility;

import Game.Infra.TileDAO;
import asciiPanel.AsciiPanel;

import java.awt.*;

import static Game.Infra.TileDAO.*;

public enum Tile {
    FLOOR((char)250, AsciiPanel.yellow),
    WALL((char)177, AsciiPanel.yellow),
    ITEM((char)254, AsciiPanel.red);
    private char glyph;
    public char glyph() { return glyph; }

    private Color color;
    public Color color() { return color; }

    Tile(char glyph, Color color){
        this.glyph = glyph;
        this.color = color;
    }

    public Boolean isGround(){
        return this != WALL;
    }

    public TileDAO convertTileToDAO(){
        if(this == FLOOR){
            return FLOORDAO;
        }else if(this == WALL){
            return WALLDAO;
        } else if(this == ITEM) {
            return ITEMDAO;
        }
        return FLOORDAO;
    }

    public Tile convertStringToTile(String tileName){
        if(tileName == "FLOORDAO"){
            return FLOOR;
        }else if(tileName == "WALLDAO"){
            return WALL;
        } else if(tileName == "ITEMDAO") {
            return ITEM;
        }
        return FLOOR;
    }


}