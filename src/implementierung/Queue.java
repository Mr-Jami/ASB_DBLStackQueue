// Queue.java - Korrekte Queue-Implementierung
package implementierung;

import schnittstellen.IList;
import schnittstellen.IQueue;

public class Queue implements IQueue
{
    private final IList DVL = new List();

    private final int MAX_SIZE = 7; // Inklusive Dummy

    public IList getDVL()
    {
        return this.DVL;
    }

    public int getSize()
    {
        return this.DVL.getSize() - 1; // Dummy nicht mitzählen
    }

    public boolean isEmpty()
    {
        return this.DVL.getSize() == 1; // Nur Dummy vorhanden
    }

    public boolean isFull()
    {
        return this.DVL.getSize() >= MAX_SIZE;
    }

    public int dequeue()
    {
        if (isEmpty())
        {
            return -1;
        }

        // Erstes Element nach Dummy (Front der Queue) holen und entfernen
        var frontElement = this.DVL.getElementAt(1);
        this.DVL.deleteFirstOf(frontElement);
        return frontElement.getValue();
    }

    public void enqueue(int value)
    {
        if (value < 0 || isFull())
        {
            return; // Ungültiger Wert oder Queue voll
        }

        ValueElement element = new ValueElement("", value);
        this.DVL.insertAtTheEnd(element);
    }

    public int front()
    {
        if (isEmpty())
        {
            return -1;
        }

        var frontElement = this.DVL.getElementAt(1);
        return frontElement.getValue();
    }
}