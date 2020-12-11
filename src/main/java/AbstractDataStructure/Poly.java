package AbstractDataStructure;
import java.util.Iterator;
import java.util.Objects;
import java.util.Vector;

public class Poly {

    private class PolynomialTerm implements Cloneable {
        int coeff;
        int exponent;

        PolynomialTerm(int c, int e) {
            this.coeff = c;
            this.exponent = e;
        }

        PolynomialTerm(PolynomialTerm ce) {
            ce = Objects.requireNonNull(ce);
            this.coeff = ce.coeff;
            this.exponent = ce.exponent;
        }
    }

    private Vector<PolynomialTerm> terms;

    public Poly() {
        terms = new Vector<PolynomialTerm>();
    }

    public Poly(int c, int n) throws NegativeExponentException {
        if (n < 0) {
            throw new NegativeExponentException("exponent should be positive");
        }
        terms = new Vector<PolynomialTerm>();
        if (c != 0) {
            PolynomialTerm ce = new PolynomialTerm(c, n);
            terms.addElement(ce);
        }
    }

    /**
     * Copy constructor
     * @param p REQUIRE not null
     */
    public Poly(Poly p) {
        if (p == null) {
            throw new NullPointerException("p should not be null");
        }
        this.terms = (Vector<PolynomialTerm>) p.terms.clone();
    }

    /**
     * @param p the poly to be added to this; REQUIRE not null
     * @return a new poly that is this + p
     */
    public Poly add(Poly p) {
        Poly resultPoly = new Poly();

        int newDegree = Math.max(p.degree(), this.degree());
        for (int i= 0; i <= newDegree; i++) {
            int newCoefficient = p.coefficient(i) + this.coefficient(i);

            if (newCoefficient != 0) {
                PolynomialTerm newTerm = new PolynomialTerm(newCoefficient, i); //2x + 4x^3
                resultPoly.terms.add(newTerm);
            }
        }
        return resultPoly;
    }

    /**
     *
     * @return the largest exponent in this with non zero coeff or 0 if this is the zero poly
     */
    public int degree() {
        assert (this.terms != null);
        if (this.terms.isEmpty()) {
            return (0);
        }
        int highest = 0;
        for (int i = 0; i < this.terms.size(); i++) {
            PolynomialTerm cpe = this.terms.get(i);

            if (cpe.exponent > highest) {
                highest = cpe.exponent;
            }
        }
        return highest;
    }

    /**
     *
     * @param n an exponent
     * @return the coefficient of the term in this that has exponent n; possibly 0
     */
    public int coefficient(int n) {
        assert (this.terms != null);
        Iterator<PolynomialTerm> it = this.terms.iterator();
        while (it.hasNext()) {
            PolynomialTerm cpe = it.next();
            if (cpe.exponent == n) {
                return cpe.coeff;
            }
        }
        return 0;
    }

    /**
     *
     * @return the poly -(this)
     */
    public Poly minus() throws NegativeExponentException {
        Poly negPoly = new Poly();

        for (PolynomialTerm term : this.terms) {
            PolynomialTerm newTerm = new PolynomialTerm(-term.coeff, term.exponent);
            negPoly.terms.add(newTerm);
        }
        return negPoly;
    }

    /**
     *
     * @param p the poly to be multiplied to this; REQUIRE not null
     * @return a new poly that is this * p
     */
    public Poly mul(Poly p) throws NegativeExponentException {
        Poly result = new Poly();

        for (int i = 0; i <= p.degree(); i++) {
            for (int j = 0; j <= this.degree(); j++){
                int coeff1 = this.coefficient(j);
                int coeff2 = p.coefficient(i);
                int newCoeff = coeff1 * coeff2;

                if (newCoeff != 0) {
                    PolynomialTerm newTerm = new PolynomialTerm(newCoeff, i+j);
                    result.terms.add(newTerm);
                }
            }
        }
        return result;

    }

    /**
     *
     * @return the result of symbolic differentiation of a poly
     * @throws NegativeExponentException if p == null
     */
    public Poly differentiate() throws NegativeExponentException {
        Objects.requireNonNull(this);
        Poly q = new Poly();
        try {
            for (int i = 1; i <= this.degree(); i++) {
                q = q.add(new Poly(this.coefficient(i) * i, i - 1));
            }
        } catch (NegativeExponentException nee) {
            assert false : "this cannot happen";
        }
        return q;
    }

    /**
     *
     * @return the result of symbolic differentiation of a poly
     * @throws NegativeExponentException if the exponent of a polynomial term is < 0
     */
    public Poly differentiate2() throws NegativeExponentException {
        Objects.requireNonNull(this);
        Poly result = new Poly();
        Iterator<Poly> it = termIterator();
        int index = 1;

        while (it.hasNext()){
            Poly next = it.next();
            result = result.add(new Poly(next.coefficient(index) * index, index - 1));
            index++;
        }
        return result;

    }


    /**
     * It produces an iterator on this
     * Allows the extraction of single terms of this, with a non zero coefficient
     */
    public Iterator<Poly> termIterator() {
        Iterator<Poly> it = new Iterator<Poly>() {

            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < terms.size() && terms.get(index) != null;
            }

            @Override
            public Poly next() {
                PolynomialTerm next = terms.get(index);
                Poly result = null;
                try {
                    result = new Poly(next.coeff, next.exponent);
                } catch (NegativeExponentException e) {
                    e.printStackTrace();
                }
                index++;
                return result;
            }
        };
        return it;
    }

    /*
    public void scan () {
        Iterator<Poly> it = termIterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
    */


    /**
     *
     * @return the poly written in form of a string
     */
    public String toString() {
        assert (this.terms != null);
        StringBuffer s = new StringBuffer();
        Iterator<PolynomialTerm> it = this.terms.iterator();
        while (it.hasNext()) {
            PolynomialTerm cpe = it.next();
            s.append(String.format("+%d*x^%d", cpe.coeff, cpe.exponent));
        }
        return s.toString();
    }
}
