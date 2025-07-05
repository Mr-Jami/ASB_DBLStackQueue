import implementierung.*;
import schnittstellen.*;

public class Main
{
    public static void main(String[] args)
    {
        var myList = new List();
        var elemToDelete = new ValueElement("ElemToDelete", 4711);
        myList.insertAtTheEnd(elemToDelete);
        myList.deleteFirstOf(elemToDelete);
        System.out.println(myList.toString());
    }

}