package org.example.steps;
import org.junit.jupiter.api.Assertions;

public class WbSteps {

    public static void textEquals(String element, String text) {

        Assertions.assertEquals(element,text);
    }
}
