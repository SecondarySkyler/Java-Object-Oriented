package Iterator;

import java.util.*;

public class IntSet_Iterator {

    private Vector<Integer> elements;

    /** EFFECT; initialize this to a new set, empty. */
    public IntSet_Iterator(){
        this.elements = new Vector<Integer>();
    }

    /** @param: elts. REQUIRE be not null.
    EFFECT initialize this to a new set, which contains each element
    of elts; duplicated elements are not considered. */
    public IntSet_Iterator(int [] elts){
        this.elements = new Vector<Integer>();
        Objects.requireNonNull(elts);
        for (int x:elts){
            Integer y = new Integer(x);
            if (!this.elements.contains(y)){
                this.elements.addElement(y);
            }
        }
    }

    /**
     * Copy constructor
     * EFFECT initialize this to a new set that contains all and only the element of s
     * @param s a set to be duplicated. REQUIRE not null
     */
    @SuppressWarnings("unchecked")
    public IntSet_Iterator(IntSet_Iterator s) {
        Objects.requireNonNull(s);
        this.elements = (Vector<Integer>) s.elements.clone();
    }

    /** insert x in this
     * MODIFY this: x is added to this set if x is not present */
    public void insert(int x) {
        if(!this.elements.contains(x)) {
            this.elements.addElement(x);
        }
        assert (this.elements.contains(x));
    }

    /** remove x from this
     * MODIFY this: x is removed to this set if x is present
     @return: true if x was removed */
    public boolean remove(int x) {
        boolean res = this.elements.remove((Integer) x);
        assert (!this.elements.contains(x));
        return res;
    }

    /** check if x belongs to this
     * @return: true if x is present in this */
    public boolean isIn(int x) {
        int index = this.elements.indexOf(x);
        boolean res = (index >= 0);
        assert (!res || this.elements.contains(x)): "res implies (x in elements)";
        return res;
    }


    /** @return: the index of x if it is present in this ; return -1 if not present */
    private int indexOf(Integer x){
        assert (this.elements!=null);
        for (int i=0; i< this.elements.size();i++){
            if (this.elements.get(i).equals(x)){
                return(i);
            }
        }
        return(-1);
    }
    /** cardinality of this
     * @return: the number of elements in this */
    public long size(){
        return (this.elements.size());
    }

    /** choose an element of this
     * @return: a random element in this
     @throws: EmptyIntSetException if this is empty */
    public int choose() throws EmptyIntSetException {
        if (this.elements.isEmpty()) {
            throw new EmptyIntSetException();
        }
        Random randomGenerator = new Random();
        int x = randomGenerator.nextInt(this.elements.size());
        return this.elements.elementAt(x);
    }

    /**
     * @param s2: REQUIRE not null
     * @return true if this and s2 contain the same set of int
     */
    public boolean sameValues(IntSet_Iterator s2) {
        Objects.requireNonNull(s2);
        Collections.sort(this.elements);
        Collections.sort(s2.elements);
        boolean res = this.elements.equals(s2);
        return res;
    }

    /**
     * @return a standard iterator over the Integers of this set. The iterator
     * is not sensible to mutations of this set.
     */
    public Iterator<Integer> iterator() {
        assert (this.elements != null);
        IntSetIterator result = new IntSetIterator(this);
        return (Iterator<Integer>) result;
    }

    /** ========================================================
     *          INNER CLASS for generic iterator
     */


    private class IntSetIterator implements Iterator


}
