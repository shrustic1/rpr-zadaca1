package ba.unsa.etf.rpr;

import java.util.Stack;

public class ExpressionEvaluator{
    private Stack<String> ops = new Stack<String>();
    private Stack<Double> vals = new Stack<Double>();
    public double evaluate (String s){

        String[] izraz = s.split(" ");
        for (String znak : izraz){
            if (znak.equals("("));
            else if (znak.equals("+")) {ops.push(znak);}
            else if (znak.equals("-")) ops.push(znak);
            else if (znak.equals("*")) ops.push(znak);
            else if (znak.equals("/")) ops.push(znak);
            else if (znak.equals("sqrt")) ops.push(znak);
            else if (znak.equals(")")){
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) v=vals.pop() + v;
                else if (op.equals("-")) v=vals.pop() - v;
                else if (op.equals("*")) v=vals.pop() * v;
                else if (op.equals("/")) v=vals.pop() / v;
                else if (op.equals("sqrt")) v=Math.sqrt(v);
                vals.push(v);
            }
            else vals.push(Double.parseDouble(znak));
        }
        return vals.pop();
    }
}

