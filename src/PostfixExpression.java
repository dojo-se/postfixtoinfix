import java.util.*;

public class PostfixExpression {

    private Stack<String> stack = new Stack<String>();    
    private String expression;
    
    public PostfixExpression(String expression) {
        this.expression = expression;
    }
    
    public String toInfix() {
        String[] argumentos = expression.split(" ");
        String infixExpression = "";
        for(String token : argumentos) {
            if (
                    token.equals("*") ||
                    token.equals("+") ||
                    token.equals("/") || 
                    token.equals("-")
               )
            {
                infixExpression = " " + token + " " +  stack.pop();
                infixExpression = stack.pop() + infixExpression;
                stack.push(infixExpression);
            }
            else
                stack.push(token);                
        }
 
        return stack.pop();
    }
    
}
