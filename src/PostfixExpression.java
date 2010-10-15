import java.util.*;

public class PostfixExpression {

    private Stack<String> stack = new Stack<String>();    
    private String expression;
    private String lastToken = "";
    private Integer lastOperatorPrecedence = null;
    
    public PostfixExpression(String expression) {
        this.expression = expression;
    }
    
    public String toInfix() {
        String[] argumentos = expression.split(" ");
        String infixExpression = "";
        for(String token : argumentos) {
            if (isOperator(token)) {
                if(useParenthesis(token)){
                    if(isOperator(lastToken)){
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
    
    private boolean useParenthesis(String arg){
        return lastOperatorPrecedence != null &&
                lastOperatorPrecedence < operatorPrecedence(arg);
    }
    
    private int operatorPrecedence(String arg){
        if (arg.matches("[+-]")) {
            return 0;
        }
        return 1;
    }
    
}
