package Game.Utility;


import java.awt.*;

public class Creature {

    public int x;
    public int y;
    private CreatureAi ai;
    public void setCreatureAi(CreatureAi ai) { this.ai = ai; }

    private char glyph;
    public char glyph() { return glyph; }

    private Color color;
    public Color color() { return color; }

    public Creature(char glyph, Color color){
        this.glyph = glyph;
        this.color = color;
    }

    public void moveBy(int mx, int my, Tile tile){
        ai.onEnter(x+mx, y+my, tile);
    }
}