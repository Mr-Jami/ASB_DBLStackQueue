package implementierung;

import schnittstellen.IList;
import schnittstellen.IListElement;
import schnittstellen.IQueue;

public class Queue implements IQueue
{
    private final IList dvl = new List();

    private final int maxSize = 7;

    public IList getDVL()
    {
        return this.dvl;
    }

    public int getSize()
    {
        // Elemente zählen (ohne Dummy)
        int count = 0;
        IListElement current = this.dvl.getHead().getSuccessor();
        while (current != null)
        {
            count++;
            current = current.getSuccessor();
        }
        return count;
    }

    public boolean isEmpty()
    {
        return this.dvl.getHead().getSuccessor() == null;
    }

    public boolean isFull()
    {
        return getSize() >= maxSize;
    }

    public int dequeue()
    {
        if (isEmpty())
        {
            return -1;
        }

        // Erstes Element nach Dummy holen und entfernen
        IListElement first = this.dvl.getHead().getSuccessor();
        int value = first.getValueElement().getValue();
        this.dvl.deleteFirstOf(first.getValueElement());
        return value;
    }

    public void enqueue(int value)
    {
        if (value < 0 || isFull())
        {
            return;
        }

        ValueElement element = new ValueElement("", value);
        this.dvl.insertAtTheEnd(element);
    }

    public int front()
    {
        if (isEmpty())
        {
            return -1;
        }

        IListElement first = this.dvl.getHead().getSuccessor();
        return first.getValueElement().getValue();
    }
}