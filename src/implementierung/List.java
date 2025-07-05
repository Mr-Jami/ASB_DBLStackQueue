package implementierung;

import schnittstellen.IList;
import schnittstellen.IListElement;
import schnittstellen.IValueElement;

public class List implements IList
{
    private IListElement head;

    private int size = 0;

    public List()
    {
        // Dummy-Element als Kopf erstellen
        IValueElement dummy = new ValueElement("Dummy", 0);
        this.head = new ListElement(dummy);
        this.size = 1; // Dummy zählt mit
    }

    public IListElement getHead()
    {
        return this.head;
    }

    public void insertAtTheEnd(IValueElement value)
    {
        if (value == null)
        {
            value = new ValueElement("", 0);
        }

        IListElement newElement = new ListElement(value);

        if (this.size == 1)
        { // Nur Dummy vorhanden
            this.head.setSuccessor(newElement);
            newElement.setPredecessor(this.head);
            this.head.setPredecessor(newElement); // Zirkuläre Verkettung
        }
        else
        {
            IListElement last = this.head.getPredecessor();
            last.setSuccessor(newElement);
            newElement.setPredecessor(last);
            newElement.setSuccessor(null);
            this.head.setPredecessor(newElement);
        }
        this.size++;
    }

    public void insertAtPos(int pos, IValueElement value)
    {
        if (value == null)
        {
            value = new ValueElement("", 0);
        }

        if (pos <= 1)
        {
            pos = 1;
        }

        if (pos >= this.size)
        {
            insertAtTheEnd(value);
            return;
        }

        IListElement newElement = new ListElement(value);
        IListElement current = this.head;

        // Zur gewünschten Position navigieren
        for (int i = 0; i < pos; i++)
        {
            current = current.getSuccessor();
        }

        // Element einfügen
        IListElement prev = current.getPredecessor();
        newElement.setPredecessor(prev);
        newElement.setSuccessor(current);
        prev.setSuccessor(newElement);
        current.setPredecessor(newElement);

        this.size++;
    }

    public void deleteFirstOf(IValueElement value)
    {
        if (value == null)
        {
            return;

        }

        //TODO: should dummy be skipped?
        IListElement current = this.head.getSuccessor();

        while (current != null)
        {
            if (current.getValueElement() == value)
            {
                IListElement prev = current.getPredecessor();
                IListElement next = current.getSuccessor();

                prev.setSuccessor(next);
                if (next != null)
                {
                    next.setPredecessor(prev);
                }
                else
                {
                    this.head.setPredecessor(prev);
                }

                this.size--;
                return;
            }
            current = current.getSuccessor();
        }
    }

    public void deleteAllOf(IValueElement value)
    {
        if (value == null)
        {
            return;
        }

        //TODO: should dummy be skipped?
        IListElement current = this.head.getSuccessor();

        while (current != null)
        {
            IListElement next = current.getSuccessor();

            if (current.getValueElement() == value)
            {
                // Element entfernen
                IListElement prev = current.getPredecessor();

                prev.setSuccessor(next);
                if (next != null)
                {
                    next.setPredecessor(prev);
                }
                else
                {
                    this.head.setPredecessor(prev);
                }

                this.size--;
            }
            current = next;
        }
    }

    public IValueElement getElementAt(int position)
    {
        if (position <= 0 || position >= this.size)
        {
            return null;
        }

        IListElement current = this.head;
        for (int i = 0; i < position; i++)
        {
            current = current.getSuccessor();
        }

        return current.getValueElement();
    }

    public int getFirstPosOf(IValueElement value)
    {
        if (value == null)
        {
            return -1;
        }

        IListElement current = this.head;

        for (int i = 0; i < this.size; i++)
        {
            if (current.getValueElement() == value)
            {
                return i;
            }
            current = current.getSuccessor();
        }

        return -1;
    }

    public boolean member(IValueElement value)
    {
        return getFirstPosOf(value) != -1;
    }

    public void reverse()
    {
        if (this.size <= 2)
        {
            return; // Nur Dummy oder ein Element
        }

        IListElement current = this.head.getSuccessor();
        IListElement prev = null;
        IListElement last = this.head.getPredecessor();

        // Erste Element nach Dummy wird zum letzten
        this.head.setPredecessor(current);

        while (current != null)
        {
            IListElement next = current.getSuccessor();
            current.setSuccessor(prev);
            current.setPredecessor(next);
            prev = current;
            current = next;
        }

        // Head zeigt auf das neue erste Element (vorher letztes)
        this.head.setSuccessor(last);
        last.setPredecessor(this.head);
    }

    //TODO: how does the list look like?
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        IListElement current = this.head;
        boolean first = true;

        while (current != null)
        {
            if (!first)
            {
                sb.append(", ");
            }
            sb.append(current.getValueElement().toString());
            first = false;
            current = current.getSuccessor();
        }

        sb.append("]");
        return sb.toString();
    }

    public int getSize()
    {
        return this.size;
    }
}
