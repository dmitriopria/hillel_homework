package hw26;

import hw26.annotations.AfterSuite;
import hw26.annotations.BeforeSuite;
import hw26.annotations.Priority;
import hw26.annotations.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TestClass {
    private static final Logger LOGGER = Logger.getLogger(TestClass.class.getName());

    @BeforeSuite
    public void beforeSuiteMethod() {
        LOGGER.log(Level.INFO, "BeforeSuite method");
    }

    @Priority(priority = 9)
    @Test
    public void testMethod1() {
        LOGGER.log(Level.INFO, "Test method 1");
    }

    @Test
    public void testMethod2() {
        LOGGER.log(Level.INFO, "Test method 2");
    }

    @Test
    @Priority(priority = 1)
    public void testMethod3() {
        LOGGER.log(Level.INFO, "Test method 3");
    }

    @AfterSuite
    public void afterSuiteMethod() {
        LOGGER.log(Level.INFO, "AfterSuite method");
    }
}