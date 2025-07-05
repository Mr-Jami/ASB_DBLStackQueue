package implementierung;

import schnittstellen.IValueElement;

public class ValueElement implements IValueElement
{
    private String name;

    private int value;

    public ValueElement(String name, int value)
    {
        if (name == null)
        {
            throw new NullPointerException("Name can't be null"); //TODO: should it be an exception?
        }
        this.name = name;
        this.value = value;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String paramName)
    {
        this.name = paramName;
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
        return "";
    }
}
