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

        String expected = "HELLO, JOEL!";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void GreetWithTwoNamesShouldJoin() {
        String[] names = {"joel", "noel"};
        String actual = Greeting.greet(names);

        String expected = "Hello, joel and noel.";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void GreetWithMoreNamesShouldJoin() {
        String[] names = {"Joel", "John", "Noel"};
        String actual = Greeting.greet(names);

        String expected = "Hello, Joel, John and Noel.";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void GreetWithMixedNames() {
        String[] names = {"Joel", "John", "NOEL"};
        String actual = Greeting.greet(names);

        String expected = "Hello, Joel and John. AND HELLO NOEL!";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void GreetWithMixedNamesOutOfOrder() {
        String[] names = {"Joel", "JOHN", "Noel", "JAME"};
        String actual = Greeting.greet(names);

        String expected = "Hello, Joel and Noel. AND HELLO JOHN AMD JAME!";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void GreetWithMixedMultipleNames() {
        String[] names = {"Joel", "JOHN", "Noel", "JAME", "MIKEL"};
        String actual = Greeting.greet(names);

        String expected = "Hello, Joel and Noel. AND HELLO JOHN, MIKEL AMD JAME!";
        Assert.assertEquals(expected, actual);
    }
}