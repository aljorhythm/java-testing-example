public class Greeting {
    public static String greet(String name) {
        if (name == null) {
            name = "my friend";
        }
        return String.format("Hello, %s.", name);
    }
}
