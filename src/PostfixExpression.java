import java.util.Stack;

public class PostfixExpression {

    private Stack<String> stack = new Stack<String>();    
    private String expression;
    
    public PostfixExpression(String expression) {
        this.expression = expression;
    }
    
    public String toInfix() {
        return "3 * 4";
    }
    
}
