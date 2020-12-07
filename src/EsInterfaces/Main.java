package EsInterfaces;

import EsInterfaces.Eccezioni.EmptyIntSetException;

public class Main {

    public static void main(String[] args) throws EmptyIntSetException {
        int[] a = {11, 5, 6};
        IntSet set = new UnorderedIntSet(a);
//        set.insert(5);
//        set.remove(6);
//        boolean is = set.isIn(5);
//        boolean is2 = set.isIn(6);
//        int dim = set.size();
//        System.out.println(dim);

        OrderedIntSet ois = new OrderedIntSet();
        ois.insert(5);
        ois.insert(6);
        ois.insert(11);
//        System.out.println(ois.remove(5));
        System.out.println(ois.max());
        System.out.println(ois.isIn(11));
        System.out.println(ois.size());
        System.out.println(ois.sameValues(set));

    }
}
