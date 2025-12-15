package Operation;
import Expression.*;

public class Numeric extends Operation {
    
    public Numeric(String expression) {
        super(expression);
    }

    public void split() {}

    public String solve() {
        return expression;
    }
}