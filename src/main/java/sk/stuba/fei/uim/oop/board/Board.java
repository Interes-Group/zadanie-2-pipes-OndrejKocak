package sk.stuba.fei.uim.oop.board;


import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class Board extends JPanel {

    private Node[][] board;
    private final int boardSize;
    private final Random random;
    private Node start;
    private Node finish;

    public Board(int size) {
        this.random = new Random();
        this.boardSize = size;
        this.generateBoard();
    }

    private void generateBoard() {
        this.initBoard();
        HashSet<Node> visitedNodes = new HashSet<>();
        List<Node> stack = new ArrayList<>();
        stack.add(start);
        while(!stack.isEmpty()){
            Node currentNode = stack.remove(0);
            if (visitedNodes.contains(currentNode)) {
                continue;
            }

            ArrayList<Node> allNeighbours = currentNode.getAllNeighbour();
            Collections.shuffle(allNeighbours);
            allNeighbours.forEach(neighbour -> {
                if (!visitedNodes.contains(neighbour)) {
                    neighbour.setPrevious(currentNode);
                    stack.add(0,neighbour);
                }
            });
            visitedNodes.add(currentNode);
        }
        this.trackPath();
        for (int i = 0; i < this.boardSize; i++) {
            for (int j = 0; j < this.boardSize; j++) {
                Node node = board[i][j];
                this.add(node.getTile());
            }
        }
    }
    private void trackPath(){
        Node node = finish.getPrevious();
        Node next = finish;
        while (node.getPrevious() != null){
            node.setState(next);
            next = node;
            node = node.getPrevious();
        }
    }


    private void initBoard() {
        this.board = new Node[this.boardSize][this.boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                this.board[i][j] = new Node();
            }
        }
        this.setStartEnd();
        for (int i = 0; i < this.boardSize; i++) {
            for (int j = 0; j < this.boardSize; j++)  {
                if (i != 0) {
                    this.board[i][j].addNeighbour(Direction.UP, this.board[i-1][j]);
                }
                if (i != boardSize - 1) {
                    this.board[i][j].addNeighbour(Direction.DOWN, this.board[i+1][j]);
                }
                if (j != 0) {
                    this.board[i][j].addNeighbour(Direction.LEFT, this.board[i][j-1]);
                }
                if (j != boardSize - 1) {
                    this.board[i][j].addNeighbour(Direction.RIGHT, this.board[i][j+1]);
                }
            }
        }
        this.setLayout(new GridLayout(boardSize, boardSize));

        this.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        this.setBackground(Color.MAGENTA);

    }

    private void setStartEnd() {
        this.start = board[0][this.random.nextInt(this.boardSize)];
        start.setState(State.START);
        this.finish = board[boardSize - 1][this.random.nextInt(this.boardSize)];
        finish.setState(State.FINISH);
    }

}
