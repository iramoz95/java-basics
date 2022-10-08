// A simple example of recursion
class Factorial {
    // This is a recursive function
    int factR(int n) {
        int result;
        if (n == 1)
            return 1;
        result = factR(n - 1) * n;
        System.out.println("Level n = " + n + " Result = " + result);
        return result;
    }

    // This is an iterative equivalent
    int factI(int n) {
        int t, result;
        result = 1;
        for (t = 1; t <= n; t++)
            result *= t;
        return result;
    }
}

class Recursion {
    public static void main(String[] args) {
        Factorial f = new Factorial();

        System.out.println("Factorials using recursive method");
        System.out.println("Factorial of 1 is " + f.factR(1));
        System.out.println("Factorial of 5 is " + f.factR(5));
        System.out.println("Factorial of 10 is " + f.factR(10));
        System.out.println();

        System.out.println("Factorials using iterative method");
        System.out.println("Factorial of 1 is " + f.factI(1));
        System.out.println("Factorial of 5 is " + f.factI(5));
        System.out.println("Factorial of 10 is " + f.factI(10));
        System.out.println();
    }
}