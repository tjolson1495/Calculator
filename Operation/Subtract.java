package Operation;
import Expression.*;

public class Subtract extends Operation {

    public Subtract(String expression) {
        super(expression);
    }

    public void split() {
        String[] splitExpression = expression.split("\\-");
        String subExpression = "";
        boolean skipSubtract = false;
        
        for (int i = 0; i < splitExpression.length; i++) {

            if (splitExpression[i].equals("")) {
                subExpression += "-";
                skipSubtract = true;
                continue;
            }

            if (splitExpression[i].charAt(splitExpression[i].length()-1) < '0'
                || splitExpression[i].charAt(splitExpression[i].length()-1) > '9') {
                subExpression += splitExpression[i] + "-";
                skipSubtract = true;
                continue;   
            } 

            subExpression += splitExpression[i];

            Expression e = new Expression(subExpression);
            e.setOperation(skipSubtract);
            e.split();

            subExpressions.add(e);

            subExpression = "";
            skipSubtract = false;
        }
    }

    public String solve() {
        double solution = Double.parseDouble(subExpressions.get(0).solve());

        for (int i = 1; i < subExpressions.size(); i++) {
            solution -= Double.parseDouble(subExpressions.get(i).solve());
        }

        return String.valueOf(solution);
    }
}