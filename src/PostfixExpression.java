import java.util.*;

public class PostfixExpression {

    private Stack<String> stack = new Stack<String>();    
    private String expression;
    
    public PostfixExpression(String expression) {
        this.expression = expression;
    }
    
    public String toInfix() {
        String resultado = "";
        
        String[] exprArray = expression.split(" ");
        String auxExp;
        for(String token : exprArray) {
            if (
                    token.equals("*") ||
                    token.equals("+") ||
                    token.equals("/") || 
                    token.equals("-")
               )
            {
                auxExp = "";
                auxExp = " " + token + " " +  stack.pop();
                auxExp = stack.pop() + auxExp;
                stack.push(auxExp);
            }
            else
                stack.push(token);                
        }
        resultado = stack.pop();       
        return resultado;
    }
    
}
