package hw26;

public class TestClass {
    @BeforeSuite
    public void beforeSuiteMethod() {
        System.out.println("BeforeSuite method");
    }

    @Test(priority = 1)
    public void testMethod1() {
        System.out.println("Test method 1");
    }

    @Test(priority = 6)
    public void testMethod2() {
        System.out.println("Test method 2");
    }

    @Test(priority = 3)
    public void testMethod3() {
        System.out.println("Test method 3");
    }

    @AfterSuite
    public void afterSuiteMethod() {
        System.out.println("AfterSuite method");
    }
}