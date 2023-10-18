import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.Queue;

public class main<T> {
    private List<T> list;

    public main() {
        // Вы можете выбрать любую коллекцию по умолчанию
        // В этом примере используется ArrayList
        this.list = new ArrayList<>();
    }

    public void addToCollection(T item) {
        list.add(item);
    }

    public void removeFromCollection(T item) {
        list.remove(item);
    }

    public T getElementByIndex(int index) {
        if (index >= 0 && index < list.size()) {
            return list.get(index);
        }
        return null;
    }

    public int getCollectionLength() {
        return list.size();
    }

    // Дополнительные методы для работы с другими типами коллекций

    // Для Stack
    public void pushToStack(T item) {
        if (list instanceof Stack) {
            ((Stack<T>) list).push(item);
        }
    }

    public T popFromStack() {
        if (list instanceof Stack && !list.isEmpty()) {
            return ((Stack<T>) list).pop();
        }
        return null;
    }

    // Для Queue
    public void enqueue(T item) {
        if (list instanceof Queue) {
            ((Queue<T>) list).offer(item);
        }
    }

    public T dequeue() {
        if (list instanceof Queue && !list.isEmpty()) {
            return ((Queue<T>) list).poll();
        }
        return null;
    }

    public static void main(String[] args) {
        // Пример использования
        main<Integer> genericCollection = new main<>();

        genericCollection.addToCollection(1);
        genericCollection.addToCollection(2);
        genericCollection.addToCollection(3);

        System.out.println("Collection length: " + genericCollection.getCollectionLength());

        System.out.println("Element at index 1: " + genericCollection.getElementByIndex(1));

        // Пример использования для Stack
        genericCollection.pushToStack(4);
        System.out.println("Popped from stack: " + genericCollection.popFromStack());

        // Пример использования для Queue
        genericCollection.enqueue(5);
        System.out.println("Dequeued from queue: " + genericCollection.dequeue());
    }
}
