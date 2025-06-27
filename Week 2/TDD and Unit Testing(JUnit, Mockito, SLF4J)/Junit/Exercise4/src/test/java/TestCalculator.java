import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCalculator {

    private Calculator calc;
    @Before
    public void setUp(){
        //Arrange: Create the Calculator object before each test
        System.out.println("Setting up test...");
        calc = new Calculator();
    }

    @After
    public void tearDown(){
        // Cleanup: Nullify or release resources if needed
        System.out.println("Tearing Down the test...");
        calc = null;
    }

    @Test
    public void testCalc (){
        // Act: Call the method under test
        int result = calc.add(5, 6);
        System.out.println("Test Started...");
        //Assert: Verify the result
        assertEquals(11, result);
    }


}
