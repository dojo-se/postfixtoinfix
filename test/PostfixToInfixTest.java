import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PostfixToInfixTest {
    
    private PostfixToInfix postfixToInfix;
    
    @Before
    public void inicializa() {
        postfixToInfix = new PostfixToInfix();
    }
    
    @Test
    public void test_34Mult() {
        assertEquals("3 * 4", postfixToInfix.converter("3 4 *"));
    }
}
