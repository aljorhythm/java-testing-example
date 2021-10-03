
public class Greeting {
    public static String greet(String... names) {
        String joinedNames;

        if (names == null) {
            joinedNames = "my friend";
        } else {
            joinedNames = String.join("and", names);
        }

        boolean isUpperCase = joinedNames.chars().allMatch(
                Character::isUpperCase
        );

        if (isUpperCase) {
            return String.format("Hello, %s!", joinedNames).toUpperCase();
        } else {
            return String.format("Hello, %s.", joinedNames);
        }
    }
}
