package implementierung;

import schnittstellen.IList;
import schnittstellen.IListElement;
import schnittstellen.IStack;

public class Stack implements IStack
{
    private final IList dvl = new List();

    private final int maxSize = 7;

    @Override
    public IList getDVL()
    {
        return this.dvl;
    }

    @Override
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

    @Override
    public boolean isEmpty()
    {
        return this.dvl.getHead().getSuccessor() == null;
    }

    @Override
    public boolean isFull()
    {
        return getSize() >= maxSize;
    }

    @Override
    public int pop()
    {
        if (isEmpty())
        {
            return -1;
        }

        // Letztes Element finden und entfernen
        IListElement last = this.dvl.getHead().getPredecessor();
        int value = last.getValueElement().getValue();
        this.dvl.deleteFirstOf(last.getValueElement());
        return value;
    }

    @Override
    public void push(int value)
    {
        if (value < 0 || isFull())
        {
            return;
        }

        ValueElement element = new ValueElement("", value);
        this.dvl.insertAtTheEnd(element);
    }

    @Override
    public int top()
    {
        if (isEmpty())
        {
            return -1;
        }

        IListElement last = this.dvl.getHead().getPredecessor();
        return last.getValueElement().getValue();
    }
}