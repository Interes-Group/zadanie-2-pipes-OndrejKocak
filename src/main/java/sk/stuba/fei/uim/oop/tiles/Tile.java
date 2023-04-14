package sk.stuba.fei.uim.oop.tiles;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.board.Direction;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tile extends JPanel {
    @Setter
    protected boolean highlight;
    @Setter
    protected boolean water;
    protected int angle;
    @Getter
    protected List<Direction> connectionPoints;
    private Random random;

    public Tile() {
        this.connectionPoints = new ArrayList<>();
        this.random = new Random();
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
    }

    public void rotate(){
        this.angle += 90;
        if(this.angle == 360){
            this.angle = 0;
        }
        this.rotateConnectionPoints();
    }
    private void rotateConnectionPoints(){
        List<Direction> rotated = new ArrayList<>();
        for(Direction connectionPoint : this.connectionPoints){
            switch (connectionPoint){
                case UP:
                    rotated.add(Direction.RIGHT);
                    break;
                case RIGHT:
                    rotated.add(Direction.DOWN);
                    break;
                case DOWN:
                    rotated.add(Direction.LEFT);
                    break;
                case LEFT:
                    rotated.add(Direction.UP);
                    break;
            }
        }
        this.connectionPoints.clear();
        this.connectionPoints.addAll(rotated);
    }
    protected void randomRotate(){
        for(int i = 0; i < this.random.nextInt(4);i++){
            this.rotate();
        }
    }
}
