package Operation;
import Expression.*;

public class Brackets extends Grouping {

    public Brackets(String expression) {
        super(expression);
    }

    public void split() {
        split("\\[", "\\]");
    }
}