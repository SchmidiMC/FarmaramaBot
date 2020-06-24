package de.noel.model;

public class ClassifiedPoint {
    private final int x;
    private final int y;

    public ClassifiedPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "( " + x + "px : " + y + "px )";
    }
}
