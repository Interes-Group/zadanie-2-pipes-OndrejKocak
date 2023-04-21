package sk.stuba.fei.uim.oop.controls;

import lombok.Getter;
import sk.stuba.fei.uim.oop.board.Board;
import sk.stuba.fei.uim.oop.tiles.Tile;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameLogic extends UniversalAdapter{
    private final JFrame mainFrame;
    private static final int INITIAL_BOARD_SIZE = 8;
    @Getter
    private final JLabel currentBoardSizeLabel;
    private int currentBoardSize;
    private Board board;
    private int level;
    @Getter
    private final JLabel levelLabel;
    public GameLogic(JFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.level = 1;
        this.currentBoardSize = INITIAL_BOARD_SIZE;
        initNewBoard();

        this.levelLabel = new JLabel();
        this.levelLabel.setHorizontalAlignment(JLabel.CENTER);

        this.currentBoardSizeLabel = new JLabel();
        this.currentBoardSizeLabel.setHorizontalAlignment(JLabel.CENTER);

        mainFrame.add(board);
        updateBoardSizeLabel();
        updateLevelLabel();
    }

    private void updateLevelLabel(){
        this.levelLabel.setText("LEVEL: " + this.level);
        this.updateMainFrame();
    }

    private void updateBoardSizeLabel() {
        this.currentBoardSizeLabel.setText("CURRENT BOARD SIZE: " + this.currentBoardSize);
        this.updateMainFrame();
    }

    private void updateMainFrame(){
        this.mainFrame.revalidate();
        this.mainFrame.repaint();
    }


    private void gameRestart(){
        this.level = 1;
        this.initNewBoard();
        this.updateLevelLabel();
    }

    private void initNewBoard(){
        if(this.board !=null){
            this.mainFrame.remove(this.board);
        }
        this.board = new Board(this.currentBoardSize);
        this.mainFrame.add(this.board);
        this.board.addMouseMotionListener(this);
        this.board.addMouseListener(this);
        this.updateMainFrame();
    }

    private void checkCorrectness(){
        if(this.board.checkPath()){
            this.level++;
            this.initNewBoard();
            this.updateLevelLabel();
        }
    }

    @Override
    public void stateChanged(ChangeEvent changeEvent) {
        int newSize = ((JSlider) changeEvent.getSource()).getValue();
        if(newSize != this.currentBoardSize){
            this.currentBoardSize = newSize;
            this.updateBoardSizeLabel();
            this.gameRestart();
            this.mainFrame.setFocusable(true);
            this.mainFrame.requestFocus();
        }

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        switch (keyEvent.getKeyCode()) {
            case KeyEvent.VK_R:
                this.gameRestart();
                break;
            case KeyEvent.VK_ESCAPE:
                this.mainFrame.dispose();
                break;
            case KeyEvent.VK_ENTER:
                this.checkCorrectness();
                this.board.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        Component current = this.board.getComponentAt(mouseEvent.getX(), mouseEvent.getY());
        if (!(current instanceof Tile)) {
            return;
        }
        ((Tile) current).setHighlight(true);
        this.board.repaint();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        Component current = this.board.getComponentAt(mouseEvent.getX(), mouseEvent.getY());
        if (!(current instanceof Tile)) {
            return;
        }
        if(((Tile) current).isPlayable()){
            ((Tile) current).rotate();
            ((Tile) current).setHighlight(true);
            this.board.repaint();
        }
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getActionCommand().equals("Restart")){
            this.gameRestart();
        } else if (actionEvent.getActionCommand().equals("Check Correctness")) {
            this.checkCorrectness();
        }
        this.board.repaint();
    }
}
