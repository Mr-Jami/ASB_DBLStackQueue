package implementierung;

import schnittstellen.IList;
import schnittstellen.IQueue;

//TODO: Queue has max limit of 7 items, including the unchangeable head??
public class Queue implements IQueue
{
    private IList DVL; //TODO: IList<IValueElement> how should int work in this case?

    private int size; //TODO: do I have to create a private property? or extend ILIST

    public Queue()
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

    public int dequeue()
    {
        //TODO: get first value of list and remove it from the list
        //TODO: how do I know which element waited the most?
        if (!this.isEmpty())
        {
            var firstItem = this.DVL.getHead(); //TODO: is head first position? because head always remains the same
            this.DVL.deleteFirstOf(firstItem.getValueElement());
            return firstItem.getValueElement().getValue();
        }
        return -1;
    }

    public void enqueue(int value)
    {
        if (value < 0)
        {
            throw new IllegalArgumentException("value is negative"); //TODO: should I throw an exception?
        }

        //TODO: add value to first position
        if (!this.isFull())
        {
            this.DVL.insertAtPos(this.getSize(), new ValueElement("", value)); //TODO: what should the name be?
        }
        else
        {
            this.dequeue(); //TODO: should I deque and add a new value or do nothing or throw an exception?
            this.DVL.insertAtPos(this.getSize(), new ValueElement("", value));
        }
    }

    public int front()
    {
        //TODO: get first value of list and remove it from the list
        //TODO: how do I know which element waited the most?
        if (!this.isEmpty())
        {
            var firstItem = this.DVL.getHead(); //TODO: is head first position? because head always remains the same
            return firstItem.getValueElement().getValue();
        }
        return -1;
    }
}
