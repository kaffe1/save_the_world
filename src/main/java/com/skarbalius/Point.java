package com.skarbalius;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;

import java.util.ArrayList;

public class Point
{
    double x;
    double y;

    public Point (double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getDistance(Point p)
    {
        double dx = x - p.x;
        double dy = y - p.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    //TODO: Move to GeometryUtils class

    public double getAngleBetweenNeighbours(Point p1, Point p2) {
        Vector2D v1 = new Vector2D(p1.x - this.x, p1.y - this.y);
        Vector2D v2 = new Vector2D(p2.x - this.x, p2.y - this.y);
        return Vector2D.angle(v1, v2);
    }

    public static Point getCentroid(ArrayList<Point> points) {
        Point center = points.stream()
                .reduce(new Point(0, 0), (acc, p) -> {
                    acc.x += p.x;
                    acc.y += p.y;
                    return acc;
                });
        center.x /= 3;
        center.y /= 3;
        return center;
    }

   @Override
   public boolean equals(Object o)
    {
        if (!(o instanceof Point p)) {
           return false;
       }
        return this.x == p.x && this.y == p.y;
    }
}
