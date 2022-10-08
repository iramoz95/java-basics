//Use a static block
class StaticBlock {
    static double rootof2;
    static double rootof3;

    // This block is executed when the class is loaded
    static {
        System.out.println("Inside static block");
        rootof2 = Math.sqrt(2.0);
        rootof3 = Math.sqrt(3.0);
    }

    StaticBlock(String msg) {
        System.out.println(msg);
    }
}

class SDemo3 {
    public static void main(String[] args) {
        StaticBlock ob = new StaticBlock("Inside constructor");
        System.out.println("Square root of 2 is " + StaticBlock.rootof2);
        System.out.println("Square root of 3 is " + StaticBlock.rootof3);
    }
}