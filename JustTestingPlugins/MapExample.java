import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.Comparator;
import java.util.Objects;


final class UserKey {
    private final int id;
    private final String department;

    public UserKey(int id, String department) {
        this.id = id;
        this.department = department;
    }

    public int getId() { return id; }
    public String getDepartment() { return department; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserKey userKey = (UserKey) o;
        return id == userKey.id && Objects.equals(department, userKey.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, department);
    }
}

public class MapExample {
    public static void main(String[] args) {
        UserKey k1 = new UserKey(3, "IT");
        UserKey k2 = new UserKey(1, "HR");
        UserKey k3 = new UserKey(2, "Finance");

        // HashMap
        Map<UserKey, String> hashMap = new HashMap<>();
        hashMap.put(k1, "Иван");
        hashMap.put(k2, "Анна");
        hashMap.put(k3, "Петр");

        System.out.println("--- HashMap ---");
        for (Map.Entry<UserKey, String> entry : hashMap.entrySet()) {
            System.out.println("ID: " + entry.getKey().getId() + " -> " + entry.getValue());
        }

        // LinkedHashMap
        Map<UserKey, String> linkedMap = new LinkedHashMap<>();
        linkedMap.put(k1, "Иван");
        linkedMap.put(k2, "Анна");
        linkedMap.put(k3, "Петр");

        System.out.println("\n--- LinkedHashMap ---");
        for (Map.Entry<UserKey, String> entry : linkedMap.entrySet()) {
            System.out.println("ID: " + entry.getKey().getId() + " -> " + entry.getValue());
        }

        // TreeMap
        Map<UserKey, String> treeMap = new TreeMap<>(Comparator.comparingInt(UserKey::getId));
        treeMap.put(k1, "Иван");
        treeMap.put(k2, "Анна");
        treeMap.put(k3, "Петр");

        System.out.println("\n--- TreeMap ---");
        for (Map.Entry<UserKey, String> entry : treeMap.entrySet()) {
            System.out.println("ID: " + entry.getKey().getId() + " -> " + entry.getValue());
        }
    }
}
