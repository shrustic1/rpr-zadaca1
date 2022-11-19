package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionEvaluatorTest {

    private ExpressionEvaluator e = new ExpressionEvaluator();
    @Test
    public void testingExpression() throws RuntimeException {

        assertEquals(101, e.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"));
        assertEquals(11, e.evaluate("( 1 + ( ( 2 + 3 ) * ( sqrt 4 ) ) )"));
        assertEquals(21, e.evaluate("( 1 + ( ( 4 * 5 ) / ( 3 - 2 ) ) )"));
    }
    @Test
    public void testingInputFormat1() throws RuntimeException{
        assertThrows(Exception.class, () -> { e.evaluate("(1+2)");});
    }

    @Test
    public void testingInputFormat2() throws RuntimeException{
        assertThrows(Exception.class, () -> { e.evaluate("sklj");});
    }

    @Test
    public void testingInputFormat3() throws RuntimeException{
        assertThrows(Exception.class, () -> { e.evaluate("( ( 1 + 2 ) ) )");});
    }

    @Test
    public void testingEmptyInput() throws RuntimeException{
        assertThrows(Exception.class, () -> { e.evaluate(" ");});
    }

}
