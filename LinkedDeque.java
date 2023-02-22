package deques;

/**
 * @see Deque
 */
public class LinkedDeque<T> extends AbstractDeque<T> {
    private int size;
    // IMPORTANT: Do not rename these fields or change their visibility.
    // We access these during grading to test your code.
    Node<T> front;
    Node<T> back;
    // Feel free to add any additional fields you may need, though.

    public LinkedDeque() {
        size = 0;
        front = new Node(0, null, null);
        back = new Node(0, front, null);
        front.next = back;
    }

    public void addFirst(T item) {
        size += 1;
        front.next = new Node(item, front, front.next);
        front.next.next.prev = front.next;
    }

    public void addLast(T item) {
        size += 1;
        back.prev = new Node(item, back.prev, back);
        back.prev.prev.next = back.prev;
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        T item = front.next.value;
        front.next = front.next.next;
        front.next.prev = front;
        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        T item = back.prev.value;
        back.prev = back.prev.prev;
        back.prev.next = back;
        return item;
    }

    public T get(int index) {
        if ((index >= size) || (index < 0)) {
            return null;
        } else if (index <= size / 2) {
            Node toReturn = new Node(null, front, front.next);
            for (int i = -1; i < index; i++) {
                toReturn = toReturn.next;
            }
            T item = (T) toReturn.value;
            return item;
        } else {
            Node toReturn = new Node(null, back.prev, back);
            for (int i = size; i > index; i--) {
                toReturn = toReturn.prev;
            }
            T item = (T) toReturn.value;
            return item;
        }
    }
    public int size() {
        return size;
    }
}
