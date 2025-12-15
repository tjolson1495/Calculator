package Expression;

import Operation.*;

public class Expression implements ExpressionPart {

    private String expression;
    private Operation opp;

    public Expression(String expression) {
        this.expression = expression;
    }

    public void setOperation() {
        setOperation(false);
    }

    public void setOperation(boolean skipSubtract) {

        try {
            // Checks if expression is already a number
            Double.parseDouble(expression);
            opp = new Numeric(expression);
            
        } catch (NumberFormatException e) {

            if (expression.contains("[")) opp = new Brackets(expression);
            else if (expression.contains(")")) opp = new Paranthesis(expression);
            else if (expression.contains("+")) opp = new Add(expression);
            else if (expression.contains("-") && !skipSubtract) opp = new Subtract(expression);
            else if (expression.contains("*")) opp = new Multiply(expression);
            else if (expression.contains("/")) opp = new Divide(expression);
            else if (expression.contains("^")) opp = new Exponentiate(expression);
            else opp = new Numeric(expression);
            // None Type functions same as Numeric
        }

        //System.out.println(expression + " => " + opp);
    }

    public void split() {
        opp.split();
    }

    public String solve() {
        return opp.solve();
    }

}