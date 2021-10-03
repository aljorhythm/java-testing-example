import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Greeting {
    public static String greet(String... names) {
        names = Arrays.stream(names)
                .filter(Objects::nonNull)
                .toArray(String[]::new);

        String joinedNames;

        if (names.length == 0) {
            joinedNames = "my friend";
        } else {
            List<String> components = new ArrayList<>();

            if (names.length > 1) {
                String nMinusOneNames = Arrays.stream(names)
                        .limit(names.length - 1)
                        .collect(Collectors.joining(", "));
                String lastName = names[names.length - 1];
                components.add(nMinusOneNames);
                components.add(lastName);
            } else {
                components.add(names[0]);
            }

            joinedNames = String.join(" and ", components);
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
