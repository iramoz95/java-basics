//Manually thow an exception
class ThrowDemo {
    public static void main(String[] args) {
        try {
            System.out.println("Before throw.");
            throw new ArithmeticException();// Throw an exception
        } catch (ArithmeticException exc) {
            System.out.println("Exception caught.");
        }
        System.out.println("After try/catch block");
    }
}