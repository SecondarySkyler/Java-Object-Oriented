package Ex_Oracle_AnonymousClasses;

public class LambdaExpression {

    interface IntegerMath {
        int operation(int a, int b);
    }

    public int operateBinary(int a, int b, IntegerMath op) {
        return op.operation(a, b);
    }

    public static void main(String[] args) {
        LambdaExpression app = new LambdaExpression();
        IntegerMath addition = ((a, b) -> a + b);
        IntegerMath subtraction = ((a, b) -> a - b);

        System.out.println("40 + 2 = " + app.operateBinary(40, 2, addition));
        System.out.println("20 - 10 = " + app.operateBinary(20, 10, subtraction));
    }
}
