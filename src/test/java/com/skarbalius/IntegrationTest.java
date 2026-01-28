package com.skarbalius;

import org.junit.jupiter.api.Test;

import java.io.File;

class IntegrationTest {
    private static final File resourcesDirectory = new File("src/test/resources");

    static {
        if (!resourcesDirectory.exists()) {
            resourcesDirectory.mkdirs();
        }
    }

    @Test
    void testcase1() {
        DECIDE.execute(
                new File(resourcesDirectory + "/testcase_1.json"),
                new File(resourcesDirectory + "/output_testcase_1.json")
        );
    }
}
