import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Greeting {

    static String greetFormat(String prefix, String delimiter, String oxford, String lastJoin, String suffix, String... names) {
        names = Arrays.stream(names)
                .filter(Objects::nonNull)
                .toArray(String[]::new);

        String joinedNames;

        List<String> components = new ArrayList<>();

        if (names.length > 1) {
            String nMinusOneNames = Arrays.stream(names)
                    .limit(names.length - 1)
                    .collect(Collectors.joining(delimiter));
            if (names.length > 2) {
                nMinusOneNames += oxford;
            }
            String lastName = names[names.length - 1];
            components.add(nMinusOneNames);
            components.add(lastName);
        } else {
            components.add(names[0]);
        }

        joinedNames = String.join(lastJoin, components);
        return String.format("%s%s%s", prefix, joinedNames, suffix);
    }

    /**
     * @param names are assumed to be lowercase
     * @return
     */
    private static String greetSoft(String... names) {
        return greetFormat("Hello, ", ", ", ",", " and ", ".", names);
    }

    /**
     * @param names are assumed to be uppercase
     * @return
     */
    private static String greetShout(String... names) {
        return greetFormat("HELLO ", ", ", ",", " AND ", "!", names);
    }

    public static String[] splitInput(String input) {
        List<String> inputs = new ArrayList<>();
        String parsed = null;
        boolean isEscaped = false;

        for (char c : input.toCharArray()) {
            if (c == ',') {
                inputs.add(parsed);
                parsed = null;
            } else {
                if (parsed == null) {
                    parsed = "" + c;
                } else {
                    parsed += c;
                }
            }
        }

        if (parsed != null) {
            inputs.add(parsed);
        }

        return inputs.toArray(String[]::new);
    }

    public static String greet(String... names) {
        List<String> lowercaseNames = new ArrayList<>();
        List<String> uppercaseNames = new ArrayList<>();

        for (String nameOrCombined : names) {
            if (nameOrCombined == null) {
                continue;
            }
            String[] splitNames = splitInput(nameOrCombined);
            for (String name : splitNames) {
                name = name.strip();
                if (name.chars().allMatch(Character::isUpperCase)) {
                    uppercaseNames.add(name);
                } else {
                    lowercaseNames.add(name);
                }
            }
        }

        if (uppercaseNames.isEmpty() && lowercaseNames.isEmpty()) {
            return greetSoft(new String[]{"my friend"});
        }

        List<String> components = new ArrayList<>();

        if (!lowercaseNames.isEmpty()) {
            components.add(greetSoft(lowercaseNames.toArray(String[]::new)));
        }
        if (!uppercaseNames.isEmpty()) {
            components.add(greetShout(uppercaseNames.toArray(String[]::new)));
        }

        return components.stream().collect(Collectors.joining(" AND "));
    }
}
