package GUI;

import asciiPanel.AsciiPanel;

import java.awt.*;
import java.awt.event.KeyEvent;

public class HelpScreen implements Screen {

    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter("-- Help Menu --", 15);
        terminal.writeCenter("Wesh je compran comman on jou :'(", 20);
        terminal.writeCenter("-- Press [escape] to return to start screen --", 25);
    }



    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()){
            case KeyEvent.VK_ESCAPE: return new StartScreen();
        }
        return this;
    }

}
