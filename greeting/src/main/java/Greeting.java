import java.util.Arrays;
import java.util.Objects;

public class Greeting {
    public static String greet(String... names) {
        names = Arrays.stream(names)
                .filter(Objects::nonNull)
                .toArray(String[]::new);

        String joinedNames;

        if (names.length == 0) {
            joinedNames = "my friend";
        } else {
            joinedNames = String.join(" and ", names);
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
