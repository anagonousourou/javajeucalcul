package app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    String varToBeInitInSetup;

    @BeforeEach
    void setUp() {
        varToBeInitInSetup = "Hello World!";
    }


}