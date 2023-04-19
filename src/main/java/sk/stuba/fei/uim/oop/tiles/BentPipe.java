package sk.stuba.fei.uim.oop.tiles;

import sk.stuba.fei.uim.oop.board.Direction;

import java.awt.*;

public class BentPipe extends Tile{
    public BentPipe() {
        super();
        this.playable = true;
        this.connectionPoints.add(Direction.LEFT);
        this.connectionPoints.add(Direction.UP);
        this.randomRotate();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = this.paintSetup(g);
        g2d.drawRect(0, this.getHeight() /2-this.getHeight()/6, this.getWidth()/3*2, this.getWidth() /3);
        g2d.drawRect(this.getHeight() /2-this.getHeight()/6, 0, this.getWidth()/3, this.getWidth() /3*2);
        g2d.setStroke(new BasicStroke(1));
        if(water){
            g2d.setColor(Color.BLUE);
            this.water = false;
        }
        else {
            g2d.setColor(Color.GRAY);
        }
        g2d.fillRect(0, this.getHeight() /2-this.getHeight()/6, this.getWidth()/3*2, this.getWidth() /3);
        g2d.fillRect(this.getHeight() /2-this.getHeight()/6, 0, this.getWidth()/3, this.getWidth() /3*2);
        g2d.setColor(Color.BLACK);
    }
}
