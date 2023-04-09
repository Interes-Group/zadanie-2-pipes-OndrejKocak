package sk.stuba.fei.uim.oop.gui;

import sk.stuba.fei.uim.oop.controls.GameLogic;

import javax.swing.*;
import java.awt.*;

public class Game {
    public Game() {
        JFrame frame = new JFrame("Water Pipes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 970);
        frame.getContentPane().setBackground(Color.GRAY);
        frame.setResizable(false);
        frame.setFocusable(true);


        GameLogic gameLogic = new GameLogic(frame);
        frame.addKeyListener(gameLogic);


        JPanel sideMenu = new JPanel();
        sideMenu.setBackground(Color.WHITE);

        JButton buttonRestart = new JButton("Restart");
        buttonRestart.addActionListener(gameLogic);
        buttonRestart.setFocusable(false);

        JButton buttonCheckCorrectness = new JButton("Check Correctness");
        buttonCheckCorrectness.addActionListener(gameLogic);
        buttonCheckCorrectness.setFocusable(false);

        JSlider slider = new JSlider(JSlider.HORIZONTAL, 8, 12, 8);
        slider.setBackground(Color.WHITE);
        slider.setMinorTickSpacing(2);
        slider.setMajorTickSpacing(2);
        slider.setSnapToTicks(true);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.addChangeListener(gameLogic);

        sideMenu.setLayout(new GridLayout(3, 2));
        sideMenu.add(buttonRestart);
        sideMenu.add(buttonCheckCorrectness);
        sideMenu.add(gameLogic.getCurrentBoardSizeLabel());
        sideMenu.add(slider);
        sideMenu.add(gameLogic.getLevelLabel());
        frame.add(sideMenu, BorderLayout.PAGE_END);

        frame.setVisible(true);
    }
}
