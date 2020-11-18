package AbstractDataStructure;
import java.util.*;

public class IntBag {

    private Vector<Integer> elements;

    /**
     * Constructor
     * Initialize this as a new set, empty
     */
    public IntBag() {
        this.elements = new Vector<Integer>();
    }

    /**
     * Initialize this to a new set which contains each element of elts
     * Duplicated elements are considered
     * @param elts REQUIRE not null
     */
    public IntBag(int[] elts) {
        this.elements = new Vector<Integer>();
        elts = Objects.requireNonNull(elts);
        for (int x : elts) {
            this.elements.addElement(x);
        }
    }

    /**
     * Copy constructor
     * @param s a set to be duplicated
     */
//    @SuppressWarnings("unchecked")
    public IntBag(IntBag s) {
        s = Objects.requireNonNull(s);
        this.elements = (Vector<Integer>) s.elements.clone();
    }

    /**
     * MODIFY this so x is added to this set even if x is present
     * @param x the element to be added
     */
    public void insert(int x) {
        assert (this.elements != null);
        this.elements.addElement(x);
    }

    /**
     * MODIFY this remove all of the occurrences of x in this
     * @param x the element/elements to remove
     * @return true if x was/were removed
     */
    public boolean remove (int x) {
        assert (this.elements != null);
        boolean res = false;
        for (int i = 0; i < this.elements.size(); i++) {
            if (this.elements.get(i) == x) {
                this.elements.remove(i);
                res = true;
            }
        }
        return res;
    }

    /**
     *
     * @param x
     * @return true if x is present at least once in this
     */
    public boolean isIn(int x) {
        assert (this.elements != null);
        return this.elements.contains(x);
    }

    /**
     * size of this
     * @return the size of the set = number of element in this
     */
    public long size() {
        assert (this.elements != null);
        return this.elements.size();
    }

    /**
     *
     * @return a random element from this
     * @throws EmptyIntBagException if this is empty
     */
    public int choose() throws EmptyIntBagException {
        assert (this.elements != null);
        if (this.elements.isEmpty()) {
            throw new EmptyIntBagException("the set is empty");
        }
        Random random = new Random();
        int x = random.nextInt(this.elements.size());
        return (this.elements.elementAt(x));
    }

    /**
     * Method to check if two set contains the same element
     * @param b2 REQUIRE not null
     * @return true if this and b2 contain the same set of int
     */
    public boolean sameValues(IntBag b2) {
        b2 = Objects.requireNonNull(b2);
        Collections.sort(this.elements);
        Collections.sort(b2.elements);
        boolean result = this.elements.equals(b2.elements);
        return result;
    }

    public String toString() {
        StringBuilder s = new StringBuilder("IntSet: { ");
        Iterator g = elements.iterator();

        while (g.hasNext()) {
            int y = ((Integer) g.next()).intValue();
            s.append(y).append(" ");
        }

        return (s + "}");
    }

    public static void main(String[] args) {
        int[] a = {12, 2, 5, 26, 2, 7};
        int[] b = {12, 2, 5, 26, 2, 7};
        int[] c = {11, 2, 5, 26, 2, 7};
        IntBag newBag = new IntBag(a);
        IntBag newBagB = new IntBag(b);
        IntBag newBagC = new IntBag(c);
//        IntBag copyOf = new IntBag(newBag);
//        newBag.remove(2);
        System.out.println(newBag.isIn(2));
        System.out.println(newBag.size());
        System.out.println(newBag.choose());
        System.out.println(newBag.toString());
        System.out.println(newBag.sameValues(newBagB));
        System.out.println(newBag.sameValues(newBagC));
//        System.out.print(copyOf.toString());
    }
}
