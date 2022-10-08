
/*Java defines four integer types: byte, short, int, long.
* Compute the number of cubic inches in 1 cubic mile*/
public class Integers {
    public static void main(String[] args){
        long ci;
        long im;

        im = 5280 * 12;
        ci = im * im * im;
        System.out.println("There are " + ci +
                " cubic inches in cubic mile");
    }
}
