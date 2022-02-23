package sorting;

public class Elem {
    private int key;
    private Object data;

    public Elem(int key, Object data) {
        this.key = key;
        this.data = data;
    }

    public int getKey() {
        return key;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + data + ')';
    }
}
