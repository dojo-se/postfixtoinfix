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
        Integer lastOperatorPrecedence = null;
        String lastToken = "";
        for(String token : argumentos) {
            if (isOperator(token)) {
                boolean useParenthesis = lastOperatorPrecedence != null &&
                lastOperatorPrecedence < operatorPrecedence(token);
                boolean isRightParenthesis = isOperator(lastToken);
                if(useParenthesis){
                    if(isRightParenthesis){
                        infixExpression = " " + token + " (" + stack.pop() + ")";
                        infixExpression = stack.pop() + infixExpression;
                    }else{
                        infixExpression = " " + token + " " + stack.pop();
                        infixExpression = "(" + stack.pop() + ")" + infixExpression;
                    }
                }else{
                    infixExpression = " " + token + " " + stack.pop();
                    infixExpression = stack.pop() + infixExpression;
                }
                stack.push(infixExpression);
                lastOperatorPrecedence = operatorPrecedence(token);
            } else {
                stack.push(token);
            }
            lastToken = token;
        }
 
        return stack.pop();
    }
    
    private boolean isOperator(String argumento) {
       return argumento.matches("[*/+-]");
    }
    
    private int operatorPrecedence(String arg){
        if (arg.matches("[+-]")) {
            return 0;
        }
        return 1;
    }
    
}
