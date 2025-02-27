package sk.stuba.fei.uim.oop.board;

import lombok.Getter;

public enum Direction {
    UP(1),
    RIGHT(2),
    DOWN(-1),
    LEFT(-2);

    @Getter
    private final int value;
    Direction(int value) {
        this.value = value;
    }
}
