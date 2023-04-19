package sk.stuba.fei.uim.oop.tiles;

import sk.stuba.fei.uim.oop.board.Direction;

import java.awt.*;

public class StraightPipe extends Tile{
    public StraightPipe() {
        super();
        this.playable = true;
        this.connectionPoints.add(Direction.LEFT);
        this.connectionPoints.add(Direction.RIGHT);
        this.randomRotate();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = paintSetup(g);
        g2d.drawRect(0, this.getHeight() /2-this.getHeight()/6, this.getWidth(), this.getWidth() /3);
        g2d.setStroke(new BasicStroke(1));
        if(water){
            g2d.setColor(Color.BLUE);
            this.water = false;
        }
        else {
            g2d.setColor(Color.GRAY);
        }
        g2d.fillRect(0, this.getHeight() /2-this.getHeight()/6, this.getWidth(), this.getWidth() /3);
        g2d.setColor(Color.BLACK);
    }
}
