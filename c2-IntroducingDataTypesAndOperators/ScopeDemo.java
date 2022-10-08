//Demonstrate block scope
public class ScopeDemo {
    public static void main(String[] args){
        int x; //know to all code within main

        x=10;
        if(x == 10){
            int y = 20; //know only to this block
            // x and y both known here
            System.out.println("x and y: " + x + " " + y);
            x = y * 2;
        }
        //y = 100; //Error! y not know here
        //x is still known here
        System.out.println("x is " + x);
    }
}
