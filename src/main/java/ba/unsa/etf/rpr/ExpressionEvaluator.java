package ba.unsa.etf.rpr;

import java.util.Stack;

/**
 * Class that calculates given expression
 * @author Selma Hrustić
 * @version 1.0
 * */
public class ExpressionEvaluator{
    private Stack<String> ops = new Stack<String>();
    private Stack<Double> vals = new Stack<Double>();

    /**
     * Method that uses Dijkstra's Two-Stack Algorithm to calculate given expression, expression must be sent in proper format, with brackets and space between every operand and operator
     * @author Selma Hrustić
     * @version 1.0
     * */
    public double evaluate (String s) throws RuntimeException {
        int brojac_ulaznih=0, brojac_izlaznih=0;
        try {
            String[] izraz = s.split(" ");
            for (String znak : izraz) {
                if (znak.equals("(")) {
                    brojac_ulaznih++;
                }
                else if (znak.equals("+")) {
                    ops.push(znak);
                } else if (znak.equals("-")) ops.push(znak);
                else if (znak.equals("*")) ops.push(znak);
                else if (znak.equals("/")) ops.push(znak);
                else if (znak.equals("sqrt")) ops.push(znak);
                else if (znak.equals(")")) {
                    brojac_izlaznih++;
                    String op = ops.pop();
                    double v = vals.pop();
                    if (op.equals("+")) v = vals.pop() + v;
                    else if (op.equals("-")) v = vals.pop() - v;
                    else if (op.equals("*")) v = vals.pop() * v;
                    else if (op.equals("/")) v = vals.pop() / v;
                    else if (op.equals("sqrt")) v = Math.sqrt(v);
                    vals.push(v);
                } else vals.push(Double.parseDouble(znak));
            }
            if (brojac_ulaznih!=brojac_izlaznih || brojac_ulaznih==0) throw new RuntimeException();
            return vals.pop();
        } catch(RuntimeException e){
            throw new RuntimeException();
        }
    }
    /**
     * Method that checks if stack that contains operands is empty
     * */
    public boolean isOpsEmpty(){
        return ops.isEmpty();
    }
    /**
     * Method that checks if stack that contains values is empty
     * */
    public boolean isValsEmpty(){
        return vals.isEmpty();
    }
}

