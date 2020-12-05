package EsInterfaces;

public class Main {

    public static void main(String[] args) {
        int[] a = {2, 6, 10, 1, 4};
        UnorderedIntSet set = new UnorderedIntSet(a);
        set.insert(5);
        set.remove(6);
        boolean is = set.isIn(5);
        boolean is2 = set.isIn(6);
        int dim = set.size();
        System.out.println(dim);
    }
}
