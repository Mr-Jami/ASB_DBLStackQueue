// Queue.java - Korrekte Queue-Implementierung
package implementierung;

import schnittstellen.IList;
import schnittstellen.IQueue;

//TODO: Queue has max limit of 7 items, including the unchangeable head??
public class Queue implements IQueue
{
    private final IList dvl = new List();

    private final int maxSize = 7; //TODO: mehr als 7 sollte nicht erlaubt sein, inkl. head?

    public IList getDVL()
    {
        return this.dvl;
    }

    public int getSize()
    {
        return this.dvl.getSize() - 1; // without head
    }

    //TODO: includes head as well? if yes, this will never be empty
    public boolean isEmpty()
    {
        return this.dvl.getSize() == 1; // contains head only
    }

    public boolean isFull()
    {
        return this.dvl.getSize() >= maxSize; //TODO: mehr als 7 sollte nicht erlaubt sein, inkl. head?
    }

    //TODO: get first value of list and remove it from the list
    //TODO: how do I know which element waited the most?
    public int dequeue()
    {
        if (isEmpty())
        {
            return -1;
        }

        var frontElement = this.dvl.getElementAt(1);
        this.dvl.deleteFirstOf(frontElement);
        return frontElement.getValue();
    }

    public void enqueue(int value)
    {
        if (value < 0 || isFull())
        {
            return; // invalid value or full TODO: should I throw an exception?
        }

        ValueElement element = new ValueElement("", value); //TODO: what about the name?
        this.dvl.insertAtTheEnd(element);
    }

    public int front()
    {
        //TODO: get first value of list and remove it from the list
        //TODO: how do I know which element waited the most?
        if (isEmpty())
        {
            return -1;
        }

        //TODO: is head first position? because head always remains the same
        var frontElement = this.dvl.getElementAt(1); //skipping head right now
        return frontElement.getValue();
    }
}