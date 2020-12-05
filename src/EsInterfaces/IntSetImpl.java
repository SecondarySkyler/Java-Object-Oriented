package EsInterfaces;

import EsInterfaces.Eccezioni.EmptyIntSetException;

import java.util.Iterator;
import java.util.Objects;

public abstract class IntSetImpl implements IntSet{
    /**
     *
     * this.currentSize stores the number of elements
     * in the set. It is cached to improve performance.
     *
     * INV:
     * 0 <= this.currentSize &
     * this.currentSize = the cardinality of the set
     */
    protected int currentSize = 0;// protected so that subtypes can change it

    public abstract boolean isIn( int x );
    public abstract int choose() throws EmptyIntSetException;
    public abstract Iterator<Integer> iterator();
    public abstract boolean sameValues( IntSet s2 );

    /** INVARIANT */
    protected boolean invariant() {
        boolean res = this.currentSize >= 0;
        return res;
    }

    /** CONSTRUCTOR */
    public IntSetImpl() {this.currentSize = 0;}

    public IntSetImpl(int[] data) {
        Objects.requireNonNull(data);
        this.currentSize = data.length;
        assert invariant();
    }

    public IntSetImpl(IntSet s ){
        Objects.requireNonNull(s);
        this.currentSize = s.size();
        assert invariant();
    }

    /** METHODS */
    public void insert( int x ) {
        if (this.isIn(x)) {
            this.currentSize++;
        }
        assert invariant();
    }

    public boolean remove( int x ) {
        if (this.isIn(x)) {
            this.currentSize--;
            return true;
        }
        return false;
    }


    public int size(){
        return (this.currentSize);
    }

    public int max() throws EmptyIntSetException{
        // this is a very inefficient implementation
        if (this.size()==0){
            throw new EmptyIntSetException();
        }
        Iterator<Integer> it = this.iterator();
        Integer max = it.next();
        while (it.hasNext()){
            Integer x = it.next();
            if (x>max){
                max = x;
            }
        }
        return (max);
    }


}
