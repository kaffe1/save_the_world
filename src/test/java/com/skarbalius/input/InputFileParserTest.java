package com.skarbalius.input;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputFileParserTest {

    private static final InputFileParser PARSER = new InputFileParser();
    private  static final File resourcesDirectory = new File("src/test/resources");

    @Test
    void write() {
        List<float[]> points = new ArrayList<>();
        points.add(new float[]{143098.509F, 855368.983F});
        points.add(new float[]{-486139.466F, -978699.884F});
        List<Parameter> parameters = new ArrayList<>();
        parameters.add(new FloatParameter("someParam", 12.34F));
        parameters.add(new IntegerParameter("someIntParam", -123));
        List<Boolean> puv = new ArrayList<>();
        puv.add(true);
        puv.add(false);
        Map<Integer, List<String>> lcm = Map.of(
                0, List.of("AND", "OR"),
                1, List.of("ANDOR", "AND")
        );
        Input input = new Input(
                2,
                points,
                parameters,
                puv,
                lcm
        );
        File outputFile = new File(resourcesDirectory.getAbsolutePath() + "/input.json");
        PARSER.writeInputFile(outputFile, input);
        Input result = PARSER.readInputFile(outputFile);
        assertEquals(input.NUMPOINTS(), result.NUMPOINTS());
        assertEquals(input.points().size(), result.points().size());
        assertEquals(input.parameters().size(), result.parameters().size());
        assertEquals(input.PUV(), result.PUV());
        assertEquals(input.LCM(), result.LCM());
    }
}
