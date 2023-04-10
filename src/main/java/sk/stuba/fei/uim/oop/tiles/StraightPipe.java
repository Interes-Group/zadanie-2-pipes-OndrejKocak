package sk.stuba.fei.uim.oop.tiles;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class StraightPipe extends Tile{

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g.create();
        g2d.rotate(Math.toRadians(this.angle), (double) this.getWidth() /2, (double) this.getHeight() /2);

        g2d.setColor(Color.BLACK);
        if(this.highlight){
            g2d.setColor(Color.GREEN);
            this.highlight = false;
        }
        g2d.setStroke(new BasicStroke(4));
        g2d.drawRect(0, (int)this.getHeight()/2-this.getHeight()/6, this.getWidth(), (int)this.getWidth()/3);
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.GRAY);
        g2d.fillRect(0, (int)this.getHeight()/2-this.getHeight()/6, this.getWidth(), (int)this.getWidth()/3);
        g2d.setColor(Color.BLACK);
        g2d.dispose();
    }
}
