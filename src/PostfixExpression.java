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
        for(String token : argumentos) {
            if (isOperator(token)) {
                infixExpression = " " + token + " " +  stack.pop();
                if(lastOperatorPrecedence != null &&
                lastOperatorPrecedence < operatorPrecedence(token)){
                    infixExpression = "(" + stack.pop() + ")" + infixExpression;
                }else{
                    infixExpression = stack.pop() + infixExpression;
                }
                stack.push(infixExpression);
                lastOperatorPrecedence = operatorPrecedence(token);
            } else {
                stack.push(token);
            }
        }
 
        return stack.pop();
    }
    
    private boolean isOperator(String argumento) {
       return argumento.equals("*") ||
                    argumento.equals("+") ||
                    argumento.equals("/") || 
                    argumento.equals("-");
    }
    
    private int operatorPrecedence(String arg){
        if(arg.equals("+") || arg.equals("-")){
            return 0;
        }
        return 1;
    }
    
}
