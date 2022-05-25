package main;

import javax.swing.JPanel;

import gen.GameButton;
import gen.Score;

public abstract class OsirysGame extends JPanel{
    protected String code;
    protected Score score;

    public String getCode(){
        return this.code;
    }

    protected void setCode(String code){
        this.code = code;
    }

    public Score getScore(){
        return this.score;
    }

    protected void autoSetIcons(GameButton button, String name){
        button.setIcons(
            getCode()+"/src/normal/"+name+".png",
            getCode()+"/src/hilite/h_"+name+".png",
            name.toUpperCase()
        );
    }

    abstract protected void loadGame();
}