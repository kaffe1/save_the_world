package com.skarbalius.conditionTests;

import com.skarbalius.Conditions;
import com.skarbalius.Parameters_T;
import com.skarbalius.Point;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class Condition4Test
{
    @Test
    void testCondition4_MoreThanQUADSQuadrants_ReturnsTrue() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(1, 1));    // Q1
        points.add(new Point(-1, 1));   // Q2
        points.add(new Point(-1, -1));  // Q3
        points.add(new Point(1, -1));   // Q4

        Parameters_T params = new TestParameters();
        params.Q_PTS = 4;
      

        Conditions conditions = new Conditions(points, 4, params);
        assertTrue(conditions.condition4(points, 4, params, 3));
    }

    @Test
    void testCondition4_ExactlyQUADSQuadrants_ReturnsFalse() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(1, 1));   
        points.add(new Point(-1, 1));   
        points.add(new Point(-2, 2));   
        points.add(new Point(2, 2));   

        Parameters_T params = new TestParameters();
        params.Q_PTS = 4;


        Conditions conditions = new Conditions(points, 4, params);
        assertFalse(conditions.condition4(points, 4, params, 2));
    }

    @Test
    void testCondition4_AxisPointsHandledCorrectly_ReturnsTrue() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(0, 0));    
        points.add(new Point(-1, 0));   
        points.add(new Point(0, -1));  
        points.add(new Point(1, -1));  

        Parameters_T params = new TestParameters();
        params.Q_PTS = 4;

        Conditions conditions = new Conditions(points, 4, params);
        assertTrue(conditions.condition4(points, 4, params, 3));
    }

    @Test
    void testCondition4_SlidingWindowDetectsLaterBlock_ReturnsTrue() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(1, 1));    
        points.add(new Point(2, 2));    
        points.add(new Point(-1, 1));   
        points.add(new Point(-1, -1));  
        points.add(new Point(1, -1));  

        Parameters_T params = new TestParameters();
        params.Q_PTS = 4;


        Conditions conditions = new Conditions(points, 5, params);
        assertTrue(conditions.condition4(points, 5, params, 2));
    }

    @Test
    void testCondition4_InsufficientDistinctQuadrants_ReturnsFalse() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(1, 1));    
        points.add(new Point(2, 2));    
        points.add(new Point(3, 3));    
        points.add(new Point(4, 4));    

        Parameters_T params = new TestParameters();
        params.Q_PTS = 4;


        Conditions conditions = new Conditions(points, 4, params);
        assertFalse(conditions.condition4(points, 4, params, 1));
    }

    @Test
    void testCondition4_NotEnoughPoints_ReturnsFalse() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(1, 1));
        points.add(new Point(-1, 1));

        Parameters_T params = new TestParameters();
        params.Q_PTS = 3;


        Conditions conditions = new Conditions(points, 2, params);
        assertFalse(conditions.condition4(points, 2, params, 1));
    }
}
