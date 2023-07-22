package exercise;

import java.util.Map;

// BEGIN
class FileKV implements KeyValueStorage {
    Map<String, String> data;
    String filePath;
    FileKV(String filePath, Map<String, String> map) {
        this.data = Utils.unserialize(Utils.serialize(map));
        this.filePath = filePath;
        Utils.writeFile(filePath, Utils.serialize(map));
    }
    @Override
    public void set(String key, String value) {
        data.put(key, value);
        Utils.writeFile(filePath, Utils.serialize(data));
    }

    @Override
    public void unset(String key) {
        data.remove(key);
        Utils.writeFile(filePath, Utils.serialize(data));
    }

    @Override
    public String get(String key, String defaultValue) {
        return Utils.unserialize(Utils.readFile(filePath))
                .getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        return Utils.unserialize(Utils.serialize(data));
    }
}
// END
