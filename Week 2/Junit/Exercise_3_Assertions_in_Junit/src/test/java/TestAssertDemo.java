import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAssertDemo {

    @Test
    public void testAssertions() {

        AssertDemo obj = new AssertDemo();

        // Assert null
        assertNull(null);
        // Assert not null
        assertNotNull(obj);

        // Assert equals
        int result = obj.add(2,3);
        assertEquals(5, result);
        // Assert true
        assertTrue(obj.greaterThan(7, 3));
        assertTrue(5 > 3);
        // Assert false
        assertFalse(obj.greaterThan(7, 9));
        assertFalse(5 < 3);

    }


}
