package Operation;
import Expression.*;

public class Paranthesis extends Grouping {

    public Paranthesis(String expression) {
        super(expression);
    }

    public void split() {
        split("\\(", "\\)");
    }
}