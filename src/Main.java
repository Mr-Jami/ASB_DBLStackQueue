import implementierung.List;
import implementierung.Queue;
import implementierung.Stack;
import implementierung.ValueElement;
import schnittstellen.IList;
import schnittstellen.IQueue;
import schnittstellen.IStack;
import schnittstellen.IValueElement;

public class Main
{
    public static void main(String[] args)
    {
        testDVL();
        testStack();
        testQueue();
    }

    private static void testDVL()
    {
        System.out.println("=== DVL Test ===");
        IList list = new List();

        // Normale Operationen
        IValueElement data1 = new ValueElement("K1", 10);
        IValueElement data2 = new ValueElement("K2", 20);
        IValueElement data3 = new ValueElement("K3", 30);

        list.insertAtTheEnd(data1);
        list.insertAtTheEnd(data2);
        list.insertAtTheEnd(data3);
        System.out.println("Liste nach Einfügen: " + list.toString());

        // Test mit null-Werten
        System.out.println("\n--- Null-Werte Tests ---");
        list.insertAtTheEnd(null);
        System.out.println("Nach null-Einfügen: " + list.toString());

        list.insertAtPos(2, null);
        System.out.println("Nach null-Einfügen an Position 2: " + list.toString());

        // Position Tests
        System.out.println("\n--- Position Tests ---");
        System.out.println("Element an Position 1: " + list.getElementAt(1));
        System.out.println("Element an Position 0: " + list.getElementAt(0));
        System.out.println("Element an Position 100: " + list.getElementAt(100));

        // Reverse Test
        System.out.println("\n--- Reverse Test ---");
        System.out.println("Vor Reverse: " + list.toString());
        list.reverse();
        System.out.println("Nach Reverse: " + list.toString());

        // Member und Position Tests
        System.out.println("\n--- Member Tests ---");
        System.out.println("data1 ist Mitglied: " + list.member(data1));
        System.out.println("Position von data1: " + list.getFirstPosOf(data1));

        IValueElement notInList = new ValueElement("X", 99);
        System.out.println("notInList ist Mitglied: " + list.member(notInList));
        System.out.println("Position von notInList: " + list.getFirstPosOf(notInList));

        // Delete Tests
        System.out.println("\n--- Delete Tests ---");
        System.out.println("Vor Delete: " + list.toString());
        list.deleteFirstOf(data1);
        System.out.println("Nach deleteFirstOf(" + data1.toString() + "): " + list.toString());

        var newDefaultCreatedObject = new ValueElement("", 0);
        list.deleteAllOf(newDefaultCreatedObject); // Alle Default-Elemente löschen
        System.out.println("Nach deleteAllOf(" + newDefaultCreatedObject.toString() + "): " + list.toString());
    }

    private static void testStack()
    {
        System.out.println("\n=== Stack Test ===");
        IStack stack = new Stack();

        // Normale Operationen
        System.out.println("Stack ist leer: " + stack.isEmpty());
        System.out.println("Stack ist voll: " + stack.isFull());

        System.out.println("\n--- Push Tests ---");
        for (int i = 1; i <= 5; i++)
        {
            stack.push(i * 10);
            System.out.println("Push " + (i * 10) + ", Größe: " + stack.getSize() + ", Top: " + stack.top());
        }

        // Fehlerhafte Werte testen
        System.out.println("\n--- Fehlerhafte Werte Tests ---");
        try
        {
            stack.push(-5);
        }
        catch (Exception e)
        {
            System.out.println("Push -5 (negativ), Größe: " + stack.getSize());
        }

        stack.push(0);
        System.out.println("Push 0 (Grenzwert), Größe: " + stack.getSize());

        // Stack vollmachen
        stack.push(60);
        stack.push(70);
        System.out.println("Stack nach 7 Elementen - Größe: " + stack.getSize() + ", Voll: " + stack.isFull());

        // Überlauf testen
        stack.push(80);
        System.out.println("Push 80 (Überlauf), Größe: " + stack.getSize());

        // Pop Tests
        /*System.out.println("\n--- Pop Tests ---");
        while (!stack.isEmpty()) {
            System.out.println("Pop: " + stack.pop() + ", Größe: " + stack.getSize());
        }*/
        System.out.println("Pop: " + stack.pop() + ", Größe: " + stack.getSize());
        System.out.println("Pop: " + stack.pop() + ", Größe: " + stack.getSize());
        System.out.println("Pop: " + stack.pop() + ", Größe: " + stack.getSize());
        System.out.println("Pop: " + stack.pop() + ", Größe: " + stack.getSize());

        // Pop von leerem Stack
        System.out.println("Pop von leerem Stack: " + stack.pop());
        System.out.println("Top von leerem Stack: " + stack.top());

        System.out.println("DVL nach allen Operationen: " + stack.getDVL().toString());
    }

    private static void testQueue()
    {
        System.out.println("\n=== Queue Test ===");
        IQueue queue = new Queue();

        // Normale Operationen
        System.out.println("Queue ist leer: " + queue.isEmpty());
        System.out.println("Queue ist voll: " + queue.isFull());

        System.out.println("\n--- Enqueue Tests ---");
        for (int i = 1; i <= 5; i++)
        {
            queue.enqueue(i * 10);
            System.out.println("Enqueue " + (i * 10) + ", Größe: " + queue.getSize() + ", Front: " + queue.front());
        }

        // Fehlerhafte Werte testen
        System.out.println("\n--- Fehlerhafte Werte Tests ---");
        try
        {
            queue.enqueue(-3);
        }
        catch (Exception e)
        {
            System.out.println("Enqueue -3 (negativ), Größe: " + queue.getSize());
        }

        queue.enqueue(0);
        System.out.println("Enqueue 0 (Grenzwert), Größe: " + queue.getSize());

        // Queue vollmachen
        queue.enqueue(60);
        queue.enqueue(70);
        System.out.println("Queue nach 7 Elementen - Größe: " + queue.getSize() + ", Voll: " + queue.isFull());

        // Überlauf testen
        queue.enqueue(80);
        System.out.println("Enqueue 80 (Überlauf), Größe: " + queue.getSize());

        // Dequeue Tests
        System.out.println("\n--- Dequeue Tests ---");
        /*while (!queue.isEmpty()) {
            System.out.println("Dequeue: " + queue.dequeue() + ", Größe: " + queue.getSize());
        }*/
        System.out.println("Dequeue: " + queue.dequeue() + ", Größe: " + queue.getSize());
        System.out.println("Dequeue: " + queue.dequeue() + ", Größe: " + queue.getSize());
        System.out.println("Dequeue: " + queue.dequeue() + ", Größe: " + queue.getSize());
        System.out.println("Dequeue: " + queue.dequeue() + ", Größe: " + queue.getSize());

        // Dequeue von leerer Queue
        System.out.println("Dequeue von leerer Queue: " + queue.dequeue());
        System.out.println("Front von leerer Queue: " + queue.front());

        System.out.println("DVL nach allen Operationen: " + queue.getDVL().toString());

        // FIFO-Prinzip demonstrieren
        System.out.println("\n--- FIFO Demonstration ---");
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        System.out.println("Queue: " + queue.getDVL().toString());
        System.out.println("Dequeue (erwartet 100): " + queue.dequeue());
        System.out.println("Dequeue (erwartet 200): " + queue.dequeue());
        System.out.println("Dequeue (erwartet 300): " + queue.dequeue());
    }
}