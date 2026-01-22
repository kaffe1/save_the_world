package com.skarbalius.input;

import java.util.List;
import java.util.Map;

public record Input(int NUMPOINTS, List<float[]> points, List<Parameter> parameters, List<Boolean> PUV, Map<Integer, List<String>> LCM) {
}
