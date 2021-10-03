public class Greeting {
    public static String greet(String name) {
        if (name == null) {
            name = "my friend";
        }

        boolean isUpperCase = name.chars().allMatch(
                Character::isUpperCase
        );

        if (isUpperCase) {
            return String.format("Hello, %s!", name).toUpperCase();
        } else {
            return String.format("Hello, %s.", name);
        }
    }
}
