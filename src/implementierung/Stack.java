package implementierung;

import schnittstellen.IList;
import schnittstellen.IStack;

public class Stack implements IStack {
    private final IList DVL = new List();
    private final int MAX_SIZE = 7; // Inklusive Dummy

    @Override
    public IList getDVL() {
        return this.DVL;
    }

    @Override
    public int getSize() {
        return this.DVL.getSize() - 1; // Dummy nicht mitzählen
    }

    @Override
    public boolean isEmpty() {
        return this.DVL.getSize() == 1; // Nur Dummy vorhanden
    }

    @Override
    public boolean isFull() {
        return this.DVL.getSize() >= MAX_SIZE;
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            return -1;
        }

        // Letztes Element (Top des Stacks) holen und entfernen
        var topElement = this.DVL.getElementAt(this.DVL.getSize() - 1);
        this.DVL.deleteFirstOf(topElement);
        return topElement.getValue();
    }

    @Override
    public void push(int value) {
        if (value < 0 || isFull()) {
            return; // Ungültiger Wert oder Stack voll
        }

        ValueElement element = new ValueElement("", value);
        this.DVL.insertAtTheEnd(element);
    }

    @Override
    public int top() {
        if (isEmpty()) {
            return -1;
        }

        var topElement = this.DVL.getElementAt(this.DVL.getSize() - 1);
        return topElement.getValue();
    }
}