import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCalculator {

    @Test
    public void testCalc(){
        Calculator calc = new Calculator();

        int result = calc.add(2,3);

        assertEquals(5, result);
    }

}
