package implementierung;

import schnittstellen.IList;
import schnittstellen.IStack;

//TODO: stack has max limit of 7 items, including the unchangeable head??
public class Stack implements IStack
{
    private IList DVL; //TODO: IList<IValueElement> how should int work in this case?

    private int size; //TODO: do I have to create a private property? or extend ILIST

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

    public boolean isEmpty()
    {
        return this.getSize() == 0;
    }

    public boolean isFull()
    {
        return this.getSize() == 7;
    }

    public int pop()
    {
        //TODO: get first value of list and remove it from the list
        if (!this.isEmpty())
        {
            var firstItem = this.DVL.getHead(); //TODO: is head first position? because head always remains the same
            this.DVL.deleteFirstOf(firstItem.getValueElement());
            return firstItem.getValueElement().getValue();
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
        if (!this.isEmpty())
        {
            var firstItem = this.DVL.getHead(); //TODO: is head first position? because head always remains the same
            return firstItem.getValueElement().getValue();
        }
        return -1;
    }
}
