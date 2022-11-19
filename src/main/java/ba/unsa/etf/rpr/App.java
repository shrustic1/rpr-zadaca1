package ba.unsa.etf.rpr;

/**
 * Hello world!
 *
 */
public class App{

    public static void main(String[] args )
    {
        try {
            ExpressionEvaluator e = new ExpressionEvaluator();
            double rezultat = e.evaluate(args[0]);
            System.out.println(args[0] + "=" + rezultat);
        } catch (RuntimeException e){
            System.out.println("Format unosa nije korektan!");
        }
    }
}
