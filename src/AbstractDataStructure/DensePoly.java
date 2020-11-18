package AbstractDataStructure;
import java.util.Iterator;
import java.util.Objects;
import java.util.TreeSet;

public class DensePoly {

    private class PolynomialTerm implements Cloneable, Comparable<PolynomialTerm> {
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

        @Override
        public int compareTo(PolynomialTerm o) {
            if(this.exponent < o.exponent) {
                return 1;
            }else {
                return -1;
            }
        }
    }

    private TreeSet<PolynomialTerm> treeTerms;

    /**
     * Default constructor
     */
    public DensePoly() { treeTerms = new TreeSet<PolynomialTerm>(); }

    /**
     *
     * @param c the coefficient
     * @param n the exponent
     * @throws NegativeExponentException when n < 0
     */
    public DensePoly(int c, int n) throws NegativeExponentException {
        if (n < 0) {
            throw new NegativeExponentException("exponent should be positive");
        }
        treeTerms = new TreeSet<PolynomialTerm>();
        if (c != 0) {
            PolynomialTerm ce = new PolynomialTerm(c, n);
            treeTerms.add(ce);
        }
    }

    /**
     * Copy constructor
     * @param p REQUIRE not null
     */
    public DensePoly(DensePoly p) {
        if (p == null)
            throw new NullPointerException("p should not be null");

        this.treeTerms = (TreeSet<PolynomialTerm>) p.treeTerms.clone();
    }

    public DensePoly add(DensePoly p) {
        DensePoly result = new DensePoly();
        int newDegree = Math.max(p.degree(), this.degree());

        for (int i = 0; i <= newDegree; i++) {
            int newCoefficient = p.coefficient(i) + this.coefficient(i);

            if (newCoefficient != 0) {
                PolynomialTerm newTerm = new PolynomialTerm(newCoefficient, i);
                result.treeTerms.add(newTerm);
            }
        }
        return result;
    }

    public int degree() {
        assert (this.treeTerms != null);
        if (this.treeTerms.isEmpty()) {
            return 0;
        }
        int highest = 0;
        for (int i = 0; i < this.treeTerms.size(); i++) {
            PolynomialTerm term = this.treeTerms.first();
            if (term.exponent > highest) {
                highest = term.exponent;
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
        assert (this.treeTerms != null);
        Iterator<DensePoly.PolynomialTerm> it = this.treeTerms.iterator();
        while (it.hasNext()) {
            DensePoly.PolynomialTerm cpe = it.next();
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
    public DensePoly minus() throws NegativeExponentException {
        DensePoly negPoly = new DensePoly();

        for (DensePoly.PolynomialTerm term : this.treeTerms) {
            DensePoly.PolynomialTerm newTerm = new DensePoly.PolynomialTerm(-term.coeff, term.exponent);
            negPoly.treeTerms.add(newTerm);
        }
        return negPoly;
    }

    /**
     *
     * @param p the poly to be multiplied to this; REQUIRE not null
     * @return a new poly that is this * p
     */
    public DensePoly mul(DensePoly p) throws NegativeExponentException {
        DensePoly result = new DensePoly();

        for (int i = 0; i <= p.degree(); i++) {
            for (int j = 0; j <= this.degree(); j++){
                int coeff1 = this.coefficient(j);
                int coeff2 = p.coefficient(i);
                int newCoeff = coeff1 * coeff2;

                if (newCoeff != 0) {
                    DensePoly.PolynomialTerm newTerm = new DensePoly.PolynomialTerm(newCoeff, i+j);
                    result.treeTerms.add(newTerm);
                }
            }
        }
        return result;

    }

    public String toString() {
        assert (this.treeTerms != null);
        StringBuffer s = new StringBuffer();
        Iterator<DensePoly.PolynomialTerm> it = this.treeTerms.iterator();
        while (it.hasNext()) {
            DensePoly.PolynomialTerm cpe = it.next();
            s.append(String.format("+%d*x^%d", cpe.coeff, cpe.exponent));
        }
        return s.toString();
    }
}
