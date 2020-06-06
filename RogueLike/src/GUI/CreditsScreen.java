package GUI;

import asciiPanel.AsciiPanel;

import java.awt.event.KeyEvent;

public class CreditsScreen  implements Screen {

    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter("-- Credits Menu --", 15);
        terminal.writeCenter("-- Press [escape] to return to start screen --", 25);
    }



    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()){
            case KeyEvent.VK_ESCAPE: return new StartScreen();
        }
        return this;
    }
}
