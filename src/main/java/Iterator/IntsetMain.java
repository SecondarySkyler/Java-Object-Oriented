package Iterator;

public class IntsetMain {

    public static void main(String[] args) {
        int[] a = {0, 5, 6, 10, 23, 2};
        int[] b = {8, 5, 3, 1, 0};
        IntSet set = new IntSet(b);
        System.out.println(set.toString());
        System.out.print(set.isIn(3));
    }


}
