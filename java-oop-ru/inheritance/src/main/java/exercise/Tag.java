package exercise;

import java.util.Map;

// BEGIN
abstract class Tag {
    String tagName;
    Map<String, String> structure;

    Tag(String type, Map<String, String> map) {
        this.tagName = type;
        this.structure = map;
    }
    public String attributeBuilder() {
        var sb = new StringBuilder();
        this.structure.forEach((key, value) -> sb.append(" ")
                .append(key)
                .append("=\"")
                .append(value)
                .append("\""));
        return sb.toString();
    }
    public abstract String toString();
}
// END

