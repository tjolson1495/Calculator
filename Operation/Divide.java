package Operation;
import Expression.*;

public class Divide extends Operation {

    public Divide(String expression) {
        super(expression);
    }

    public void split() {
        split("/");
    }

    public String solve() {
        double solution = Double.parseDouble(subExpressions.get(0).solve());

        for (int i = 1; i < subExpressions.size(); i++) {
            if (subExpressions.get(i).equals("0")) throw new RuntimeException("Divide by zero");
            solution /= Double.parseDouble(subExpressions.get(i).solve());
        }

        return String.valueOf(solution);
    }
}