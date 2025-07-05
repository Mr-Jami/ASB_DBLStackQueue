package implementierung;

import schnittstellen.IList;
import schnittstellen.IListElement;
import schnittstellen.IValueElement;

import java.util.ArrayList;
import java.util.Collections;

public class List implements IList
{
    private final IValueElement dummyValueElement = new ValueElement("Dummy", 0);

    private final java.util.List<IListElement> list = new ArrayList<IListElement>(); //TODO: soll hier ein ArrayList verwendet werden?

    private IListElement head = new ListElement(dummyValueElement);

    public List()
    {
        this.list.addFirst(this.head);
        this.listContentChanged();
    }

    public IListElement getHead()
    {
        this.head = this.list.getFirst(); //TODO: welches Element ist head?
        return this.head;
    }

    public void insertAtTheEnd(IValueElement value)
    {
        var listElement = new ListElement(this.nonNullValueElement(value));
        this.list.addLast(listElement);
        this.listContentChanged();
    }

    public void insertAtPos(int pos, IValueElement value)
    {
        var listElement = new ListElement(this.nonNullValueElement(value));
        if (pos <= 1)
        {
            this.list.add(1, listElement);
        }
        else if (pos > this.list.size())
        {
            this.list.addLast(listElement);
        }
        else
        {
            //TODO: should it add or replace?
            this.list.add(pos, listElement);
        }
        this.listContentChanged();
    }

    public void deleteFirstOf(IValueElement value)
    {
        for (int i = 0; i < this.list.size(); i++)
        {
            if (this.list.get(i).getValueElement() == value)
            {
                this.list.remove(i);
                break;
            }
        }
        this.listContentChanged();
    }

    public void deleteAllOf(IValueElement value)
    {
        this.list.removeIf(listElement -> listElement.getValueElement() == value);
        this.listContentChanged();
    }

    public IValueElement getElementAt(int position)
    {
        if (position <= 0 || position > this.list.size() - 1)
        {
            return null;
        }
        else
        {
            return this.list.get(position).getValueElement();
        }
    }

    public int getFirstPosOf(IValueElement value)
    {
        var firstElement = this.list.stream().filter(listElement -> listElement.getValueElement() == value).findFirst().orElse(null);
        return firstElement == null ? -1 : this.list.indexOf(firstElement);
    }

    public boolean member(IValueElement value)
    {
        var firstElement = this.list.stream().filter(listElement -> listElement.getValueElement() == value).findFirst().orElse(null);
        return firstElement != null;
    }

    public void reverse()
    {
        var firstElement = this.list.removeFirst();
        Collections.reverse(this.list);
        this.list.addFirst(firstElement);
        this.listContentChanged();
    }

    public String toString()
    {
        return ""; //TODO: what should it return???
    }

    public int getSize()
    {
        return this.list.size();
    }

    private IValueElement nonNullValueElement(IValueElement valueElement)
    {
        //TODO: what should the parameters be
        return valueElement == null ? new ValueElement("NULL VALUE", 0) : valueElement;
    }

    private void listContentChanged()
    {
        if (!this.list.isEmpty())
        {
            for (int i = 0; i < this.list.size(); i++)
            {
                var previous = (i > 0) ? list.get(i - 1) : list.size() > 1 ? list.getLast() : null;
                var current = list.get(i);
                var next = (i < list.size() - 1) ? list.get(i + 1) : null;

                current.setPredecessor(previous);
                current.setSuccessor(next);
            }
        }
    }

}
