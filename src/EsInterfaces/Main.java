package EsInterfaces;

import EsInterfaces.Eccezioni.EmptyIntSetException;

public class Main {

    public static void main(String[] args) throws EmptyIntSetException {
        int[] a = {2, 48, 3, 11, 4, 56, 6, 10, 5};
        int[] b = {11, 5, 6};
        IntSet set = new UnorderedIntSet(a);
        IntSet set2 = new UnorderedIntSet(b);
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
        System.out.println(ois.sameValues(set2));
        System.out.println(ois.subSet(set));

    }
}
