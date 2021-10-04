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

        String expected = "HELLO JOEL!";
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

        String expected = "Hello, Joel, John, and Noel.";
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
        String[] names = {"Joel", "JOHN", "Noel", "JANE"};
        String actual = Greeting.greet(names);

        String expected = "Hello, Joel and Noel. AND HELLO JOHN AND JANE!";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void GreetWithMixedMultipleNames() {
        String[] names = {"Joel", "JOHN", "Noel", "JANE", "MIKEL"};
        String actual = Greeting.greet(names);

        String expected = "Hello, Joel and Noel. AND HELLO JOHN, JANE, AND MIKEL!";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void GreetWithCombinedInput() {
        String[] names = {"Joel,John"};
        String actual = Greeting.greet(names);

        String expected = "Hello, Joel and John.";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void GreetWithCombinedInputMultiple() {
        String[] names = {"Joel,JOHN", "Noel", "JANE", "MIKEL"};
        String actual = Greeting.greet(names);

        String expected = "Hello, Joel and Noel. AND HELLO JOHN, JANE, AND MIKEL!";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void SplitSingleInputShouldReturnAsIs() {
        String[] actual = Greeting.splitInput("Jane");

        String[] expected = new String[] {"Jane"};
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void SplitSingleEscapedInputShouldReturnAsIs() {
        String escaped = "\"Jane,123\"";
        String[] actual = Greeting.splitInput(escaped);

        String[] expected = new String[] {escaped};
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void SplitMultipleInput() {
        String input = "Jane,JOHN";
        String[] actual = Greeting.splitInput(input);

        String[] expected = new String[] {"Jane", "JOHN"};
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void SplitEscapedInput() {
        String input = "\"Jane, 1!JOHN\", Joel";
        String[] actual = Greeting.splitInput(input);

        String[] expected = new String[] {"Jane, 1!JOHN", "Joel"};
        Assert.assertArrayEquals(expected, actual);
    }
}
