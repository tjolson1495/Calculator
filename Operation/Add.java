package Operation;
import Expression.*;

public class Add extends Operation {
    
    public Add(String expression) {
        super(expression);
    }

    public void split() {
        split("\\+");
    }

    public String solve() {
        double solution = Double.parseDouble(subExpressions.get(0).solve());

        for (int i = 1; i < subExpressions.size(); i++) {
            solution += Double.parseDouble(subExpressions.get(i).solve());
        }

        return String.valueOf(solution);
    }
}