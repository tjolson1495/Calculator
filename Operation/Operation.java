package Operation;
import Expression.*;

import java.util.ArrayList;

import Expression.*;

public abstract class Operation {

    protected String expression;
    protected ArrayList<ExpressionPart> subExpressions = new ArrayList<>();

    public Operation(String expression) {
        this.expression = expression;
    }

    public abstract void split();
    public abstract String solve();

    public void split(String splitChar) {
        String[] splitExpression = expression.split(splitChar);
        
        for (int i = 0; i < splitExpression.length; i++) {

            Expression e = new Expression(splitExpression[i]);
            
            e.setOperation();
            e.split();
            
            subExpressions.add(e);
        }
    }

}