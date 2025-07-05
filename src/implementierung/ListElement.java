package implementierung;

import schnittstellen.IListElement;
import schnittstellen.IValueElement;

public class ListElement implements IListElement
{
    private IValueElement valueElement;

    private IListElement predecessor;

    private IListElement successor;

    public ListElement(IValueElement valueElement)
    {
        if (valueElement == null)
        {
            throw new NullPointerException("valueElement is null"); //TODO: should exception be thrown?
        }
        this.valueElement = valueElement;
    }

    public IValueElement getValueElement()
    {
        return this.valueElement;
    }

    public void setValueElement(IValueElement value)
    {
        this.valueElement = value;
    }

    public IListElement getPredecessor()
    {
        return this.predecessor;
    }

    public void setPredecessor(IListElement predecessor)
    {
        this.predecessor = predecessor;
    }

    public IListElement getSuccessor()
    {
        return this.successor;
    }

    public void setSuccessor(IListElement successor)
    {
        this.successor = successor;
    }
}
