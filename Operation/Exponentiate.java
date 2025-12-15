package Operation;

import Expression.*;

public class Exponentiate extends Operation {

    public Exponentiate(String expression) {
        super(expression);
    }

    public void split() {
        split("\\^");
    }

    public String solve() {
        double solution = Double.parseDouble(subExpressions.get(0).solve());

        for (int i = 1; i < subExpressions.size(); i++) {
            if (solution < 0) solution = -1 * Math.pow(solution*-1, Double.parseDouble(subExpressions.get(i).solve()));
            else solution = Math.pow(solution, Double.parseDouble(subExpressions.get(i).solve()));
        }

        return String.valueOf(solution);
    }
}