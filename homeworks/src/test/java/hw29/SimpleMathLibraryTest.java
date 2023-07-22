package hw29;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleMathLibraryTest {
    private SimpleMathLibrary mathLibrary = new SimpleMathLibrary();

    @Test
    public void testAdd() {
        double result = mathLibrary.add(2.0, 3.0);
        Assertions.assertEquals(5.0, result);
    }

    @Test
    public void testMinus() {
        double result = mathLibrary.minus(5.0, 2.0);
        Assertions.assertEquals(3.0, result);
    }
}
