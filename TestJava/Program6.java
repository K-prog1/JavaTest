public class Program6<E> {

    private static class Entry<E> {
        E element;
        Entry<E> next;
        Entry<E> prev;

        Entry(E element, Entry<E> next, Entry<E> prev) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
    }

    private Entry<E> head;
    private int size = 0;

    public Program6() {
        head = new Entry<>(null, null, null);
        head.next = head;
        head.prev = head;
    }

    public void add(E element) {
        Entry<E> newEntry = new Entry<>(element, head, head.prev);
        newEntry.prev.next = newEntry;
        newEntry.next.prev = newEntry;
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }

        Entry<E> current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    public int size() {
        return size;
    }

    // метод для вывода списка
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Entry<E> current = head.next;
        for (int i = 0; i < size; i++) {
            sb.append(current.element);
            if (i < size - 1) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        Program6<String> list = new Program6<>();

        list.add("A");
        list.add("B");
        list.add("C");

        System.out.println(list); // [A, B, C]

        System.out.println(list.get(0)); // A
        System.out.println(list.get(2)); // C

        // проход через get() в цикле
        for (int i = 0; i < list.size(); i++) {
            System.out.println("Элемент " + i + ": " + list.get(i));
        }
    }
}