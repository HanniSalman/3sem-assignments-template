package week01.exercise2;

public class Main {
    public static void main(String[] args) {
        MyTransformingType adding = (int a) -> a + 3;

        MyValidatingType equals = (int a) -> a == 3;
    }

    interface MyTransformingType {
        int transforming(int a);
    }

    interface MyValidatingType {
        boolean validating(int a);
    }

    private static int[] map(int[] a, MyTransformingType op) {
        int[] result = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            result[i] = op.transforming(a[i]);
        }
        return result;
    }

    private static int[] filter(int[] a, MyValidatingType op) {
        int[] result = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            boolean checker = op.validating(a[i]);

            if (checker == true) {
                result[i] = a[i];
            }
        }
        return result;
    }

}
