package com.seraeon;

/**
 * Created by Misha Ro on 11.12.2016.
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 31;

        result = prime * result + x;
        result = prime * result + y;

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(obj == null) {
            return false;
        }

        if(getClass() != obj.getClass()) {
            return false;
        }

        Point pointOther = (Point) obj;

        if(x != pointOther.getX()) {
            return false;
        }

        if(y != pointOther.getY()) {
            return false;
        }

        return true;
    }
}
