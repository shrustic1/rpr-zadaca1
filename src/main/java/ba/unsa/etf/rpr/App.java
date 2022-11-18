package ba.unsa.etf.rpr;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        ExpressionEvaluator e = new ExpressionEvaluator();
        double rezultat = e.evaluate (args[0]);
        System.out.println(args[0] + "=" + rezultat);
    }
}
