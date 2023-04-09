package sk.stuba.fei.uim.oop.tiles;

import lombok.Setter;

import javax.swing.*;
import java.awt.*;

public class Tile extends JPanel {
    @Setter
    protected boolean highlight;

    public Tile() {
        this.setBackground(Color.WHITE);
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY));
    }
}
