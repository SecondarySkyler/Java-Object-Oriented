package EsInterfaces;

import EsInterfaces.Eccezioni.EmptyIntSetException;
import java.util.Iterator;

/** MISSION
 * Provide an ADT for sets of int.
 * IntSet is mutable, unbounded.
 */
public interface IntSet {

    /**
     * x is added to this set if x is not yet present.
     * MODIFY this set.
     * @param x: the int to be added
     */
    public void insert(int x);

    /**
     * x is removed from this set if x is present.
     * MODIFY this set
     * @param x: the int to be removed
     * @return true if x was removed
     */
    public boolean remove( int x );
    /**
     * set membership
     * @param x
     * @return true if x belongs to the set
     */
    public boolean isIn( int x );
    /**
     * cardinality
     * @return the number of elements in the set
     */
    public int size();

    /**
     * max
     * @return the maximum value of the set
     * @throws EmptyIntSetException if the set is empty
     */
    public int max() throws EmptyIntSetException;
    /**
     * choose a random element of the set
     * @return the choosen element.
     * @throws EmptyIntSetException if the set is empty
     */
    public int choose() throws EmptyIntSetException;

    /**
     * check if two sets have the same values
     * @param s2 REQUIRE not null
     * @return true if this and s2 contain the same values
     */
    public boolean sameValues( IntSet s2 );

    /**
     * @return an iterator on the elements of the set
     */
    public Iterator<Integer> iterator();



}

