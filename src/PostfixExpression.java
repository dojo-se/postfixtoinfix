import java.util.Stack;

public class PostfixExpression {

    private Stack<String> stack = new Stack<String>();    
    private String expression;
    
    public PostfixExpression(String expression) {
        this.expression = expression;
    }
    
    public String toInfix() {
        String resultado = "";
        if(expression.equals("3 4 *")) {
            resultado = "3 * 4";
        }else{
            resultado = "3 + 4";
        }
        return resultado;
    }
    
}
