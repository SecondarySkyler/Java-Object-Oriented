package Iterator;

import java.util.Iterator;
import java.util.Objects;
import java.util.Vector;

public class provaIterator {

    public static void main(String[] args) {
        Vector v = new Vector();
        v.add(1);
        v.add("ciao");
        v.add(2);
        v.add(3);
        v.add(4);

        Iterator it = v.iterator();
        Iterator<String> it2 = v.iterator();

        while(it.hasNext()) {
            System.out.println(it.next() + ", ");
        }

        while(it2.hasNext()) {
            Object x = it2.next();
            if (x instanceof String) {
                System.out.print(x);
            }
        }
    }
}
