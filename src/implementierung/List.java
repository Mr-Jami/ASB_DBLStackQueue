package implementierung;

import schnittstellen.IList;
import schnittstellen.IListElement;
import schnittstellen.IValueElement;

public class List implements IList
{
    private IListElement head;

    public List()
    {
        IValueElement dummy = new ValueElement("Dummy (Kopf)", 0);
        this.head = new ListElement(dummy);
        this.head.setPredecessor(null);
        this.head.setSuccessor(null);
    }

    @Override
    public IListElement getHead()
    {
        return this.head;
    }

    @Override
    public void insertAtTheEnd(IValueElement value)
    {
        if (value == null)
        {
            value = new ValueElement("", 0);
        }

        IListElement newElement = new ListElement(value);

        // Prüfen ob Liste leer ist (nur Dummy)
        if (this.head.getSuccessor() == null)
        {
            // Erstes Element nach Dummy
            this.head.setSuccessor(newElement);
            newElement.setPredecessor(this.head);
            newElement.setSuccessor(null);
            this.head.setPredecessor(newElement); // Kopf zeigt auf letztes Element
        }
        else
        {
            // Element am Ende anhängen
            IListElement last = this.head.getPredecessor();
            last.setSuccessor(newElement);
            newElement.setPredecessor(last);
            newElement.setSuccessor(null);
            this.head.setPredecessor(newElement); // Kopf zeigt auf neues letztes Element
        }
    }

    @Override
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

        // Zähle aktuelle Elemente (ohne Dummy)
        int currentSize = countElements();

        if (pos > currentSize)
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
    }

    @Override
    public void deleteFirstOf(IValueElement value)
    {
        if (value == null)
        {
            return;
        }

        IListElement current = this.head.getSuccessor();

        while (current != null)
        {
            if (current.getValueElement() == value)
            {
                // Element entfernen
                IListElement prev = current.getPredecessor();
                IListElement next = current.getSuccessor();

                prev.setSuccessor(next);
                if (next != null)
                {
                    next.setPredecessor(prev);
                }
                else
                {
                    // Letztes Element wird gelöscht
                    this.head.setPredecessor(prev);
                }
                return;
            }
            current = current.getSuccessor();
        }
    }

    @Override
    public void deleteAllOf(IValueElement value)
    {
        if (value == null)
        {
            return;
        }

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
            }
            current = next;
        }
    }

    @Override
    public IValueElement getElementAt(int position)
    {
        if (position <= 0)
        {
            return null;
        }

        IListElement current = this.head;
        for (int i = 0; i < position; i++)
        {
            current = current.getSuccessor();
            if (current == null)
            {
                return null;
            }
        }

        return current.getValueElement();
    }

    @Override
    public int getFirstPosOf(IValueElement value)
    {
        if (value == null)
        {
            return -1;
        }

        IListElement current = this.head;
        int position = 0;

        while (current != null)
        {
            if (current.getValueElement() == value)
            {
                return position;
            }
            current = current.getSuccessor();
            position++;
        }

        return -1;
    }

    @Override
    public boolean member(IValueElement value)
    {
        return getFirstPosOf(value) != -1;
    }

    @Override
    public void reverse()
    {
        // Prüfen ob Liste leer oder nur ein Element hat
        if (this.head.getSuccessor() == null || this.head.getSuccessor().getSuccessor() == null)
        {
            return;
        }

        IListElement current = this.head.getSuccessor();
        IListElement prev = null;
        IListElement first = current; // Erstes Element merken

        // Alle Zeiger umdrehen
        while (current != null)
        {
            IListElement next = current.getSuccessor();
            current.setSuccessor(prev);
            if (prev != null)
            {
                prev.setPredecessor(current);
            }
            prev = current;
            current = next;
        }

        // Head-Zeiger anpassen
        this.head.setSuccessor(prev); // Zeigt auf neues erstes Element
        prev.setPredecessor(this.head);
        this.head.setPredecessor(first); // Zeigt auf neues letztes Element
        first.setSuccessor(null);
    }

    @Override
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

    // Hilfsmethode zum Zählen der Elemente (ohne Dummy)
    private int countElements()
    {
        int count = 0;
        IListElement current = this.head.getSuccessor();
        while (current != null)
        {
            count++;
            current = current.getSuccessor();
        }
        return count;
    }
}