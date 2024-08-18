public class CircularQueue<T> {
    private int top = -1;
    private int base = 0;
    private T[] data;

    public CircularQueue(int size) {
        data = (T[]) new Object[size];
    }

    public void add(T element) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        top = (top + 1) % data.length;
        data[top] = element;
    }

    public T remove() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T removedElement = data[base];
        data[base] = null;
        base = (base + 1) % data.length;
        return removedElement;
    }

    public void clear() {
        top = -1;
        base = 0;
        data = (T[]) new Object[data.length];
    }

    public boolean isFull() {
        return (top + 1) % data.length == base && data[base] != null;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public T[] toArray() {
        return data.clone();
    }
}