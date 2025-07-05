package implementierung;

import schnittstellen.IList;
import schnittstellen.IStack;

//TODO: stack has max limit of 7 items, including the unchangeable head??
public class Stack implements IStack
{
    private final IList DVL = new List(); //TODO: IList<IValueElement> how should int work in this case?

    private int size; //TODO: do I have to create a private property? or extend ILIST
    private final int MIN_SIZE = 0;
    private final int MAX_SIZE = 7;

    public Stack()
    {
    }

    public IList getDVL()
    {
        return this.DVL;
    }

    public int getSize()
    {
        return this.DVL.getSize();
    }

    //TODO: includes head as well? if yes, this will never be empty
    public boolean isEmpty()
    {
        return this.getSize() == this.MIN_SIZE;
    }

    public boolean isFull()
    {
        return this.getSize() >= this.MAX_SIZE; //TODO: mehr als 7 sollte nicht erlaubt sein, inkl. head?
    }

    public int pop()
    {
        //TODO: get first value of list and remove it from the list
        if (!this.isEmpty() && this.getSize() > 1)
        {
            //TODO: is head first position? because head always remains the same
            var firstItem = this.DVL.getElementAt(1);
            this.DVL.deleteFirstOf(firstItem);
            return firstItem.getValue();
        }
        return -1;
    }

    public void push(int value)
    {
        if (value < 0)
        {
            throw new IllegalArgumentException("value is negative"); //TODO: should I throw an exception?
        }

        //TODO: add value to first position
        if (!this.isFull())
        {
            this.DVL.insertAtPos(0, new ValueElement("", value)); //TODO: what should the name be?
        }
        else
        {
            this.pop(); //TODO: should I pop and add a new value or do nothing or throw an exception?
            this.DVL.insertAtPos(0, new ValueElement("", value));
        }
    }

    public int top()
    {
        //TODO: get first value of list
        if (!this.isEmpty() && this.getSize() > 1)
        {
            //TODO: is head first position? because head always remains the same
            var firstItem = this.DVL.getElementAt(1);
            return firstItem.getValue();
        }
        return -1;
    }
}
