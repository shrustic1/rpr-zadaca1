package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ExpressionEvaluatorTest {
    ExpressionEvaluator e = new ExpressionEvaluator();
    @Test
    void testingExpression(){
        assertEquals(101, e.evaluate("( 1 + ( ( 2 + 3 ) * ( 4 * 5 ) ) )"));
        assertEquals(11, e.evaluate("( 1 + ( ( 2 + 3 ) * ( sqrt 4 ) ) )"));
        assertEquals(21, e.evaluate("( 1 + ( ( 4 * 5 ) / ( 3 - 2 ) ) )"));
    }
}
