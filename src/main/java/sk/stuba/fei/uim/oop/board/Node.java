package sk.stuba.fei.uim.oop.board;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.tiles.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Node {
    @Getter
    private Tile tile;
    @Getter
    private Map<Direction, Node> neighbours;
    @Setter
    @Getter
    private Node previous;
    @Getter
    private boolean finish;

    public Node() {
        this.previous = null;
        this.neighbours = new HashMap<>();
        this.tile = new Tile();
    }
    public void setFinish(boolean finish){
        this.finish = finish;
        selectTile(finish);
    }
    public void addNeighbour(Direction direction, Node node) {
        this.neighbours.put(direction, node);
    }
    public void setTile(Tile tile){
        this.tile = tile;
    }
    public void selectTile(){
        this.tile = new StraightPipe();
    }
    public void selectTile(boolean startEnd){
        if(startEnd){
            this.tile = new StartEnd();
        }
        else {
            this.selectTile();
        }
    }

    public ArrayList<Node> getAllNeighbour() {
        return new ArrayList<>(this.neighbours.values());
    }
}
