package com.skarbalius.task;

import com.skarbalius.input.BooleanOperator;
import java.util.Vector;

public class PUMHandler extends TaskHandler {
    private static final int SIZE = 15;

    @Override
    public void handle(TaskContext context) {
       verifyContext(context);

        context.pum = new java.util.Vector<>(SIZE);

        for (int i = 0; i < 15; i++) {
            Vector<Boolean> row = new Vector<>(SIZE);

            for (int j = 0; j < 15; j++) {
                if(context.lcm.get(i).get(j) != context.lcm.get(j).get(i)) {
                    throw new IllegalArgumentException("LCM matrix must be symmetric. First violation at (" + i + ", " + j + ")");
                }

                BooleanOperator op = context.lcm.get(i).get(j);
                boolean val;

                if (op == BooleanOperator.NOTUSED) {
                    val = true;
                } else if (op == BooleanOperator.ANDD) {
                    val = context.cmv.get(i) && context.cmv.get(j);
                } else {
                    val = context.cmv.get(i) || context.cmv.get(j);
                }
                row.add(val);
            }
            context.pum.add(row);
        }

        System.out.println("PUMHandler finished");
        super.setNextHandler(new FUVHandler());
        super.next(context);
    }

    private void verifyContext(TaskContext context) {
        if (context == null) {
            throw new IllegalArgumentException("TaskContext cannot be null");
        }

        if (context.cmv == null) {
            throw new IllegalArgumentException("CMV cannot be null");
        }

        if (context.lcm == null) {
            throw new IllegalArgumentException("LCM cannot be null");
        }

        if (context.lcm.size() != 15) {
            throw new IllegalArgumentException("LCM must be of size 15x15");
        }

        if (context.cmv.size() != 15) {
            throw new IllegalArgumentException("CMV must be of size 15");
        }

        if (context.lcm.getFirst().size() != 15) {
            throw new IllegalArgumentException("Each row in LCM must be of size 15");
        }
    }
}