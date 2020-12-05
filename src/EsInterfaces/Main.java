package EsInterfaces;

public class Main {

    public static void main(String[] args) {
        int[] a = {2, 6, 10, 1, 4};
        UnorderedIntSet set = new UnorderedIntSet(a);
        set.insert(5);
        boolean is = set.isIn(5);
        int dim = set.size();
        System.out.println(dim);
    }
}
