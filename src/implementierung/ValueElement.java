package implementierung;

import schnittstellen.IValueElement;

public class ValueElement implements IValueElement
{
    private String name;

    private int value;

    public ValueElement(String name, int value)
    {
        this.name = (name != null) ? name : ""; //TODO: should it be an exception?
        this.value = value;
    }

    public ValueElement() //TODO: should I have a default constructor for null valueElements?
    {
        //TODO: what parameters for default/null valueElement
        this("", 0);
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String paramName)
    {
        this.name = (paramName != null) ? paramName : "";
    }

    public int getValue()
    {
        return this.value;
    }

    public void setValue(int paramValue)
    {
        this.value = paramValue;
    }

    //TODO: no definition for it
    public String toString()
    {
        //TODO: how does the list look like?
        return "(" + name + ", " + value + ")";
    }
}
