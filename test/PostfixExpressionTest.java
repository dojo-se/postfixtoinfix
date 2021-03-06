import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PostfixExpressionTest {
    
    private PostfixExpression postfix;
    
    @Test
    public void test_34Times() {
        postfix = new PostfixExpression("3 4 *");
        assertEquals("3 * 4", postfix.toInfix());
    }
    
    @Test
    public void test_334Sum() {
        postfix = new PostfixExpression("33 4 +");
        assertEquals("33 + 4", postfix.toInfix());
    }

    @Test
    public void test_34Sum6Times() {
        postfix = new PostfixExpression("3 4 + 6 *");
        assertEquals("(3 + 4) * 6", postfix.toInfix());
    } 
    
    @Test
    public void test_34Times6Sum() {
        postfix = new PostfixExpression("3 4 * 6 +");
        assertEquals("3 * 4 + 6", postfix.toInfix());
    }
    
    @Test
    public void test_3Times46Sum() {
        postfix = new PostfixExpression("3 4 6 + *");
        assertEquals("3 * (4 + 6)", postfix.toInfix());
    }
    
    @Test
    public void test_3Times46Sum6Div1Sum() {
        postfix = new PostfixExpression("3 4 6 + 6 / 1 + *");
        assertEquals("3 * ((4 + 6) / 6 + 1)", postfix.toInfix());
    }
    
    @Test
    public void test_46SumDiv61Sum() {
        postfix = new PostfixExpression("4 6 + 6 1 + /");
        assertEquals("(4 + 6) / (6 + 1)", postfix.toInfix());
    }
}
