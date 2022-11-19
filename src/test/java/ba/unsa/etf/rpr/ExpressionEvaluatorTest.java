package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionEvaluatorTest {
    @Test
    public void testingExpression() throws RuntimeException {
        ExpressionEvaluator e = new ExpressionEvaluator();
        assertEquals(101, e.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"));
        assertEquals(11, e.evaluate("( 1 + ( ( 2 + 3 ) * ( sqrt 4 ) ) )"));
        assertEquals(21, e.evaluate("( 1 + ( ( 4 * 5 ) / ( 3 - 2 ) ) )"));
    }
    @Test
    public void test() throws RuntimeException{
        ExpressionEvaluator e = new ExpressionEvaluator();
        assertThrows(Exception.class, () -> { e.evaluate("(1+2)");});
        assertThrows(Exception.class, () -> { e.evaluate("sklj");});
    }
}
