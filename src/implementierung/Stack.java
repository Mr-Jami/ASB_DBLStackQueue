package implementierung;

import schnittstellen.IList;
import schnittstellen.IStack;

//TODO: stack has max limit of 7 items, including the unchangeable head??
public class Stack implements IStack
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

    public int pop()
    {
        //TODO: get first value of list and remove it from the list
        if (isEmpty())
        {
            return -1;
        }

        //TODO: is head first position? because head always remains the same
        var topElement = this.dvl.getElementAt(this.dvl.getSize() - 1);
        this.dvl.deleteFirstOf(topElement);
        return topElement.getValue();
    }

    public void push(int value)
    {
        if (value < 0 || isFull())
        {
            return; // invalid value or full TODO: should I throw an exception?
        }

        ValueElement element = new ValueElement("", value); //TODO: what about the name?
        this.dvl.insertAtTheEnd(element);
    }

    public int top()
    {
        //TODO: get first value of list
        if (isEmpty())
        {
            return -1;
        }

        //TODO: is head first position? because head always remains the same
        var topElement = this.dvl.getElementAt(this.dvl.getSize() - 1);
        return topElement.getValue();
    }
}