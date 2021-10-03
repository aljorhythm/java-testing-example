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

    @Test
    public void GreetWithNullNameShouldInterpolateStandIn() {
        String name = null;
        String actual = Greeting.greet(name);

        String expected = "Hello, my friend.";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void GreetWithShoutShouldCapitalise() {
        String name = "JOEL";
        String actual = Greeting.greet(name);

        String expected = "HELLO, JOEL.";
        Assert.assertEquals(expected, actual);
    }
}