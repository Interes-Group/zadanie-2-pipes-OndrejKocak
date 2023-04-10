package sk.stuba.fei.uim.oop.tiles;

import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Tile extends JPanel {
    @Setter
    protected boolean highlight;
    @Setter
    protected boolean water;
    protected int angle;
    private Random random;

    public Tile() {
        this.random = new Random();
        this.angle = 90*random.nextInt(4);
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
    }

    public void rotate(){
        this.angle += 90;
        if(this.angle == 360){
            this.angle = 0;
        }
    }
}
