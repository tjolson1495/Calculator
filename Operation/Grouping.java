package Operation;
import Expression.*;

public abstract class Grouping extends Operation {

    public Grouping(String expression) {
        super(expression);
    }

    public abstract void split();

    public void split(String openChar, String closeChar) {
        String[] splitExpression = expression.split(openChar);

        subExpressions.add(new ExpressionFragment(splitExpression[0]));
        
        for (int i = 1; i < splitExpression.length; i++) {

            String[] newSplitExpression = splitExpression[i].split(closeChar);

            Expression e = new Expression(newSplitExpression[0]);       
            e.setOperation();
            e.split();        
            subExpressions.add(e);

            try{
                subExpressions.add(new ExpressionFragment(newSplitExpression[1]));
            } catch (ArrayIndexOutOfBoundsException obe) {
                continue;
            }
        }
    }

    public String solve() {
        String solution = subExpressions.get(0).solve();

        for (int i = 1; i < subExpressions.size(); i+=2) {
            String subSolution = subExpressions.get(i).solve();
            String nextSubSolution;

            try {
                nextSubSolution = subExpressions.get(i+1).solve();
            } catch (IndexOutOfBoundsException obe) {
                solution += subSolution;
                break;
            }

            if (nextSubSolution.charAt(0) == '^') {
                Expression e = new Expression(subSolution + nextSubSolution);
                e.setOperation();
                e.split();
                solution += e.solve();
            } else {
                solution += subSolution + nextSubSolution;
            }

        }

        Expression e = new Expression(solution);
        e.setOperation();
        e.split();

        return e.solve();
    }
}