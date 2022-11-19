package ba.unsa.etf.rpr;

import java.util.Stack;

public class ExpressionEvaluator{
    private Stack<String> ops = new Stack<String>();
    private Stack<Double> vals = new Stack<Double>();
    public double evaluate (String s) throws RuntimeException {
        int brojac_ulaznih=0, brojac_izlaznih=0;
        boolean ima_pocetak=false;
        try {
            String[] izraz = s.split(" ");
            for (String znak : izraz) {
                if (znak.equals("(")) {brojac_ulaznih++; ima_pocetak=true;}
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
            if (brojac_ulaznih!=brojac_izlaznih || !ima_pocetak) throw new RuntimeException();
            return vals.pop();
        } catch(RuntimeException e){
            throw new RuntimeException();
        }
    }
    public boolean isOpsEmpty(){
        return ops.isEmpty();
    }
    public boolean isValsEmpty(){
        return vals.isEmpty();
    }
}

