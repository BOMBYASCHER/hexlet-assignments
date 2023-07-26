package exercise;

import java.lang.reflect.Field;
// BEGIN
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
class Validator {
    public static List<String> validate(Address address) {
        List<String> notPassedFields = new ArrayList<>();
        Field[] fields = address.getClass().getDeclaredFields();
        var notNullFields = Arrays.stream(fields)
                .filter(field -> field.isAnnotationPresent(NotNull.class))
                .toList();
        for (Field notNullField : notNullFields) {
            try {
                notNullField.setAccessible(true);
                if (notNullField.get(address) == null) {
                    notPassedFields.add(notNullField.getName());
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return notPassedFields;
    }

    public static Map<String, List<String>> advancedValidate(Address address) {
        Map<String, List<String>> notPassed = new HashMap<>();
        Field[] fields = address.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                if (field.isAnnotationPresent(NotNull.class)) {
                    if (field.get(address) == null) {
                        notPassed.put(field.getName(), List.of("can not be null"));
                    }
                }
                if (field.isAnnotationPresent(MinLength.class)) {
                    int minLength = field.getAnnotation(MinLength.class).minLength();
                    if (field.get(address).toString().length() < minLength) {
                        notPassed.put(field.getName(), List.of("length less than " + minLength));
                    }
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return notPassed;
    }
}
// END
