package GUI;

import asciiPanel.AsciiPanel;

import java.awt.*;
import java.awt.event.KeyEvent;

public class StartScreen implements Screen {
    private Boolean[] selection;
    private int indice;
    private int size;

    public StartScreen(){
        this.size = 3;
        this.indice = 0;
        this.selection = new Boolean[this.size];
        for(int i = 0; i < this.size; i++ ){
            this.selection[i] = Boolean.FALSE;
        }
        this.selection[0] = Boolean.TRUE;
    }

    public void displayOutput(AsciiPanel terminal) {
        if(selection[0] == true){
            terminal.writeCenter("-- Play --", 15, Color.white, Color.red);
        }else{
            terminal.writeCenter("-- Play --", 15);
        }
        if(selection[1] == true){
            terminal.writeCenter("-- Help --", 20, Color.white, Color.red);
        }else{
            terminal.writeCenter("-- Help --", 20);

        }
        if(selection[2] == true){
            terminal.writeCenter("-- Credits --", 25, Color.white, Color.red);
        }else{
            terminal.writeCenter("-- Credits --", 25);

        }

    }

    private void moveUp(){
        selection[indice] = Boolean.FALSE;
        if(indice <= 0){
            indice = size -1;
        }else{
            indice--;
        }
        selection[indice] = Boolean.TRUE;
    }

    private void moveDown(){
        selection[indice] = Boolean.FALSE;
        if(indice >= size -1){
            indice = 0;
        }else{
            indice ++;
        }
        selection[indice] = Boolean.TRUE;
    }

    public Screen respondToUserInput(KeyEvent key) {
        switch (key.getKeyCode()){
            case KeyEvent.VK_ENTER: return new PlayScreen();
            case KeyEvent.VK_UP: moveUp(); break;
            case KeyEvent.VK_DOWN: moveDown(); break;

        }
        return this;
    }
}