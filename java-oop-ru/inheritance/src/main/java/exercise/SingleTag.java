package exercise;

import java.util.Map;

// BEGIN
class SingleTag extends Tag {
    SingleTag(String type, Map<String, String> map) {
        super(type, map);
    }
    @Override
    public String toString() {
        return "<"
                + super.tagName
                + attributeBuilder()
                + ">";
    }
}
// END
