import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimeBasedKeyValueStore {

    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        timeMap.get("foo", 1);         // return "bar"
        System.out.println(timeMap.get("foo", 1));
        timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        System.out.println(timeMap.get("foo", 3));
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        timeMap.get("foo", 4);         // return "bar2"
        System.out.println(timeMap.get("foo", 4));
        timeMap.get("foo", 5);
    }
}


class ValueTimestamp<K, V> {
    private K timestamp;
    private V value;

    ValueTimestamp(K timestamp, V value) {
        this.value = value;
        this.timestamp = timestamp;
    }

    public K getTimestamp() {
        return timestamp;
    }

    public V getValue() {
        return value;
    }
}

class TimeMap {

    HashMap<String, List<ValueTimestamp<Integer, String>>> store;

    public TimeMap() {
        store = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new ArrayList<>()).add(new ValueTimestamp<>(timestamp, value));
    }

    public String get(String key, int timestamp) {
        var values = store.get(key);
        int left = 0, right = values.size() - 1;
        String result = "";
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(values.get(mid).getTimestamp() <= timestamp) {
                result = values.get(mid).getValue();
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
}
