package Game.GUI;

import Game.Game;
import Game.Utility.Creature;
import Game.Utility.World;
import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class PlayScreen implements Screen {
    private int centerX;
    private int centerY;
    private int screenWidth;
    private int screenHeight;
    private int horizontalMarge;

    public PlayScreen() {
        screenWidth = 80;
        screenHeight = 40;
        horizontalMarge = 0;
    }


    public int getScrollX(World world) {
        return Math.max(0, Math.min(centerX - screenWidth / 2, world.width() - screenWidth));
    }

    public int getScrollY(World world) {
        return Math.max(0, Math.min(centerY - screenHeight / 2, world.height() - screenHeight));
    }

    public void setHorizontalMarge(World world) {
        if (screenWidth > world.width()) {
            this.horizontalMarge = (screenWidth - world.width()) / 2;
        }
    }

    public void displayOutput(AsciiPanel terminal, Object ... params) {
        World world = new World();

        for(Object o : params){
           if(o instanceof World){
               world = (World) o;
            }
        }

        int left = getScrollX(world);
        int top = getScrollY(world);

        setHorizontalMarge(world);

        displayTiles(terminal, left, top, world);

        Creature player = world.getPlayer();
        terminal.write(player.glyph(), player.x - left, player.y - top, player.color());
        terminal.writeCenter("-- press [escape] to lose or [enter] to win --", 38);
    }

    private void displayTiles(AsciiPanel terminal, int left, int top, World world) {
        int xMin = Math.min(screenWidth, world.width());
        int yMin = Math.min(screenHeight, world.height());

        for (int x = 0; x < xMin; x++) {
            for (int y = 0; y < yMin; y++) {
                int wx = x + left;
                int wy = y + top;

                terminal.write(world.glyph(wx, wy), x + horizontalMarge, y, world.color(wx, wy));
            }
        }
    }

    @Override
    public Screen respondToUserInput(KeyEvent key, Game game) {
        switch (key.getKeyCode()) {
            case KeyEvent.VK_ENTER:
                return new StartScreen();
            case KeyEvent.VK_LEFT:
                game.movePlayer(-1,0);
                break;
            case KeyEvent.VK_RIGHT:
                game.movePlayer(1,0);
                break;
            case KeyEvent.VK_UP:
                game.movePlayer(0,-1);
                break;
            case KeyEvent.VK_DOWN:
                game.movePlayer(0,1);
                break;


            /*case KeyEvent.VK_S:
                try {
                    new SaveSystem().saveWorld(world);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case KeyEvent.VK_L:
                try {
                    World w = new SaveSystem().loadWorld();
                    this.world = w;
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;*/

        }
        return this;

    }
}