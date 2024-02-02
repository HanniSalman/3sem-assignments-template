package week01.exercise1;

public class Main {
    interface ArithmeticOperation {
        int perform(int a, int b);
    }

    public static void main(String[] args) {

        ArithmeticOperation addition = (int a, int b) -> a + b;
        ArithmeticOperation substraction = (int a, int b) -> a - b;
        ArithmeticOperation multiplication = (int a, int b) -> a * b;
        ArithmeticOperation division = (int a, int b) -> a / b;
        ArithmeticOperation modulus = (int a, int b) -> a % b;
        ArithmeticOperation power = (int a, int b) -> (int) Math.pow(a, b);

        System.out.println(operate(5,6, addition));
        System.out.println(operate(20,5, substraction));
        System.out.println(operate(10,10, multiplication));
        System.out.println(operate(100,5, division));
        System.out.println(operate(60,13, modulus));
        System.out.println(operate(5,7,power));

    }
    public static int operate(int a, int b, ArithmeticOperation op) {
        return op.perform(a, b);
    }

}
