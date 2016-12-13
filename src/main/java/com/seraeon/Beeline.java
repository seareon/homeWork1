package com.seraeon;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Misha Ro on 11.12.2016.
 */
public class Beeline {
    private Point point1;
    private Point point2;
    private int a;
    private int b;
    private int c;

    public double calculateAngleBetweenLines(Beeline line) {
        if(isParallel(line)) {
            return 0.0;
        }
        double cos = (a * line.getA() + b * line.getB()) / (Math.sqrt(a * a + b * b) *
                Math.sqrt(line.getA() * line.getA() + line.getB() * line.getB()));
        cos = Math.acos(cos);
        return Math.toDegrees(cos);
    }

    public double calculateDistanceBetweenParallelLines(Beeline line) {
        double distance = -1;
        if(isParallel(line)) {
            List<Integer> abc1c2 = calculateABC1C2(line);
            distance = Math.abs(abc1c2.get(3) - abc1c2.get(2)) / Math.sqrt(abc1c2.get(0) * abc1c2.get(0) +
                    abc1c2.get(1) * abc1c2.get(1));
        }
        return distance;
    }

    private boolean isParallel(Beeline line) {
        return a * line.getB() == b * line.getA();
    }

    private void calculateGeneralEquationBeeline() {
        a = point2.getY() - point1.getY();
        b =  - (point2.getX() - point1.getX());
        c =  point1.getY() * (point2.getX() - point1.getX()) - point1.getX() * (point2.getY() - point1.getY());

    }

    private List<Integer> calculateABC1C2(Beeline line) {
        List<Integer> list = new ArrayList<>();
        int divider;
        if(line.getA() < a) {
            divider = a / line.getA();
            list.add(line.getA());
            list.add(line.getB());
            list.add(line.getC());
            list.add(c / divider);
        } else {
            list.add(a);
            list.add(b);
            if(a < line.getA()) {
                divider = line.getA() / a;
                list.add(c);
                list.add(line.getC() / divider);
            } else {
                list.add(c);
                list.add(line.getC());
            }
        }
        return list;
    }

    public Point getPoint1() {
        return point1;
    }

    public void setPoint1(Point point1) {
        this.point1 = point1;
        if(point2 != null) {
            calculateGeneralEquationBeeline();
        }
    }

    public Point getPoint2() {
        return point2;
    }

    public void setPoint2(Point point2) {
        this.point2 = point2;
        if(point1 != null) {
            calculateGeneralEquationBeeline();
        }
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + point1.hashCode();
        result = prime * result + point1.hashCode();

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

        Beeline beelineOther = (Beeline) obj;

        if(point1.equals(beelineOther.getPoint1())) {
            return false;
        }

        if(point2.equals(beelineOther.getPoint2())) {
            return false;
        }

        return true;
    }
}
