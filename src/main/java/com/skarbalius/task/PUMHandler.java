package com.skarbalius.task;

import com.skarbalius.input.BooleanOperator;
import java.util.Vector;

public class PUMHandler extends TaskHandler {
    @Override
    public void handle(TaskContext context) {

        context.pum = new java.util.Vector<>(context.NUMPOINTS);

        for (int i = 0; i < 15; i++) {
            Vector<Boolean> row = new Vector<>(context.NUMPOINTS);

            for (int j = 0; j < 15; j++) {
                BooleanOperator op = context.lcm.get(i).get(j);
                boolean val;

                if (op == BooleanOperator.NOTUSED) {
                    val = true; // NOTUSED 
                } else if (op == BooleanOperator.ANDD) {
                    val = context.cmv.get(i) && context.cmv.get(j); // ANDD
                } else { 
                    val = context.cmv.get(i) || context.cmv.get(j); // ORR
                }
                row.add(val);
            }
            context.pum.add(row);
        }

        System.out.println("PUMHandler");
        // super.setNextHandler(new FUVHandler());
        // super.next(context);
    }
}