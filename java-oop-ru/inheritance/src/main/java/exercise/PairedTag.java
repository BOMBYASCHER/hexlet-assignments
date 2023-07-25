package exercise;

import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    String body;
    List<Tag> leafs;
    PairedTag(String type,
              Map<String, String> map,
              String body,
              List<Tag> leafs
    ) {
        super(type, map);
        this.body = body;
        this.leafs = leafs;
    }
    private String leafsBuilder() {
        return this.leafs.stream()
                .map(Tag::toString)
                .collect(Collectors.joining());
    }
    @Override
    public String toString() {
        return "<"
                + tagName
                + attributeBuilder()
                + ">"
                + body
                + leafsBuilder()
                + "</"
                + tagName
                + ">";
    }
}
// END
