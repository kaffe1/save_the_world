package com.skarbalius;

import java.util.ArrayList;
import java.util.Vector;

public class Conditions
{

    private final Vector<Boolean> cmv;

    public Conditions(ArrayList<Point> points, int NUMPOINTS, Parameters_T parameters) {
        cmv = new Vector<Boolean>(15);
        cmv.add(condition0(points, NUMPOINTS, parameters));
        cmv.add(condition1(points, NUMPOINTS, parameters));
        cmv.add(condition2(points, NUMPOINTS, parameters));
    }

    public Vector<Boolean> getCMV() {
        return cmv;
    }



}
