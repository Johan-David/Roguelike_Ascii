package Game.Infra;

import asciiPanel.AsciiPanel;

public enum  TileDAO {
    FLOORDAO(250, AsciiPanel.yellow.getRGB()),
    WALLDAO(177, AsciiPanel.yellow.getRGB()),
    ITEMDAO(254, AsciiPanel.red.getRGB());
    private int glyph;
    public int glyph() { return glyph; }

    private int color;
    public int color() { return color; }

    TileDAO(int glyph, int color){
        this.glyph = glyph;
        this.color = color;
    }

    public String convertTileToString(){
        if(this == FLOORDAO){
            return "FLOORDAO";
        }else if(this == WALLDAO){
            return "WALLDAO";
        } else if(this == ITEMDAO) {
            return "ITEMDAO";
        }
        return "FLOORDAO";
    }



}
