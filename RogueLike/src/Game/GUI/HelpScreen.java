package Game.GUI;

import Game.Game;
import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class HelpScreen implements Screen {

    public void displayOutput(AsciiPanel terminal, Object ... params) {
        terminal.writeCenter("-- Help Menu --", 15);
        terminal.writeCenter("Wesh je compran comman on jou :'(", 20);
        terminal.writeCenter("-- Press [escape] to return to start screen --", 25);
    }



    public Screen respondToUserInput(KeyEvent key, Game game) {
        switch (key.getKeyCode()){
            case KeyEvent.VK_ESCAPE: return new StartScreen();
        }
        return this;
    }

}
