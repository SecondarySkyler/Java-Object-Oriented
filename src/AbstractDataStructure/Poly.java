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
