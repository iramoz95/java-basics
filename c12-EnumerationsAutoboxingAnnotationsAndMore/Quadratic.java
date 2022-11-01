
// Use static import to bring sqrt() and pow() into view.
import static java.lang.Math.sqrt;
import static java.lang.Math.pow;

// Find the solution to a quadratic equation
class Quadratic {
    public static void main(String[] args) {
        double a, b, c, x;
        a = 4;
        b = 1;
        c = -3;

        x = (-b + sqrt(pow(b, 2) - 4 * a * c)) / (2 * a);
        System.out.println("First solution : " + x);

        x = (-b - sqrt(pow(b, 2) - 4 * a * c)) / (2 * a);
        System.out.println("Second solution : " + x);

    }
}