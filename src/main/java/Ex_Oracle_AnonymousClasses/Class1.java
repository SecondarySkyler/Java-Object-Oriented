package Ex_Oracle_AnonymousClasses;

public class Class1 {

    protected InnerClass1 ic;

    public Class1() {
        ic = new InnerClass1();
    }

    public void displayStrings() {
        System.out.println(ic.getString() + ".");
        System.out.println(ic.getAnotherString() + ".");
    }

    public static void main(String[] args) {
        Class1 c1 = new Class1();
        c1.displayStrings();
    }

    /** inner class*/
    protected class InnerClass1 {
        public String getString() {
            return "InnerClass1: getString invoked";
        }

        public String getAnotherString() {
            return "InnerClass1: getAnotherString invoked";
        }
    }
}
