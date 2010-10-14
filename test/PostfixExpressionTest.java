import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PostfixExpressionTest {
    
    private PostfixExpression postfix;
    
    @Test
    public void test_34Mult() {
        postfix = new PostfixExpression("3 * 4");
        assertEquals("3 * 4", postfix.toInfix());
    }
    
}
