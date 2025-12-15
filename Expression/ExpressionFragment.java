package Expression;

public class ExpressionFragment implements ExpressionPart {

    String fragment;
    
    public ExpressionFragment(String fragment) {
        this.fragment = fragment;
    }

    public String solve() {
        return fragment;
    }
}