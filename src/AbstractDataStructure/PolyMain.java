package AbstractDataStructure;
import java.util.Iterator;
import java.util.Vector;

public class PolyMain {

    public static void main(String[] args) throws NegativeExponentException {

        int c = 2;
        int e = 2;
        int cc = 3;
        int ee = 1;
        Poly ce = new Poly(c, e); // 2x^2
        Poly cce = new Poly(cc, ee); // 3x^1
        Poly copy = new Poly();
        copy = ce.add(cce);
        Poly result = copy.differentiate2();
        System.out.println(result.toString()); //+3*x^1+2*x^2
//        System.out.println(ce.toString());
//        System.out.println(cce.toString());
//        System.out.println(ce.minus().toString());
//        Poly res = cce.differentiate(); //
//        System.out.print(res.toString());





//        DensePoly poly = new DensePoly(c, e);
//        DensePoly poly2 = new DensePoly(cc, ee);
//        System.out.println(poly.toString());
//        System.out.println(poly2.toString());
//        System.out.println(poly.degree());
//        System.out.println(poly2.degree());
//        System.out.println(poly.add(poly2).toString());
//        System.out.println(poly.minus().toString());
//        System.out.print(poly.mul(poly2).toString());


    }
}
