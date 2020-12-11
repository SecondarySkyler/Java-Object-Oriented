package EsInterfaces;

import EsInterfaces.Eccezioni.EmptyIntSetException;

import java.util.Iterator;
import java.util.TreeSet;

public class OrderedIntSet implements IntSet{
    TreeSet<Integer> elements;

    public OrderedIntSet() {
        this.elements = new TreeSet<Integer>();
    }

    @Override
    public void insert(int x) {
        this.elements.add(x);
    }

    @Override
    public boolean remove(int x) {
        return this.elements.remove(x);
    }

    @Override
    public boolean isIn(int x) {
        return this.elements.contains(x);
    }

    @Override
    public int size() {
        return this.elements.size();
    }

    @Override
    public int max() throws EmptyIntSetException {
        if (this.elements == null)
            throw new EmptyIntSetException();
        return this.elements.last();
    }

    @Override
    public int choose() throws EmptyIntSetException {
        if (this.elements == null)
            throw new EmptyIntSetException();

        int random = (int) Math.random() * this.elements.size();
       return this.elements.subSet(random, true, random, true).floor(random);
    }

    @Override
    public boolean sameValues(IntSet s2) {
        boolean res = true;
        if (this.elements.size() != s2.size())
            res = false;

        Iterator<Integer> it = this.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if (!s2.isIn(next))
                res = false;
        }
        return res;
    }

    /**
     * check if this is a subset of s
     * @param s
     * @return true if this is contained in s
     */
    public boolean subSet(IntSet s) {
        boolean res = true;
        if ((s.size() < this.elements.size()))
            res = false;
        Iterator<Integer> it = this.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            if (!s.isIn(next))
                res = false;
        }
        return res;
    }

    @Override
    public Iterator<Integer> iterator() {
        return this.elements.iterator();
    }
}
