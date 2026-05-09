package src;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {

    private int capacity;
    private int size;
    private DLL dll;
    private Map<Integer, DLL.Node> map;

    public Cache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.dll = new DLL();
        this.map = new ConcurrentHashMap<>();
    }

    public void put(int key, String value) {
        if (size >= capacity) {
            System.out.println("Cache Full !!!");
            return;
        }

        if (map.containsKey(key)) {
            System.out.println("Cache already contains the key.");
            return;
        }

        DLL.Node node = this.dll.new Node(null, null, value);
        map.put(key, node);
        dll.add(node);
    }

    public String get(int key) {
        if (map.containsKey(key)) {
            // move node to head
            DLL.Node node = map.get(key);
            this.dll.moveToHead(node);
            return node.value;
        }

        return null;
    }

    public void remove(int key) {
        if (map.containsKey(key)) {
            map.remove(key);
            dll.remove(map.get(key));
            size--;
        }
    }


}
