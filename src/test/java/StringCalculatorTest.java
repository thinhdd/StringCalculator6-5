import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: RuaTre_IT
 * Date: 6/5/13
 * Time: 2:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringCalculatorTest {
    @Test
    public void testEmpty()
    {
        StringCalculator sc = new StringCalculator();
        Assert.assertEquals(sc.add(""), 0);
    }
    @Test
    public void testOneDigit()
    {
        StringCalculator sc = new StringCalculator();
        Assert.assertEquals(sc.add("2"), 2);
    }
    @Test
    public void testOneDelimiter()
    {
        StringCalculator sc = new StringCalculator();
        Assert.assertEquals(sc.add("1,2"), 3);
    }
    @Test
    public void testTwoDelimiter()
    {
        StringCalculator sc = new StringCalculator();
        Assert.assertEquals(sc.add("1,2\n3"), 6);
    }
    @Test
    public void testErrorTwoDelimiter()
    {
        StringCalculator sc = new StringCalculator();
        Assert.assertEquals(sc.add("1,\n2"), -1);
    }
    @Test
    public void testDotComOneDelimiter()
    {
        StringCalculator sc = new StringCalculator();
        Assert.assertEquals(sc.add("//;\n1;2"), 3);
    }
    @Test
    public void testSpeOneDelimiter()
    {
        StringCalculator sc = new StringCalculator();
        Assert.assertEquals(sc.add("//,\n1,2"), 3);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testNegativeNumber()
    {
        StringCalculator sc = new StringCalculator();
        try{
        Assert.assertEquals(sc.add("-1,-2"), -1);
        }
        catch (IllegalArgumentException e)
        {
            Assert.assertEquals(e.getMessage(),"-1 -2 ");
            throw new IllegalArgumentException("");
        }
    }
    @Test
    public void testBigNumber()
    {
        StringCalculator sc = new StringCalculator();
        Assert.assertEquals(sc.add("1,1000"), 1);
    }
    @Test
    public void testStringDelimiter()
    {
        StringCalculator sc = new StringCalculator();
        Assert.assertEquals(sc.add("//[***]\n1***2"), 3);
    }
}
