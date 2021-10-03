import org.junit.Assert;
import org.junit.Test;

public class GreetingTest {
    @Test
    public void GreetWithNameShouldInterpolate() {
        String name = "Joel";
        String actual = Greeting.greet(name);

        String expected = "Hello, Joel.";
        Assert.assertEquals(expected, actual);
    }
}