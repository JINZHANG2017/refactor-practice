package com.twu.refactoring;

public class Direction {
    private final char direction;

    public Direction(char direction) {
        this.direction = direction;
    }
    private String rightStr="NESW";
    public Direction turnRight() {
        int index=rightStr.indexOf(direction);
        if(index>=0){
            return new Direction(rightStr.charAt((index+1)%4));
        }else{
            throw new IllegalArgumentException();
        }
    }

    public Direction turnLeft() {
        int index=rightStr.indexOf(direction);
        if(index>=0){
            return new Direction(rightStr.charAt((index+3)%4));
        }else{
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction direction1 = (Direction) o;
        if (direction != direction1.direction) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return (int) direction;
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }
}
