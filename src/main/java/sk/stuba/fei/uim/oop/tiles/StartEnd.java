package sk.stuba.fei.uim.oop.tiles;

import java.awt.*;

public class StartEnd extends Tile{

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g.create();
        g2d.rotate(Math.toRadians(90), (double) this.getWidth() /2, (double) this.getHeight() /2);

        g2d.setColor(Color.BLACK);
        if(this.highlight){
            g2d.setColor(Color.GREEN);
            this.highlight =false;
        }
        g2d.setStroke(new BasicStroke(4));
        g2d.drawRect(0, (int)this.getHeight()/2-this.getHeight()/6, this.getWidth()/3*2, (int)this.getWidth()/3);
        g2d.drawOval((int) (this.getWidth()/2 - this.getWidth() * 0.35), (int) (this.getHeight()/2 - this.getHeight() * 0.35), (int) (this.getWidth() * 0.7), (int) (this.getHeight() * 0.7));
        g2d.setStroke(new BasicStroke(1));
        g2d.setColor(Color.GRAY);
        g2d.fillRect(0, (int)this.getHeight()/2-this.getHeight()/6, this.getWidth()/3*2, (int)this.getWidth()/3);
        g2d.fillOval((int) (this.getWidth()/2 - this.getWidth() * 0.35), (int) (this.getHeight()/2 - this.getHeight() * 0.35), (int) (this.getWidth() * 0.7), (int) (this.getHeight() * 0.7));
        g2d.setColor(Color.BLACK);
        g2d.dispose();
    }
}
