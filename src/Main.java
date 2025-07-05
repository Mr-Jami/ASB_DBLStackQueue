import implementierung.List;
import implementierung.ValueElement;
import schnittstellen.IList;
import schnittstellen.IValueElement;

public class Main
{
    public static void main(String[] args)
    {
        IList list = new List();
        IValueElement data00 = new ValueElement("K0", 0);
        IValueElement data01 = new ValueElement("K1", 10);
        IValueElement data02 = new ValueElement("K2", 20);
        list.insertAtTheEnd(data00);
        list.insertAtTheEnd(data01);
        list.insertAtTheEnd(data02);
        list.deleteAllOf(data00);
        list.reverse();
    }
}