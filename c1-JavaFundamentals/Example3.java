/*This program illustrates the differences
* between int and double*/
public class Example3 {
    public static void main(String[] args){
        int v;
        double x;
        v = 10;
        x = 10.0;
        System.out.println("Original value of v: " + v);
        System.out.println("Original value of x: " + x);
        System.out.println();
        //now, divide both by 4
        v = v / 4;
        x = x / 4;
        System.out.println("v after division: " + v); //fractional component lost
        System.out.println("x after division " + x); //fractional component preserved
    }
}
