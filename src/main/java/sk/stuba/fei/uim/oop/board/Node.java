package sk.stuba.fei.uim.oop.board;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.tiles.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Node {
    @Getter
    private Tile tile;
    @Getter
    private final Map<Direction, Node> neighbours;
    @Setter
    @Getter
    private Node previous;

    @Getter
    private State state;

    public Node() {
        state = State.EMPTY;
        this.previous = null;
        this.neighbours = new HashMap<>();
        this.setTile();
    }

    public void setState(State state){
        this.state = state;
        this.setTile();
    }
    public void setState(Node next){
        if((getNeighbourDirection(previous).getX() + getNeighbourDirection(next).getX()) == 0){
            this.state = State.STRAIGHT;
        }
        else {
            this.state = State.BENT;
        }
       this.setTile();
    }
    public void addNeighbour(Direction direction, Node node) {
        this.neighbours.put(direction, node);
    }
    private void setTile(){
        switch (this.state){
            case START:
                this.tile = new StartEnd();
                break;
            case FINISH:
                this.tile = new StartEnd();
                break;
            case BENT:
                this.tile = new BentPipe();
                break;
            case STRAIGHT:
                this.tile = new StraightPipe();
                break;
            case EMPTY:
                this.tile = new Tile();
        }
    }
    public ArrayList<Node> getAllNeighbour() {
        return new ArrayList<>(this.neighbours.values());
    }

    private Direction getNeighbourDirection(Node neighbour){
        for(Map.Entry<Direction, Node> entry : this.neighbours.entrySet()){
            if(entry.getValue().equals(neighbour)){
                return entry.getKey();
            }
        }
        return null;
    }
}
